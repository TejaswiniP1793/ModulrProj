package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.CommonFun;

public class LoginPage {
	private WebDriver driver;
	
	private String message;
	private CommonFun utilFun=new CommonFun() ;
	
	private By emailId = By.id("username-inp");
	private By passwordLoc = By.id("password-inp");
	private By signInButton = By.id("signInSubmitButton");
	private By forgotPwdLink = By.id("forgotPasswordHref");
	private By errorMessageEmptyFields=By.xpath("//div[@class='alert alert-danger ng-star-inserted']");
	//private String errorMessage="//button[@id='signInSubmitButton']/preceding-sibling::div/p";
	private By errorMessage=By.xpath("//button[@id='signInSubmitButton']/preceding-sibling::*[1]");
	private By accountPageElement=By.xpath("//div/p[text()='Accounts']");
	private By resetPageElement=By.xpath("//*[@id='signInHeading']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	public void enterUserName(String userName) {
		utilFun.waitUntilTime(driver,40,emailId);
		driver.findElement(emailId).sendKeys(userName);
	}

	public void enterPassword(String password) {
		utilFun.waitUntilTime(driver,40,passwordLoc);
		driver.findElement(passwordLoc).sendKeys(password);
	}

	public void clickOnLogin() {
		utilFun.waitUntilTime(driver,40,signInButton);
		driver.findElement(signInButton).click();
	}


	public String getMessage() {
		
			message=driver.findElement(errorMessageEmptyFields).getText();
			return message;	
	}
	public String[] getMessageAndWarning() {
		//JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		//String value = (String)javascriptExecutor.executeScript("document.evaluate(\"//button[@id='signInSubmitButton']/preceding-sibling::div//text()\", document, null, XPathResult.STRING_TYPE, null ).stringValue;");
		utilFun.waitUntilTime(driver,40,errorMessage);
		message=driver.findElement(errorMessage).getText();//getAttribute("innerHTML");
		System.out.println(message);
		String[] temp=message.split("\\n");
		System.out.println(temp.length);
		return temp;
	}
	public boolean checkIfSigninButtonIsEnabled() {
		
		return driver.findElement(signInButton).isEnabled();
		
	}
	public String getPageTitle(){
		return driver.getTitle();
	}
	public void clickOnForgotPassLink() {
		utilFun.waitUntilTime(driver,40,forgotPwdLink);
		driver.findElement(forgotPwdLink).click();
		
	}
	public boolean CheckIfUserOnAcntPage() {
		// TODO Auto-generated method stub
		utilFun.waitUntilTime(driver,40,accountPageElement);
		int numOfElements=driver.findElements(accountPageElement).size();
		  if(numOfElements>0)
			  return true;
		  else
			  return false;
	}
	public boolean CheckIfUserOnResetPwdPage() {
		// TODO Auto-generated method stub
		utilFun.waitUntilTime(driver,40,resetPageElement);
		int numOfElements=driver.findElements(resetPageElement).size();
		if(numOfElements==1)
			  return true;
		  else
			  return false;
	}	
	
}
