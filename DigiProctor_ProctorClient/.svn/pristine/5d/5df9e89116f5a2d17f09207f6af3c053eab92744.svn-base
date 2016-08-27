package com.digiproctor.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesConfiguration {
	
	static Properties prop = new Properties();

	public static Properties getPropertiesValue() {
		InputStream input = null;

		try {
			String filename = "com/digiproctor/resources/messages_en.properties";
			input = ApplicationPropertiesConfiguration.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
				}
				prop.load(input);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

}
