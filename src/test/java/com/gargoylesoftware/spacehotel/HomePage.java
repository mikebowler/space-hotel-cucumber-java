package com.gargoylesoftware.spacehotel;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject {
	@FindBy(id = "login_button")
	private WebElement login_button;

	@Override
	public String getPageUrl() {
		return "http://localhost:3000";
	}
	
	public void login() {
		whenPresent(login_button).click();
	}
}