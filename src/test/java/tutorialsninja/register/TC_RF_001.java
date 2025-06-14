package tutorialsninja.register;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
	
	@Test
	public void verifyRegisteringWithMandatoryFields() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']"));
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Soumali");
		driver.findElement(By.id("input-lastname")).sendKeys("Mukherjee");
		driver.findElement(By.id("input-email")).sendKeys("soumali0607@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("+917908926895");
		driver.findElement(By.id("input-password")).sendKeys("Megha@99");
		driver.findElement(By.id("input-confirm")).sendKeys("Megha@99");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(((WebElement) driver.findElements(By.xpath("//div[@id='common-success']//h1"))).getText(), expectedHeading);
		
		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shop, please e-mail the store owner.";
		String actualProperDetailsThree = "A confirmation has been sent to the provided e-mail address. If you have not received it within an hour, please contact us.";
		String actualProperDetailsFour = "contact us";
		
		String expectedProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	

	public String generateNewEmail() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	}

} 
