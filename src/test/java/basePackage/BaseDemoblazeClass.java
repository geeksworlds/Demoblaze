package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import environmentVariables.TimeUtilities;

public class BaseDemoblazeClass {
	
	public static Properties prop = new Properties();    
	public static WebDriver driver;
	
	public BaseDemoblazeClass() {
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\Acer Owner\\Downloads\\DemoBlaze\\src\\test\\java\\environmentVariables\\Config.properties");
		prop.load(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException a) {
			a.printStackTrace();
		}
	}
	
	public static void intiation() {
		String browser = prop.getProperty("browser");
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
}
