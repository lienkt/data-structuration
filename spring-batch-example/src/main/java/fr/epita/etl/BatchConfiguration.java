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

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;


	@Bean
	public JdbcCursorItemReader<Contact> reader(DataSource dataSource) {
		JdbcCursorItemReader<Contact> itemReader = new JdbcCursorItemReader();
		itemReader.setDataSource(dataSource);
		itemReader.setSql("select * from contacts");
		itemReader.setRowMapper(new ContactRowMapper());
		return  itemReader;
	}
	
	@Bean
	public ContactItemProcessor processor() {
		return new ContactItemProcessor();
	}
//    .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
	@Bean
	public JdbcBatchItemWriter<Contact> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Contact>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO contacts ("
						+ "contact_email, "
						+ "contact_first_name, "
						+ "contact_last_name, "
						+ "contact_address, "
						+ "contact_city, "
						+ "contact_country, "
						+ "contact_birthdate) "
						+ "VALUES ("
						+ ":email, "
						+ ":firstName, "
						+ ":lastName, "
						+ ":address, "
						+ ":city, "
						+ ":country, "
						+ ":birthdate)")
				.dataSource(dataSource)
				.build();
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1(JdbcCursorItemReader<Contact> reader,JdbcBatchItemWriter<Contact> writer) {
		return stepBuilderFactory.get("step1")
				.<Contact, Contact> chunk(10)
				.reader(reader)
				.processor(processor())
				.writer(writer)
				.build();
	}

}
