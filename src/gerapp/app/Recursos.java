package gerapp.app;

import java.util.List;

import jet.wrappers.base.ClasseWrapper;

public class Recursos {

	private ClasseWrapper classe;
	private Configuracao configuracao;
	private List<ClasseWrapper> listaClasse;
	
	
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
