package mobileautomation.Appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseTest {

	@Test
	public void fillForm() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sanjay Kumar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		// add to cart first two products
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double totalAmount = 0;
		for(int i = 0; i < count; i++) {
			String priceString = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			//remove $ symbol
			Double price = Double.parseDouble(priceString.substring(1));
			totalAmount =  totalAmount + price;
		}
		String displayedTotalString = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		//remove $ symbol
		Double displayedTotal = Double.parseDouble(displayedTotalString.substring(1));
		Assert.assertEquals(totalAmount, displayedTotal);
	}

}
