package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import baseContainer.signupbase;
import utilities.Utility;

public class pagesT extends signupbase{
	Utility utils = new Utility();
	
	String homePageAvatarIcon = OR.getProperty("avatarIcon");
	String emailField = OR.getProperty("emailField");
	String submitBtn = OR.getProperty("SubmitBtn");
	
	public pagesT(WebDriver driver) {
		signupbase.driver = driver;
		PageFactory.initElements(signupbase.driver, this);
	}

	public void clickAvatarIcon() {
		driver.findElement(By.cssSelector(homePageAvatarIcon)).click();
	}
	
	public void clickEmail() {
		driver.findElement(By.id(emailField)).click();
	}
	
	public void typeinEmailField(String key) throws Exception {
		driver.findElement(By.id(emailField)).sendKeys(utils.dataFetcher(key));
	}
	
	public void clickSubmitButton() {
		driver.findElement(By.name(submitBtn)).click();
	}
	
}
