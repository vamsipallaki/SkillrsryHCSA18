package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
/**
 * this class contains reusable methods to perform actios on properties file
 * @author PALLAKI VAMSI
 *
 */

public class Propertiesutilitys {

	private Properties property;

	public void propertuesInitialization(String filepath) {
		FileInputStream fis= null;
		try {
			fis= new FileInputStream(filepath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
		property = new Properties();
		
		try {
			property.load(fis);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}
}

