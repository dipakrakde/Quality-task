package ReadConfigueFile;

import PropertyReader.PropertyRead;

public class ReadPropertyFile {
	
private ReadPropertyFile() {
		
	}
	private static final String PRACTICEPROJECT_FILE = "amazon.properties";
	private static final String PRACTICEPROJECT_IMPLICIT_WAIT = "amazon.implycyt.wait";
	private static final String PRACTICEPROJECT_EXPLICIT_WAIT = "amazon.explicit.wait";
	private static final String PRACTICEPROJECT_BROWSER = "webdriver.browser";
	private static final String AMAZON_BASE_URL = "appurl";

	private static String getProperty(String key) {
		return PropertyRead.getInstance().getProperty(key, PRACTICEPROJECT_FILE);
	}
	
	public static String practiseProjectBrowser() {
		return getProperty(PRACTICEPROJECT_BROWSER);
	}
	
	public static String getImplycitWait() {
		return getProperty(PRACTICEPROJECT_IMPLICIT_WAIT);
	}
	
	public static String getExplycitWait() {
		return getProperty(PRACTICEPROJECT_EXPLICIT_WAIT);
	}
	
	public static String getProprtyFile() {
		return getProperty(PRACTICEPROJECT_FILE);
	}

	public static String getappUrl() {
		return getProperty(AMAZON_BASE_URL);
	}

}

