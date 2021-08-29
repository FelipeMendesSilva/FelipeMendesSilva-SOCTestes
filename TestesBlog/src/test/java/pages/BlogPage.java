package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import core.DSL;



public class BlogPage {
private DSL dsl;

	public BlogPage() {
		dsl = new DSL();
	}

	public void setPesquisaHero(String texto) {
		dsl.aguardarElementClick(By.xpath("(//input[@name=\"s\"])[3]"));
		dsl.escreve(By.xpath("(//input[@name=\"s\"])[3]"), texto);
	}
	public void setPesquisaHeader(String texto) {
		dsl.aguardarElementClick(By.xpath("(.//input[@name=\"s\"])[1]"));
		dsl.escreve(By.xpath("(//input[@name=\"s\"])[1]"), texto,Keys.ENTER);

	}
	public void clicarBotaoPesquisaHero() {
		dsl.aguardarElementClick(By.xpath(".//button[@class=\"elementor-search-form__submit\"]"));
		dsl.clicar(By.xpath("//button[@class=\"elementor-search-form__submit\"]"));
	}
	public void clicarBotaoPesquisaHeader() {
		dsl.aguardarElementClick(By.xpath(".//div[@class=\"elementor-search-form__toggle\"]"));
		dsl.clicar(By.xpath("//div[@class=\"elementor-search-form__toggle\"]"));
	}

	public String getTextoResultadoBusca() {
		dsl.aguardarElementClick(By.xpath("//h2[contains(text(),'Search Results for')]"));
		return dsl.getTexto(By.xpath("//h2[contains(text(),'Search Results for')]"));
	}
}
