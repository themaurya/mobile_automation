package mobileautomation.Appium;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class GestureScroll extends BaseTest {

	@Test
	public void gestureScroll() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Using Android UI Automator : use when where to scroll is known
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Web View\"))"));
		
		// using JavaScript : use when you have to scroll till end
//		boolean canScrollMore;
//		do {
//		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "down",
//			    "percent", 1
//			));
//		} while(canScrollMore);
		
		scrollToEndAction();
	}
}
