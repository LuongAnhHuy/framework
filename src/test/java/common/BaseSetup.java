package common;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseSetup {
    protected WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Please enter the correct Browser name!!!");
        }

        driver.manage().window().setPosition(new Point(0,0));
        driver.get("https://demo.guru99.com/v4/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}

