package com.automatizacion.util;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	private WebDriver driver;
	
	public  Base(WebDriver driver) {
		
		this.driver = driver;
	}
	public WebDriver ChromeConexion() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	public WebElement BuscarElemento (By locator) {
		return driver.findElement(locator);
	}
/*	public List<WebElement> ListarElementos(By locator) {
		return driver.findElements(locator);
	} */
	public String getText(WebElement elemento) {
		return elemento.getText();
	}
	public String FiltergetText(By locator) {
		return driver.findElement(locator).getText();
	}
	public void Digite(String texto, By locator){
		driver.findElement(locator).sendKeys(texto);
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public boolean Visible(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	public void AbrirPagina(String url) {
		driver.get(url);
	}
	public void ENTER(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}
	public void maximizar() {
		driver.manage().window().maximize();
	}
	public void FrameName(String name) {
		driver.switchTo().frame(name);
	}
	public void FrameId(int id) {
		driver.switchTo().frame(id);
	}
	public void Esperar(By locator) {
		WebElement firstResult = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
	}
}
