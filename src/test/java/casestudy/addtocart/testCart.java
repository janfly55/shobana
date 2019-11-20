package casestudy.addtocart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCart {
	WebDriver driver;
  @BeforeTest
  public void Beforetest()
  {
	  driver= Utility.openBrowser("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  }
  @Test
  public void cart() 
	{
		Actions action = new Actions(driver);
		driver.findElement(By.linkText("SignIn")).click();
		Assert.assertEquals("Login",driver.getTitle());
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Assert.assertEquals("Home",driver.getTitle());
		action.moveToElement(driver.findElement(By.linkText("All Categories"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("Electronics"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.linkText("Travel Kit"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals("Search",driver.getTitle());
		driver.findElement(By.linkText("Add to cart")).click();
		
		driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		Assert.assertEquals("View Cart",driver.getTitle());
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
}
}