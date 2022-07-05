package foram;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCase
{
	@org.testng.annotations.Test
	public void Test1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://techextensor.com/");

		for (int i = 0; i < 160; i++)
		{
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
		}

		driver.findElement(By.xpath("//div//ul[@class='list list--primary']//li/a[@href='tech-portfolio.html']"))
				.click();

		List<WebElement> projectName = driver
				.findElements(By.xpath("//*[@id=\"clients-grid\"]/div[1]/div/a/div/div/div[2]"));

		for (WebElement obj : projectName)
		{

			String name = obj.getText();
			System.out.println("this is Project Name :" + name);
		}

		List<WebElement> ProjectURL = driver.findElements(By.xpath("//a[@target='_blank']"));

		for (WebElement pURL : ProjectURL)
		{
			String url = pURL.getText();
			System.out.println("this is Project URL :" + url);
		}

		for (int i = 0; i < 15; i++)
		{
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
		}


	}
}
