package com.va.quiz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class PropertiesLoader {
	private static final Properties PROPERTIES = new Properties(getDefaultProperties());

	public PropertiesLoader(String propertiesFileName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream propertiesFile = classLoader.getResourceAsStream(propertiesFileName);

		if (propertiesFile == null) {
			throw new RuntimeException("There is no \"" + propertiesFileName + "\" propertie file on classpath.");
		}

		try {
			PROPERTIES.load(propertiesFile);
		} catch (IOException e) {
			throw new PropertiesException("Failed to load  \"" + propertiesFileName + "\" propertie file", e);
		}
	}

	public String getProperty(String key, boolean mustProvide) throws RuntimeException {
		String property = PROPERTIES.getProperty(key);

		if (property == null || property.trim().length() == 0) {
			if (mustProvide) {
				throw new PropertiesException("There is no key \"" + key + "\" " + "in properties file '");
			} else {
				property = null;
			}
		}
		return property;
	}

	private static Properties getDefaultProperties() {
		Properties defaults = new Properties();

		defaults.setProperty("db_user_name", "root");
		defaults.setProperty("db_user_pass", "pass");
		defaults.setProperty("db_conn_string", "jdbc:mysql://localhost/");

		return defaults;
	}
}

class PropertiesException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PropertiesException(String message) {
		super(message);
	}

	public PropertiesException(Throwable cause) {
		super(cause);
	}

	public PropertiesException(String message, Throwable cause) {
		super(message, cause);
	}
}