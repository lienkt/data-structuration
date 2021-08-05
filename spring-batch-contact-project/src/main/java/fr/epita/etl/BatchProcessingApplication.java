package fr.epita.etl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Batch Processing Application
 * @author LienKT
 */

@SpringBootApplication
public class BatchProcessingApplication {
    public static int minAge = 0;
    public static int maxAge = 0;
    public static Properties prop = new Properties();
    
	public static void main(String[] args) throws Exception {
		readProperties();
		readCampaign();
		System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication.class, args)));
	}

    public static void readProperties() throws IOException {
    	InputStream input = new FileInputStream("src/main/resources/config/config.properties");
        prop.load(input);
    }
    
    public static void readCampaign() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File(prop.getProperty("app.campaign.json")));
        JsonNode target = jsonNode.get("target");
        minAge = target.get("minimum_age").asInt();
        maxAge = target.get("maximum_age").asInt();
    }

}
