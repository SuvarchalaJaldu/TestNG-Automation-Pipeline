package com.testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreshworksTest {
	WebDriver driver;

@BeforeMethod
@Parameters("browser")
public void setup(String browser)
{
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
	DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browserName", "chrome");
		try {
			driver = new RemoteWebDriver(new URL("http://52.91.113.151:4444/wd/hub"), cap);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.chromedriver().setup();
		//driver = new FirefoxDriver();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browserName", "firefox");
		try {
			driver = new RemoteWebDriver(new URL("http://52.91.113.151:4444/wd/hub"), cap);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get("https://www.freshworks.com/");
}

	@Test
	public void FreshWorksTitleTest() {
        System.out.println(driver.getTitle());
        AssertJUnit.assertEquals(driver.getTitle(), "Innovative Software for Business Needs | Freshworks");
	}

	@Test
	public void getFooterLinksTest() {
        List<WebElement> footerLinksList = driver.findElements(By.cssSelector("#__next > footer > div > div:nth-child(2) > nav a"));
        footerLinksList.forEach(ele -> System.out.println(ele.getText()));
		AssertJUnit.assertEquals(footerLinksList.size(), 22);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
