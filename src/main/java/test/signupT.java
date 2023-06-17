package test;

import org.testng.annotations.Test;

import baseContainer.signupbase;
import pages.pagesT;
import utilities.Utility;

public class signupT extends signupbase{
	@Test
	public void signup() throws Exception {
		Utility utils = new Utility();
		pagesT sign = new pagesT(driver);
		
		sign.clickAvatarIcon();
		sign.clickEmail();
		sign.typeinEmailField("email");
		sign.clickSubmitButton();
	}
}
