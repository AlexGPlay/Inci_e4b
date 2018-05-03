package com.uniovi.selenium;


import org.junit.After;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.selenium.pageobject.PO_LoginView;
import com.uniovi.selenium.pageobject.PO_NavView;
import com.uniovi.selenium.pageobject.PO_View;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InciDashboardTests {

//	Ruta Firefox en Windows
//	static String PathFirefox = "C:\\Path\\FirefoxPortable.exe";
	static String PathFirefox = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";

	static WebDriver driver = getDriver(PathFirefox);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	
	/**
	 * Inicio de sesión con datos válidos.
	 */
	@Test
	public void P01LogVal() {

		PO_NavView.clickOption(driver, "login", "class", "btn btn-primary");

		PO_LoginView.fillForm(driver, "111111Z", "123456");
	
		PO_View.checkElement(driver, "text", "Notificaciones");

	}
	
	
	/**
	 * Inicio de sesión con datos no válidos.
	 */
	@Test
	public void P02LogInVal() {

		PO_NavView.clickOption(driver, "login", "class", "btn btn-primary");

		PO_LoginView.fillForm(driver, "11111Z", "123456");
	
		PO_View.checkElement(driver, "text", "DNI o contraseña invalidos");

	}
	
	

	// Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

}
