package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFun {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	public void waitUntilTime(WebDriver driver,long unit,By loc) {
		this.driver = driver;
		wait= new WebDriverWait(driver,unit);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
}
