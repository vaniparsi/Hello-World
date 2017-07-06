package Guru99;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleInterviewScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pradeep\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://sydneytesters.herokuapp.com/");
		
		driver.findElement(By.xpath(".//*[@id='getcarquote']")).click();
		
		Thread.sleep(5000);
		
		String url=driver.getCurrentUrl();
				
		System.out.println(url);
		
		Select s=new Select(driver.findElement(By.xpath(".//*[@id='make']")));
		
		s.selectByIndex(4);
		
		//s.selectByVisibleText("Toyota");
		
		driver.findElement(By.id("year")).sendKeys("2017");
		
		driver.findElement(By.id("age")).sendKeys("32");
		
		System.out.println(driver.findElement(By.id("female")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.id("female")).isSelected());
		
		driver.findElement(By.id("female")).click();
		
		Select s1=new Select(driver.findElement(By.xpath(".//*[@id='state']")));
		
		s1.selectByIndex(1);
		//s1.selectByValue("2");
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Vani.parsi@gmail.com");
		
		WebDriverWait wd=new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.elementToBeClickable(By.xpath(".//form[@id='quoteform']/div[7]/div[2]/button")));
		
		//Thread.sleep(10000);
		
		
		boolean b=driver.findElement(By.xpath(".//form[@id='quoteform']/div[7]/div[2]/button")).isEnabled();
		
		System.out.println(b);
		
	   //	if(b==true)
			Assert.assertTrue(driver.findElement(By.xpath(".//form[@id='quoteform']/div[7]/div[2]/button")).isEnabled());
			
		driver.findElement(By.xpath(".//form[@id='quoteform']/div[7]/div[2]/button")).click();
		
	}

}
