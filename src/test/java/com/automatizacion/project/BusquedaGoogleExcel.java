package com.automatizacion.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automatizacion.util.Base;

public class BusquedaGoogleExcel extends Base {
	By buscador = By.name("q");
	By boton = By.name("btnK");
	
	public BusquedaGoogleExcel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void buscador(String valor) {
		maximizar();
		if (Visible(buscador)){
			Digite(valor,buscador);
			Esperar(boton);
			click(boton);
		}else {
			System.out.println("No se encontro el elemento");
		}
	}
	
}
