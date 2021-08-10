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

import fr.epita.etl.BatchProcessingApplication;
import fr.epita.etl.Contact;
import fr.epita.etl.ItemState;

/**
 * The Prepare Email Processor
 * @author LienKT
 */

public class PrepareEmailProcessor implements ItemProcessor<Contact, ItemState> {

	private static final Logger log = LoggerFactory.getLogger(PrepareEmailProcessor.class);

	@Override
	public ItemState process(final Contact contact) throws Exception {
		final String email = contact.getEmail();
		final String firstName = contact.getFirstName();
		final String city = contact.getCity();
		
		String content = readEmailTemplate(city, firstName);
		writePreparedEmail(email, content);
		
		final ItemState itemState = new ItemState(email, BatchProcessingApplication.prop.getProperty("app.state.ready"));
		log.info("Preparing email (" + itemState + ")");
		return itemState;
	}
	
	private String readEmailTemplate(String city, String firstName) throws IOException {
		Path filePath = Paths.get(BatchProcessingApplication.prop.getProperty("app.campaign.html"));
	    String content = Files.readString(filePath);
	    content = content.replace("${firstName}", firstName);
	    content = content.replace("${city}", city);
	    return content;
	}
	
	private void writePreparedEmail(String email, String content) throws IOException {
		String filePath = BatchProcessingApplication.prop.getProperty("app.email.pool") + "email-" + email + "-body.html";
		Path path = Paths.get(filePath);
        // check exists for file
        if (!Files.exists(path)) {
    		new File(filePath);
        }

		FileWriter myWriter = new FileWriter(filePath);
	    myWriter.write(content);
	    myWriter.close();
		
	}
}
