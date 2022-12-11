package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getDriverBrowser(String browserName) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("106.0.5249.21").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		return driver;
	}
	
	protected WebDriver getDriverBrowser(String browserName, String url) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("106.0.5249.21").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}
	public int genarateRanomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
