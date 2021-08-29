package testesSOC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.testng.AssertJUnit;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import pages.BlogPage;

public class TesteBuscaNoBlog {

	private BlogPage page;

	@BeforeMethod
	public void inicializa(){
		getDriver().get("https://www.soc.com.br/blog/");
		page = new BlogPage();
	}

	@AfterMethod
	public void finaliza(){
		killDriver();
	}

	@Epic("EPIC - Busca no Blog")
	@Feature("FEATURE - Pesquisa Hero")
	@Step("Pesquisa pela Hero")
	@Link("https://https://ww2.soc.com.br/blog/")
	@Description("Pesquisa feita pelo Hero Header da página")
	@Test
	public void realizarBuscaHero(){
		page.setPesquisaHero("Teste de busca");
		page.clicarBotaoPesquisaHero();
		AssertJUnit.assertEquals("Search Results for: Teste de busca"
				,page.getTextoResultadoBusca());
	}

	@Epic("EPIC - Busca no Blog")
	@Feature("FEATURE - Pesquisa Header")
	@Step("Pesquisa pelo Cabeçalho")
	@Link("https://https://ww2.soc.com.br/blog/")
	@Description("Pesquisa feita pelo botão no Header")
	@Test
	public void realizarBuscaHeader(){
		page.clicarBotaoPesquisaHeader();
		page.setPesquisaHeader("Teste de busca");
		AssertJUnit.assertEquals("Search Results for: Teste de busca"
				,page.getTextoResultadoBusca());
	}
}
