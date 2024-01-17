package appiumproject.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


interface MyFunction  {
    boolean execute();
}

public class BaseClass  {

	public String targetDevice="Pixel 2 XL API 30";
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	

@BeforeClass
public void configureAppium() throws MalformedURLException {
		service=new AppiumServiceBuilder().
				withAppiumJS(new File("C:\\Users\\sunda\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();
		service.start();
				// To Start driver
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(targetDevice);
		options.setApp("C:\\Users\\sunda\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");                                               
		driver =new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
	}
public void longPress(WebElement element,int milliSec) {
	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
			ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
					"duration",milliSec));
} 
public void scrollUsingUiAutomator(String webElementName) {
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollIntoView(text("+webElementName+")")).click();
}


public Boolean ispresent(String para) {
return	driver.findElement(AppiumBy.accessibilityId(para)).isDisplayed();
};

public void canScrollMore(MyFunction myFunction ) {
	Boolean isTrue ;
	do {
	 isTrue =(Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
		 "left", 100, "top", 100, "width", 200, "height", 200,
		 "direction", "down",
		 "percent", 3.0
		));
	 
	 if(myFunction.execute()) {
		 break;
	}
	
}while(isTrue);

}

	
@AfterClass
	public void tearDown() 
	{
		driver.quit();
		service.stop();

	}
	
	
}
