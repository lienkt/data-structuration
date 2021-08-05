package fr.epita.etl;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.epita.etl.processors.ContactItemProcessor;
import fr.epita.etl.processors.PrepareEmailProcessor;

/**
 * The Batch Configuration
 * @author LienKT
 */

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public JdbcCursorItemReader<Contact> reader(DataSource dataSource) {
		JdbcCursorItemReader<Contact> itemReader = new JdbcCursorItemReader<Contact>();
		itemReader.setDataSource(dataSource);
		itemReader.setSql("select * from contacts");
		itemReader.setRowMapper(new ContactRowMapper());
		return  itemReader;
	}
	
	@Bean
	public ContactItemProcessor processor() {
		return new ContactItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<ItemState> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<ItemState>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO item_state ("
						+ "email, "
						+ "state) "
						+ "VALUES ("
						+ ":email, "
						+ ":state)")
				.dataSource(dataSource)
				.build();
	}

	@Bean
	public Job importStateJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1(JdbcCursorItemReader<Contact> reader,JdbcBatchItemWriter<ItemState> writer) {
		return stepBuilderFactory.get("step1")
				.<Contact, ItemState> chunk(10)
				.reader(reader)
				.processor(processor())
				.writer(writer)
				.build();
	}

	@Bean
	public JdbcCursorItemReader<Contact> prepareEmailReader(DataSource dataSource) {
		JdbcCursorItemReader<Contact> itemReader = new JdbcCursorItemReader<Contact>();
		itemReader.setDataSource(dataSource);
		itemReader.setSql("SELECT "
				+ "contact_email, "
				+ "contact_first_name, "
				+ "contact_last_name, "
				+ "contact_address, "
				+ "contact_city, "
				+ "contact_country, "
				+ "contact_birthdate "
				+ "FROM contacts "
				+ "INNER JOIN item_state "
				+ "ON email = contact_email");
		itemReader.setRowMapper(new ContactRowMapper());
		return  itemReader;
	}

	@Bean
	public PrepareEmailProcessor prepareEmailProcessor() {
		return new PrepareEmailProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<ItemState> prepareEmailWriter(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<ItemState>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("UPDATE item_state "
						+ "SET state = :state "
						+ "WHERE email = :email ")
				.dataSource(dataSource)
				.build();
	}

	@Bean
	public Job prepareEmailJob(JobCompletionNotificationListener listener, Step step2) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step2)
				.end()
				.build();
	}

	@Bean
	public Step step2(JdbcCursorItemReader<Contact> prepareEmailReader,JdbcBatchItemWriter<ItemState> prepareEmailWriter) {
		return stepBuilderFactory.get("step2")
				.<Contact, ItemState> chunk(10)
				.reader(prepareEmailReader)
				.processor(prepareEmailProcessor())
				.writer(prepareEmailWriter)
				.build();
	}

}
