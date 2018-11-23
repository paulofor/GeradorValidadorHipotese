package gerapp.app;

import gerapp.modelo.node.ItemAngular;
import gerapp.modelo.node.ModuloComponente;

import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaWebWrapper;

public class Recursos {

	private ClasseWrapper classe;
	private Configuracao configuracao;
	
	// Vem do banco de dados
	private List<ClasseWrapper> listaClasse;
	private List<ItemAngular> listaTelaWeb;

	// Item de Trabalho - passar do Java para os templates
	private ItemAngular componente;
		
	public ItemAngular getItemCorrente() {
		return componente;
	}
	public void setItemCorrente(ItemAngular componente) {
		this.componente = componente;
	}
	public List<ItemAngular> getListaTelaWeb() {
		return listaTelaWeb;
	}
	public void setListaTelaWeb(List<ItemAngular> listaTelaWeb) {
		this.listaTelaWeb = listaTelaWeb;
	}
	
	
	
	public void setListaClasse(List<ClasseWrapper> listaClasse) {
		this.listaClasse = listaClasse;
	}
	public List<ClasseWrapper> getListaClasse() {
		return this.listaClasse;
	}
	
	public void setClasse(ClasseWrapper classe) {
		this.classe = classe;
	}
	public ClasseWrapper getClasse() {
		return this.classe;
	}
	
	public void setConfiguracao(Configuracao dado) {
		this.configuracao = dado;
	}
	public Configuracao getConfiguracao() {
		return this.configuracao;
	}
}
