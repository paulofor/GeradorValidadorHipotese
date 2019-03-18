package jet.wrappers.base.node;

import gerapp.modelo.node.ItemComponente;
import gerapp.padrao.node.ConversorNome;
import jet.wrappers.base.ClasseWrapper;
import loopback.cliente.modelo.TelaAppRest;

public class TelaAppWrapper implements ItemComponente{

	/*
	 * O que vai ser usado:
	 * 
	 * 1- Nome da classe Page
	 * getNome()
	 * 
	 * 2- Diretorio em que vai ficar dentro do diretorio Pages
	 * getPathArquivo()
	 * 
	 * 3- Nome principal dos arquivos
	 * getArquivo()
	 * 
	 * 4- Nome do seletor/controle
	 * getNomeControle()
	 * 
	 */
	
	
	
	private TelaAppRest principal = null;
	
	private ClasseWrapper entidade = null;
	
	
	public boolean tipoLista() {
		return ("LISTA".equals(this.principal.getTipo()));
	}
	public boolean tipoEdita() {
		return ("EDITA".equals(this.principal.getTipo()));
	}
	public boolean tipoDetalhe() {
		return ("DETALHE".equals(this.principal.getTipo()));
	}
	
	public boolean possuiEntidade() {
		return (entidade!=null);
	}
	public ClasseWrapper getEntidade() {
		return this.entidade;
	}
	
	
	public long getIdEntidade() {
		return (principal.getEntidadeId()!=null?principal.getEntidadeId():0);
	}
	public void setClasseWrapper(ClasseWrapper entidade) {
		this.entidade = entidade;
	}
	
	public TelaAppWrapper(TelaAppRest principal) {
		this.principal = principal;
	}
	
	
	
	private String getNomeBase() {
		if (this.entidade!=null) {
			return entidade.getNomeParaClasse() + getSufixo();
		} else {
			return "SemNome";
		}
	}
	
	
	private String getSufixo() {
		String saida = "";
		if (this.tipoLista()) saida = "Lista";
		if (this.tipoDetalhe()) saida = "Detalhe";
		if (this.tipoEdita()) saida = "Edita";
		return saida;
	}
	
	// *** Metodos Principais *** 
	
	
	@Override
	public String getArquivo() {
		return getPathArquivo();
	}
	@Override
	public String getNome() {
		return getNomeBase() + "Page";
	}
	@Override
	public String getNomeControle() {
		if (this.entidade!=null) {
			return ConversorNome.getIonicNomeControle(getNomeBase());
		} else {
			return "sem-nome";
		}
	}
	@Override
	public String getPathArquivo() {
		if (this.entidade!=null) {
			return ConversorNome.getNomePathIonicPage(getNomeBase());
		} else {
			return "sem-nome";
		}
	}

	
	public String toString() {
		return "Nome: " + this.getNome() + ", PathArquivo: " + this.getPathArquivo() + ", NomeControle: " + this.getNomeControle();
	}
}
