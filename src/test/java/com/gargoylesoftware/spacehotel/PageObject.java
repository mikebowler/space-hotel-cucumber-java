package com.gargoylesoftware.spacehotel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.PageFactory;
import java.util.function.Function;

public class PageObject {
	public String getPageUrl() {
		throw new UnsupportedOperationException("Page url not set for this class: "+getClass().getName());
	}

	public WebElement whenPresent(final By by) {
		return Hooks.wait.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		} );
	}

	public WebElement whenPresent(final WebElement element) {
		// Note that using an xpath is fairly inefficient but we couldn't
		// see a better/faster way. We're waiting until the element finds
		// itself and then returning.
		return Hooks.wait.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element.findElement(By.xpath("."));
			}
		} );
	}

}