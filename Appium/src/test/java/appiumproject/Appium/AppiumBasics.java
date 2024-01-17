package appiumproject.Appium;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class AppiumBasics extends BaseClass {
	
	
	
	
	
	@Test
	public void start() throws MalformedURLException, InterruptedException {
	
	    // Locators 1)Id, 2)Xpath, 3) accessabilityID, 4) Classname, AndroidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		
		//click Settings
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();    
		
		
		//Verify the PopUp
		
		String txt=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(txt, "WiFi settings");
		
		//Enter Wifiname
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("SundarDass");
				
		//Click Ok button
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1);
		 
	}
	

}
