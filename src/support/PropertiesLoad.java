package support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoad {
	
	public static Properties loadProperties() {
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			String filename = "config.properties";
			input = PropertiesLoad.class.getClassLoader().getResourceAsStream(filename);
			if(input == null) {
				System.out.printf("Unable to find %s \n", filename);
				System.exit(1);
			}
			
			// Load a properties file from class path, inside static method
			prop.load(input);
			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		} 
		return null;
	}

}
