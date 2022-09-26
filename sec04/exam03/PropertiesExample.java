package ch15.sec04.exam03;

import java.util.Properties;
import java.io.IOException;

public class PropertiesExample {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));
		
		String driver= properties.getProperty("driver");
		String url= properties.getProperty("url");
		String username= properties.getProperty("username");
		String password= properties.getProperty("password");
		String adimn= properties.getProperty("admin");
		
		System.out.println("driver"+driver);
	}

}
