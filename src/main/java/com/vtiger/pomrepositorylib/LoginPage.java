package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		}
		
		@FindBy(name= "user_name") 
		private WebElement userName;
		
		@FindBy(name="user_password")
		private WebElement passWord ;
		
		@FindBy(id="submitButton")
		private WebElement loginButton;

		public WebElement getUserName() {
			return userName;
		}

		public WebElement getPassWord() {
			return passWord;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
		
		public void loginToApp(String userNameEdt , String passWordEdt ) {
			userName.sendKeys(userNameEdt);
			passWord.sendKeys(passWordEdt);
			loginButton.click();
	}

}


