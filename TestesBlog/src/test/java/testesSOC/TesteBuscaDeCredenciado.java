package testesSOC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.AllureListener;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import pages.SocNetPage;
import pages.SocPage;

@Listeners(AllureListener.class)
public class TesteBuscaDeCredenciado {
	private SocPage pageSoc;
	private SocNetPage pageNet;

	@BeforeMethod
	public void inicializa(){
		getDriver().get("https://www.soc.com.br/");
		pageSoc = new SocPage();
		pageNet = new SocNetPage();
	}

	@AfterMethod
	public void finaliza(){
		killDriver();
	}

	@Epic("EPIC - Busca de Credenciado")
	@Feature("FEATURE - Buscar perfil de credenciado")
	@Step("Busca pela Rede SOCNET")
	@Link("https://www.soc.com.br/socnet/")
	@Description("Buscar pela Rede SOCNET e acessar perfil do credenciado")
	@Test
	public void buscaDeCredenciado(){
		pageSoc.clicarJs(By.xpath("//section[@class='solucoes-soc']//*[@href='https://www.soc.com.br/socnet/']"));
		pageSoc.clicarBotaoBuscarCredenciados();

		//mudança de página

		pageNet.escreverInputCidade("Santos, SP, Brasil");
		pageNet.clicarFiltro("15");
		pageNet.clicarEmpresaSaibaMais();

		AssertJUnit.assertEquals("02.327.325/0001-09"
				,pageNet.resultadoBuscaEmpresa());
	}

}
