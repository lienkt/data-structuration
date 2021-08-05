package fr.epita.etl.processors;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import fr.epita.etl.Contact;
import fr.epita.etl.ItemState;

public class ContactItemProcessor implements ItemProcessor<Contact, ItemState> {

	private static final Logger log = LoggerFactory.getLogger(ContactItemProcessor.class);
    public static final String SELECTED_STATE = "selected for campaign";
    public static final String READY_STATE = "email ready";
    public static final String SENT_STATE = "email sent";

	@Override
	public ItemState process(final Contact contact) throws Exception {
		final String email = contact.getEmail();
//		final String firstName = contact.getFirstName().toUpperCase();
//		final String lastName = contact.getLastName().toUpperCase();
//		final String address = contact.getAddress().toUpperCase();
//		final String city = contact.getCity().toUpperCase();
//		final String country = contact.getCountry().toUpperCase();
		final Date birthDate = contact.getBirthdate();
		
//		final Contact transformedContact = new Contact(email, firstName, lastName, address, city, country,
//				birthDate);
//		log.info("Converting (" + contact + ") into (" + transformedContact + ")");
//		return transformedContact;

		Date currentDate = new Date();
		@SuppressWarnings("deprecation")
		int age = currentDate.getYear() - birthDate.getYear();
		if (age >= 0 && age <=30) {
			final ItemState itemState = new ItemState(email, SELECTED_STATE);
			log.info("Creating (" + itemState + ")");
			return itemState;
		}
		return null;
	}
}
