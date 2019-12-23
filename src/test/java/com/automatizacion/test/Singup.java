package com.automatizacion.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.automatizacion.project.BusquedaGoogleExcel;
import com.automatizacion.project.Google;
import com.automatizacion.util.LecturaExcel;

public class Singup {

	private WebDriver driver;
	private LecturaExcel read;
	private Google google;
	private String url;
	private String rutaexcel;
	private int row;
	private String hoja;
	
	
	public Singup(String url, String ruta, int row, String hoja) {
		this.url = url;
		this.rutaexcel = ruta;
		this.row = row;
		this.hoja = hoja;
	}
	
	@Before
	public void setUp() throws Exception {
		google = new Google(driver);
		driver = google.ChromeConexion();
		read = new LecturaExcel();
		google.AbrirPagina(url);
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws IOException {
		String filepath = rutaexcel;
		String email = read.LeerValorCelda(filepath,hoja, row, 0);
		String pass = read.LeerValorCelda(filepath,hoja,row, 1).toString();
		google.Singup(pass,email);
	}

}
