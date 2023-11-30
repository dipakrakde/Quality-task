package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {


	public static Properties initializePropertyFile()  {

		Properties property = new Properties();
		File file = new File(System.getProperty("user.dir")+ "src//test//resources//ConfigeFile//confige.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			property.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return property;
	}
}
