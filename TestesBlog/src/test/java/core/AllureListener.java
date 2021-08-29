package core;
import static core.DriverFactory.getDriver;

import java.io.ByteArrayInputStream;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.qameta.allure.Allure;

public class AllureListener extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("Execute listener on failure");
	WebDriver driver = getDriver();
	try {
		Allure.addAttachment(UUID.randomUUID().toString(),
				new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("Execute listener on success");
	WebDriver driver = getDriver();
	try {
		Allure.addAttachment(UUID.randomUUID().toString(),
				new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
