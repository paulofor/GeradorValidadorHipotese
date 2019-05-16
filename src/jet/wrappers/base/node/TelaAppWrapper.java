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
	 *
	 */

	
	public TelaAppWrapper getTelaEdicao() {
		if (this.principal.getTelaEdicao()==null) return null;
		else return new TelaAppWrapper(this.principal.getTelaEdicao());
	}
	
	public String getNomeMenu() {
		return this.principal.getNomeMenu();
	}
	
	
	public String getMetodoCarga() {
		String nome = "get" + this.getNome() + "Load";
		return nome;
	}
	public String getMetodoCargaConstante() {
		return this.getEntidade().getNomeParaConstante() + "_" + this.getNome().toUpperCase();
	}
	
	
	@Override
	public String getArquivo() {
		return getNomeParaArquivo();
	}

	@Override
	public String getNome() {
		return principal.getNome() + "Page";
	}
	
	public String getTipo() {
		return principal.getTipo();
	}

	@Override
	public String getPathArquivo() {
		return getNomeParaArquivo();
	}

	@Override
	public String getNomeControle() {
		return "page-" + getNomeParaArquivo();
	}
	
	
	
	private String getNomeParaArquivo() {
		String nome = principal.getNome();
		String saida = "";
		for (int i=0;i < nome.length(); i++) {
			if (Character.isUpperCase(nome.charAt(i))) {
				if (i==0) saida += ("" + nome.charAt(i)).toLowerCase();
				else saida += "-" + ("" + nome.charAt(i)).toLowerCase();
			} else {
				saida += ("" + nome.charAt(i));
			}
		}
		return saida;
	}
	
	private TelaAppRest principal = null;
	
	private ClasseWrapper entidade = null;
	
	private ClasseWrapper entidadePut = null;
	
	public boolean ehTipo(String tipo) {
		return (this.principal.getTipo().compareTo(tipo)==0);
	}
	
	
	public boolean tipoLista() {
		return ("LISTA".equals(this.principal.getTipo()));
	}
	public boolean tipoListaVitrine() {
		return ("LISTA_VITRINE".equals(this.principal.getTipo()));
	}
	public boolean tipoListaGrid() {
		return ("LISTA_GRID".equals(this.principal.getTipo()));
	}
	public boolean tipoListaItem() {
		return ("LISTA_ITEM".equals(this.principal.getTipo()));
	}
	public boolean tipoItemLista() {
		return ("ITEM_LISTA".equals(this.principal.getTipo()));
	}
	public boolean tipoEdita() {
		return ("EDITA".equals(this.principal.getTipo()));
	}
	public boolean tipoGenerica() {
		return ("GENERICA".equals(this.principal.getTipo()));
	}
	public boolean tipoDetalhe() {
		return ("DETALHE".equals(this.principal.getTipo()));
	}
	public boolean tipoGetPut() {
		return ("GETPUT".equals(this.principal.getTipo()));
	}
	public boolean tipoGraficoBarra() {
		return ("GRAFICO_BARRA".equals(this.principal.getTipo()));
	}
	
	public boolean possuiEntidade() {
		return (entidade!=null);
	}
	public ClasseWrapper getEntidade() {
		return this.entidade;
	}
	
	public boolean possuiEntidadePut() {
		return (entidadePut!=null);
	}
	public ClasseWrapper getEntidadePut() {
		return this.entidadePut;
	}
	public void setClasseWrapperPut(ClasseWrapper entidade) {
		this.entidadePut = entidade;
	}
	
	
	public long getIdEntidade() {
		return (principal.getEntidadeId()!=null?principal.getEntidadeId():0);
	}
	public long getIdEntidadePut() {
		return (principal.getEntidadePutId()!=null?principal.getEntidadePutId():0);
	}
	public void setClasseWrapper(ClasseWrapper entidade) {
		this.entidade = entidade;
	}
	
	public TelaAppWrapper(TelaAppRest principal) {
		this.principal = principal;
	}
	public TelaAppWrapper(String nomeTela) {
		TelaAppRest tela = new TelaAppRest();
		tela.setNome(nomeTela);
		this.principal = tela;
	}
	
	
	public boolean sobrescreveHtml() {
		return this.principal.getSobrescreveHtml() == 1;
	}
	public boolean sobrescreveTs() {
		return this.principal.getSobrescreveTs() == 1;
	}
	
	
	private String getSufixo() {
		String saida = "";
		if (this.tipoLista()) saida = "Lista";
		if (this.tipoDetalhe()) saida = "Detalhe";
		if (this.tipoEdita()) saida = "Edita";
		return saida;
	}
	
	// *** Metodos Principais *** 
	

	
	public String toString() {
		return "Nome: " + this.getNome() + ", PathArquivo: " + this.getPathArquivo() + ", NomeControle: " + this.getNomeControle();
	}
}
