package GithubVerification.gitvfy_art;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class frst {

	public static WebDriver driver;
	
@BeforeMethod(alwaysRun = true)
public void test()
{

	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//chromedriver.exe");
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	//update from 2
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	
	
}

@Test(groups= {"Smoke"})

public void radiobtn()
{
	// driver = new ChromeDriver();driver.manage().window().maximize();driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	int count_radioBtn = driver.findElement(By.id("radio-btn-example")).findElements(By.tagName("label")).size();
	
	
	System.out.println(count_radioBtn);
}

@Test()

public void Autosuggestion() throws InterruptedException
{
	 //driver = new ChromeDriver();driver.manage().window().maximize();driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.findElement(By.id("autocomplete")).sendKeys("IND");
	
	List<WebElement> countries = driver.findElements(By.cssSelector("#ui-id-1 li"));
	
	
	System.out.println( driver.findElements(By.cssSelector("#ui-id-1 li")).get(0).getText());
	
	for(WebElement ctry : countries)
	{
		if(ctry.getText().equalsIgnoreCase("india"))
		{
			ctry.click();
			Thread.sleep(2000);
			break;
		}
	}
}



@AfterMethod(alwaysRun = true)

public void tearDown()
{
	driver.quit();
}


}
