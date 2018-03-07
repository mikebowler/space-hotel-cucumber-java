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

	public <T extends PageObject> T navigateTo(Class<T> clazz, Consumer<T> consumer) {
		final T object = (T)newObject(clazz);
		final WebDriver driver = Hooks.driver;

		driver.get(object.getPageUrl());

		PageFactory.initElements(driver, object);
		consumer.accept(object);
		return object;
	}

	public <T extends PageObject> T on(Class<T> clazz, Consumer<T> consumer) {
		final T object = (T)newObject(clazz);
		final WebDriver driver = Hooks.driver;

		PageFactory.initElements(driver, object);
		consumer.accept(object);
		return object;
	}

	private Object newObject(Class<?> clazz) {
		try {
			return clazz.newInstance();
		}
		catch( InstantiationException e ) {
			throw new RuntimeException(e);
		}
		catch( IllegalAccessException e ) {
			throw new RuntimeException(e);
		}
	}
}
