package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.DSL;

public class SocPage {

	private DSL dsl;

	public SocPage() {
		dsl = new DSL();
	}

	public void clicarJs(By by) {
		WebElement element = dsl.retornaElemento(by);
		dsl.executaScript("arguments[0].click();", element);

	}
	public void clicarBotaoBuscarCredenciados() {
		String xpathString = "//span[.='Buscar credenciados']/..";
		dsl.aguardarElementClick(By.xpath(xpathString));
		dsl.clicar(By.xpath(xpathString));
	}

}
