package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DSL {

	//--------------genericos-----------

	public void escreve(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	public void escreve(By by, String texto, Keys keys) {
		getDriver().findElement(by).sendKeys(texto,keys);
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	public void clicar(String classe) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("document.getElementsByClassName("+classe+")[0].click()");
	}
	public String getTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	public void aguardarElementClick(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	public void aguardarElemento(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public WebElement retornaElemento(By by) {
		return getDriver().findElement(by);
	}
	public void executaScript(String script,WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(script, el);
	}

	//-------------------page SOCNET----------------------------

	public void selecionaFiltro(String name) {
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("document.getElementsByClassName('expand-filtros')[0].click()");
	js.executeScript("document.getElementsByClassName('section-sidenav filtros-busca ')[0].scrollTop=500");
	js.executeScript("document.getElementsByName('"+name+"')[0].click()");
	}

	public void aguardarLoader() {
	WebDriverWait wait = new WebDriverWait(getDriver(),20);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("div-carregando-operacao")));
	}

	public void selecionaPerfil() {
		Actions builder = new Actions(getDriver());
		 WebElement element = getDriver().findElement(By.className("empresa-visualizacao-mapa"));
		 builder.moveToElement(element).build().perform();
		 getDriver().findElement(By.xpath("//a[@href='/perfil']/button")).click();
	}

}
