package com.gargoylesoftware.spacehotel;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;

public class Hooks {
	public static WebDriver driver;
	public static Wait<WebDriver> wait;

	@Before
	public void beforeScenario() {
		driver = new ChromeDriver();
		wait = new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
			.pollingEvery(1, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);
	}

	@After
	public void afterScenario() {
		driver.close();
	}
}