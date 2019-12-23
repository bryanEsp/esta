package com.automatizacion.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automatizacion.util.Base;

public class Google extends Base {

	By email = By.id("identifierId");
	By passw = By.name("password");
	
	public Google(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void Singup(String pass, String correo) {
		maximizar();
			Digite(correo,email);
			ENTER(email);
			Esperar(passw);
			Digite(pass,passw);
			ENTER(passw);

	}
	
}
