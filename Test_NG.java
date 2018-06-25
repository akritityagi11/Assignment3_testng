package tatoc.tatoc1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class Test_NG {

	WebDriver driver;

@BeforeTest
public void SetDriver(){
	System.setProperty("web.chrome.drive", "/home/qainfotech/workspace/tatoc1/chromedriver");
	driver = new ChromeDriver();
}
	
@Test(priority = 10)
public void start(){
	driver.get("http://10.0.1.86/tatoc");
	//Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc");
			WebElement element = driver.findElement(By.cssSelector("a[href*='basic']"));
			 
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).build().perform();
	 
	        //action.click();
			//driver.findElement(By.linkText("Basic Course")).click();
			Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc");
}

@Test(priority = 20)
public void test(){
	driver.findElement(By.cssSelector("a[href*='basic']")).click();
	Assert.assertTrue(driver.findElement(By.className("greenbox")).isDisplayed());
	driver.findElement(By.className("greenbox")).click();
	System.out.println("Green box is displayed");
	}

@Test(priority = 30)
public void repaint(){
	driver.switchTo().frame(0);
	WebElement box1 = driver.findElement(By.id("answer"));
	String Box1_color = box1.getAttribute("class");
	String Box2_color = "";
	while (!Box1_color.equals(Box2_color)) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("a")).click();
		driver.switchTo().frame(0);
		Box2_color = driver.findElement(By.id("answer")).getAttribute("class");
	}
	driver.switchTo().defaultContent();
	driver.switchTo().frame(0);
	Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/basic/frame/dungeon");
	driver.findElement(By.linkText("Proceed")).click();
	driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();
}

@Test(priority = 40)
public void re() {
	Assert.assertTrue(driver.findElement(By.id("dragbox")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.id("dropbox")).isDisplayed());
	driver.findElement(By.linkText("Proceed")).click();

}



	
}
