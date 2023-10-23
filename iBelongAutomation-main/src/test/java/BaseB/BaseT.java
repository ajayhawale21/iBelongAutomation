package BaseB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import PageOrder.EventsPage;
import PageOrder.OverviewPage;
import PageOrder.UsersPage;


public class BaseT {
	public static WebDriver driver;
	public static Properties prop;
	public OverviewPage ov = null;
	public EventsPage ev=null;
	
	
	

	public static String ReadConfig(String key) {
		try {
			prop = new Properties();
			// FileInputStream ip=new FileInputStream
			// ("C:\\Users\\Brigosha_Guest\\eclipse-workspace\\Hiring-Management\\configs\\config.properties");
			FileInputStream ip = new FileInputStream("./configs\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = prop.getProperty(key);
		return str;
	}

	// @SuppressWarnings("deprecation")
	@BeforeSuite
	public static void initilization() throws InterruptedException {
		String browserName = ReadConfig("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Brigosha_Guest\\eclipse-workspace\\iBelong\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Brigosha_Guest\\eclipse-workspace\\Hiring-Management\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ReadConfig("url"));

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void objectInitiate() {
		
		ov = new OverviewPage(driver);
		ev=new EventsPage(driver);
	}

	public void waittill(int wait) throws InterruptedException {
		Thread.sleep(3000);

	}

}

	

