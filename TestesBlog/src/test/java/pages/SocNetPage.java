package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import core.DSL;




public class SocNetPage {

	private DSL dsl;

	public SocNetPage() {
		dsl = new DSL();
	}
	public void escreverInputCidade(String texto) {
		dsl.aguardarElemento( By.id("ipt-busca-credenciado-2"));
		dsl.escreve(By.id("ipt-busca-credenciado-2"), texto,Keys.ENTER);
		dsl.aguardarLoader();
		dsl.clicar(By.id("botao-buscar"));
		dsl.aguardarLoader();

	}
	public String resultadoBuscaEmpresa() {
		return dsl.getTexto(By.className("cnpj-empresa"));
	}
	public void aguardarElemento(By by) {
		dsl.aguardarElemento( by);
	}
	public void clicarFiltro(String nome) {
		dsl.aguardarElemento( By.id("div-filtro-conveniencias"));
		dsl.selecionaFiltro(nome);

	}

	public void clicarEmpresaSaibaMais() {
		dsl.selecionaPerfil();
	}

}
