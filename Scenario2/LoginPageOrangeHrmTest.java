package com.OrangeHRM.Scenario2;

import org.testng.annotations.Test;

import com.OrangeHRM.Base.BaseClass;

public class LoginPageOrangeHrmTest extends BaseClass{
	
	
	

	@Test(priority=1)
	public void verifyTitle() {
		lp.getTitle();
		
	}
	
	@Test(priority=2)
	public void ValidateLogin() {
		lp.doLogin();
}
}
		