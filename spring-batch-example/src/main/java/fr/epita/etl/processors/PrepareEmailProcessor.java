package fr.epita.etl.processors;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import fr.epita.etl.Contact;
import fr.epita.etl.ItemState;

public class PrepareEmailProcessor implements ItemProcessor<Contact, ItemState> {

	private static final Logger log = LoggerFactory.getLogger(PrepareEmailProcessor.class);
    public static final String SELECTED_STATE = "selected for campaign";
    public static final String READY_STATE = "email ready";
    public static final String SENT_STATE = "email sent";

	@Override
	public ItemState process(final Contact contact) throws Exception {
		final String email = contact.getEmail();
		final String firstName = contact.getFirstName();
//		final String lastName = contact.getLastName().toUpperCase();
//		final String address = contact.getAddress().toUpperCase();
		final String city = contact.getCity();
//		final String country = contact.getCountry().toUpperCase();
//		final Date birthDate = contact.getBirthdate();
		
		String content = readEmailTemplate(city, firstName);
		writePreparedEmail(email, content);
		
		final ItemState itemState = new ItemState(email, READY_STATE);
		log.info("Preparing email (" + itemState + ")");
		return itemState;
	}
	
	private String readEmailTemplate(String city, String firstName) throws IOException {
		Path filePath = Paths.get("src/main/resources/campaign-free-gift-template.html");
	    String content = Files.readString(filePath);
	    System.out.println("Before replace");
	    //${city} ${firstName}
	    content = content.replace("${firstName}", firstName);
	    content = content.replace("${city}", city);
//	    System.out.println(content);
	    return content;
	}
	
	private void writePreparedEmail(String email, String content) throws IOException {
		String filePath = "src/main/resources/email-spool/email-" + email + "-body.html";
		Path path = Paths.get(filePath);
        // check exists for file
        if (!Files.exists(path)) {
    		File file = new File(filePath);
//    		if (file.exists()) {
//    		} else {
//    			System.out.println("File doesn't exists.");
//    		}
        }

		FileWriter myWriter = new FileWriter(filePath);
	    myWriter.write(content);
	    myWriter.close();
		
	}
}
