package fr.epita.etl.processors;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import fr.epita.etl.BatchProcessingApplication;
import fr.epita.etl.Contact;
import fr.epita.etl.ItemState;

/**
 * The Contact Item Processor
 * @author LienKT
 */

public class ContactItemProcessor implements ItemProcessor<Contact, ItemState> {

	private static final Logger log = LoggerFactory.getLogger(ContactItemProcessor.class);

	@Override
	public ItemState process(final Contact contact) throws Exception {
		final String email = contact.getEmail();
		final Date birthDate = contact.getBirthdate();
		Date currentDate = new Date();
		@SuppressWarnings("deprecation")
		int age = currentDate.getYear() - birthDate.getYear();
		if (age >= BatchProcessingApplication.minAge && age <= BatchProcessingApplication.maxAge) {
			final ItemState itemState = new ItemState(email, BatchProcessingApplication.prop.getProperty("app.state.selected"));
			log.info("Creating (" + itemState + ")");
			return itemState;
		}
		return null;
	}
}
