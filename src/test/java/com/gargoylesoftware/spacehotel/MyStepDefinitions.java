package com.gargoylesoftware.spacehotel;

import cucumber.api.java8.En;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;

public class MyStepDefinitions extends AbstractStepDefinition implements En {

	public MyStepDefinitions() {
		Given("^I am logged in as (.+)$", (String name) -> {
			navigateTo(HomePage.class, (HomePage page) -> {
				page.login();
			});
			
			on(LoginPage.class, (LoginPage page) -> {
				page.login(name);
			} );
		});

		When("^I look at the offers$", () -> {
		});

		Then("^I should see these$", () -> {
		});	
	}

}