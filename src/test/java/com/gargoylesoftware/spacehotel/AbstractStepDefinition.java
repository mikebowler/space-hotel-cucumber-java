package com.gargoylesoftware.spacehotel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import java.util.function.Consumer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractStepDefinition {

	public <T extends PageObject> void navigateTo(Class<T> clazz, Consumer<T> consumer) {
		final T object = newObject(clazz);
		final WebDriver driver = Hooks.driver;

		driver.get(object.getPageUrl());
		PageFactory.initElements(driver, object);

		consumer.accept(object);
	}

	public <T extends PageObject> void on(Class<T> clazz, Consumer<T> consumer) {
		consumer.accept(PageFactory.initElements(Hooks.driver, clazz));
	}

	// Match the behaviour of PageFactory
	private <T> T newObject(Class<?> clazz) {
		try {
			return (T)clazz.newInstance();
		}
		catch( InstantiationException e ) {
			throw new RuntimeException(e);
		}
		catch( IllegalAccessException e ) {
			throw new RuntimeException(e);
		}
	}
}
