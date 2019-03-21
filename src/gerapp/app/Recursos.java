package gerapp.app;

import gerapp.modelo.node.ItemAngular;
import gerapp.modelo.node.ItemComponente;

import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import loopback.cliente.modelo.PaletaCorRest;

public class Recursos {

	private ClasseWrapper classe;
	private Configuracao configuracao;
	
	// Vem do banco de dados
	private List<ClasseWrapper> listaClasse;
	private List<ItemComponente> listaTelaWeb;
	private List<ItemComponente> listaTelaApp;
	
	private PaletaCorRest paletaCor;

	// Item de Trabalho - passar do Java para os templates
	private ItemAngular componente;
		
	public ItemAngular getItemCorrente() {
		return componente;
	}
	public void setItemCorrente(ItemAngular componente) {
		this.componente = componente;
	}
	public List<ItemComponente> getListaTelaWeb() {
		return listaTelaWeb;
	}
	public void setListaTelaWeb(List<ItemComponente> listaTelaWeb) {
		this.listaTelaWeb = listaTelaWeb;
	}
	public void setPaletaCor(PaletaCorRest paleta) {
		this.paletaCor = paleta;
	}
	public PaletaCorRest getPaletaCor() {
		return this.paletaCor;
	}
	
	
	
	public List<ItemComponente> getListaTelaApp() {
		return listaTelaApp;
	}
	public void setListaTelaApp(List<ItemComponente> listaTelaApp) {
		this.listaTelaApp = listaTelaApp;
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
