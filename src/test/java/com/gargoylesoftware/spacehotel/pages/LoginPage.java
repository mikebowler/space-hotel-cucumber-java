package com.gargoylesoftware.spacehotel.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginPage extends PageObject {
	@FindBy(id = "userid")
	private WebElement userid;

	@FindBy(id = "password")
	private WebElement password;

	public void login(String name) {
		whenPresent(userid).sendKeys(name);
		password.sendKeys("topsecret\n");
	}
}