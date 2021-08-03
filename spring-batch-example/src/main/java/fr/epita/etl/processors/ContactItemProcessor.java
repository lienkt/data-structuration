package fr.epita.etl.processors;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import fr.epita.etl.Contact;

public class ContactItemProcessor implements ItemProcessor<Contact, Contact> {

	private static final Logger log = LoggerFactory.getLogger(ContactItemProcessor.class);

	@Override
	public Contact process(final Contact contact) throws Exception {
		final String email = contact.getEmail().toUpperCase();
		final String firstName = contact.getFirstName().toUpperCase();
		final String lastName = contact.getLastName().toUpperCase();
		final String address = contact.getAddress().toUpperCase();
		final String city = contact.getCity().toUpperCase();
		final String country = contact.getCountry().toUpperCase();
		final Date birthDate = contact.getBirthdate();
		
		final Contact transformedContact = new Contact(email, firstName, lastName, address, city, country,
				birthDate);

		log.info("Converting (" + contact + ") into (" + transformedContact + ")");

		return transformedContact;
	}
}
