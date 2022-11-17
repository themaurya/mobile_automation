package mobileautomation.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class GestureLongPress extends BaseTest {

	@Test
	public void gestureLongPress() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		Thread.sleep(500);
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement wele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		logPressAction(wele);
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId", ((RemoteWebElement) wele).getId(),
//				"duration" , 2000));
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		String title = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(title, "Sample menu");
	}
}
