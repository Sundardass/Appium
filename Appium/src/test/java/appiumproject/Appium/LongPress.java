package appiumproject.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseClass {


	
	@Test
	public void start() throws MalformedURLException, InterruptedException {
	
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
	driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	
	final WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	
	
	boolean canScrollMore;
	do {
		 canScrollMore =(Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
			 "left", 100, "top", 100, "width", 200, "height", 200,
			 "direction", "down",
			 "percent", 3.0
			));
	}while(canScrollMore);
	
	
	
	longPress(ele, 2000);
	scrollUsingUiAutomator("Web View");
	
	
	canScrollMore(new MyFunction() {
	    @Override
	    public boolean execute() {
	       return ispresent("");
	    }
	});
	
	
}};
