package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Common_Steps {
    private WebDriver driver;

    @Before
    public void setUp() {
	System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");

	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() throws InterruptedException {
	driver.quit();
	Thread.sleep(1000);
    }

    public WebDriver getDriver() {
	return this.driver;
    }
}
