package baseContainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Utility;

public class signupbase {
	public static WebDriver driver;
	 public static Properties config = new Properties();
	 public static FileInputStream fis;
	 public static Properties OR = new Properties();
	 public static String browser;
	 Utility utils = new Utility();
	 
	 String projectlocation = System.getProperty("user.dir");
	 
	 @BeforeTest
	 public void setup() {
		 if(driver==null) {
			 try {
				 fis = new FileInputStream (projectlocation+"/src/main/resources/propertyFiles/config.properties");
			 } catch(FileNotFoundException e) {
				 e.printStackTrace();
			 }
			 try {
				 config.load(fis);
			 } catch(IOException m) {
				 m.printStackTrace();
			 }
			 
			 try {
				 fis = new FileInputStream (projectlocation+"/src/main/resources/propertyFiles/OR.properties");
			 } catch(FileNotFoundException orf) {
				 orf.printStackTrace();
			 }
			 try {
				 OR.load(fis);
			 } catch(IOException orj) {
				 orj.printStackTrace();
			 }
		 }
		 
		 if (System.getenv("browser") != null && System.getenv("browser").isEmpty()) {
			 
			 browser = System.getenv("browser");
		 }
		 else{
			 
			 browser = config.getProperty("browser");
		 }
		 config.setProperty("browser", browser);
		 
		 if(config.getProperty("browser").equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 driver.get(config.getProperty("baseUrl"));
		 
		 driver.manage().window().maximize();
	 }
	 	@AfterTest
		 public void tearDown() {
	    	 driver.close();
	    	 driver.quit(); 
	     }
}
