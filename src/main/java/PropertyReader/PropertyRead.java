package PropertyReader;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class PropertyRead {
	 private static PropertyRead uniqueInstance;

	  private PropertyRead() {
	  }

	  public static synchronized PropertyRead getInstance() {
	    if (uniqueInstance == null) {
	      uniqueInstance = new PropertyRead();
	    }
	    return uniqueInstance;
	  }

	  public Properties getProperties(String propertyFile) {
	    Properties props = new Properties();
	    Reader reader = null;
	    try {
	      reader = Files.newReader(new File(propertyFile), Charsets.UTF_8);
	      props.load(reader);
	      return props;
	    } catch (IOException e) {
	    } finally {
	      if (reader != null) {
	        try {
	          reader.close();
	        } catch (IOException e) {
	        }
	      }
	    }
	    return props;
	  }

	  public String getProperty(String key, String propertyFile) {
	    return getProperties(propertyFile).getProperty(key);
	  }

	  public String[] getProperties(String key, String propertyFile) {
	    return getProperties(propertyFile).getProperty(key).split(",");
	  }
	}




