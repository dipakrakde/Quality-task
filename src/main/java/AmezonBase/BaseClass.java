package AmezonBase;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public  org.apache.log4j.Logger logger;
	public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter reporter;
    public ExtentTest test;

    public WebDriver driver;
    
	@BeforeSuite
	public void starttestCase() throws InterruptedException {

        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        reporter = new ExtentSparkReporter(path);
		
	}
	
	@AfterSuite
	public void endtestCase() {
		extent.attachReporter(reporter);
		extent.flush();
	}
	
	@BeforeClass	
	public void logGenerator() {
	    logger= org.apache.log4j.Logger.getLogger("***** Amazon Test Case Started *****");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("***** Test Case Starting ****** ");
	}


}
