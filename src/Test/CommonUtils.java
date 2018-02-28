package Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;


public class CommonUtils {

	// private final static Logger logger = Logger.getLogger(CommonUtils.class);
	private static final String CONFIG_PROPERTY_FILE_PATH = "C:\\Users\\user\\workspace\\CC\\src\\config.properties";
//	private static final String CONFIG_PROPERTY_FILE_PATH = ".src/config.properties";

	
	public static String currentDateFileName(String prefix) {
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-hh_mm_ss");
		String formattedTime = formatter.format(new Date());
		return (StringUtils.isEmpty(prefix) ? formattedTime : prefix
				+ formattedTime);
	}

	
	public static String readFromConfig(String input)
			throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(CONFIG_PROPERTY_FILE_PATH));
		String returnVal = properties.getProperty(input);
		return returnVal;
	}

	
	public static String getHostOperatingSystem() {
		String osName = System.getProperty("os.name");
		// logger.info("Current Host Operating System is identified as " +
		// osName);
		return osName;
	}


	public static String getUserName() {
	     String uName = System.getProperty("user.name");
	     return uName;
	    }
	public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
                
     }
	public static String getRandomNumber(int length) {
        final String characters = "1234567890";
        StringBuilder result = new StringBuilder();
        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
                
     }
	
	
}
