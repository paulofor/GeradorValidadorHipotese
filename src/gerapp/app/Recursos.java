package gerapp.app;

import gerapp.modelo.ComponenteTela;

import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaWebWrapper;

public class Recursos {

	private ClasseWrapper classe;
	private Configuracao configuracao;
	private List<ClasseWrapper> listaClasse;
	private List<TelaWebWrapper> listaTelaWeb;
	
	private TelaWebWrapper telaWeb;
	private ComponenteTela componente;
	
	public TelaWebWrapper getTelaWebCorrente() {
		return telaWeb;
	}
	public void setTelaWebCorrente(TelaWebWrapper tela) {
		this.telaWeb = tela;
	}
	
	public ComponenteTela getComponente() {
		return componente;
	}
	public void setComponente(ComponenteTela componente) {
		this.componente = componente;
	}
	public List<TelaWebWrapper> getListaTelaWeb() {
		return listaTelaWeb;
	}
	public void setListaTelaWeb(List<TelaWebWrapper> listaTelaWeb) {
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
