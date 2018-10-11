package gerapp.app;


import gerapp.modelo.Aplicacao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jet.wrappers.base.ClasseWrapper;

public class AplicacaoWrapper {

	private static Map<Long,ClasseWrapper> entidades;
	
	public static void setEntidades(List<ClasseWrapper> lista) {
		entidades = new HashMap<Long,ClasseWrapper>();
		Iterator<ClasseWrapper> itEntidade = lista.iterator();
		while (itEntidade.hasNext()) {
			ClasseWrapper ent = itEntidade.next();
			entidades.put(ent.getId(), ent);
		}
	}
	public static ClasseWrapper getPorId(long id) {
		return entidades.get(id);
	}
	
	private Aplicacao aplicacao;
	public void setAplicacao(Aplicacao dado) {
		aplicacao = dado;
	}
	
	public AplicacaoWrapper(Aplicacao app) {
		this.aplicacao = app;
	}
	
	public long getId() {
		return aplicacao.getIdAplicacao();
	}
	public String getNamespacePacote() {
		return aplicacao.getNamespace().toLowerCase();
	}
	public String getNamespacePath() {
		return aplicacao.getNamespace().toLowerCase();
	}
	public String getPathPrincipalAndroid() {
		return aplicacao.getUrl();
	}
	public String getPathPrincipalCsWeb() {
		return aplicacao.getDiretorio();
	}
	public String getPathPrincipalCs2008() {
		return aplicacao.getBancoDados();
	}
	public String getPathPrincipalJava() {
		return aplicacao.getDiretorioJava();
	}
	public String getNomeAplicacao() {
		return aplicacao.getNamespace();
	}
	public String getPathCpp() {
		return aplicacao.getDiretorioCpp();
	}
	
}
