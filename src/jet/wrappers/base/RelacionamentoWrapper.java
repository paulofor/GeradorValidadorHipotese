package jet.wrappers.base;

import gerapp.app.AplicacaoWrapper;
import gerapp.app.ConversorString;
import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.RelacionamentoEntidade;

public abstract class RelacionamentoWrapper implements AtributoTotalI{
	
	private RelacionamentoEntidade relacionamento = null;
	protected ClasseWrapper entidade = null;
	protected ClasseWrapper entidadeOposta = null;
	private String nomeRelacionamento = null;
	private String nomeRelacionamentoOposto = null;
	
	protected abstract AtributoWrapper criaAtributoWrapper();
	
	public RelacionamentoEntidade getBase() {
		return relacionamento;
	}
	
	public final boolean ehCriptoNome() {
		return false;
	}
	

	public boolean ehDecimal() {
		return false;
	}

	public boolean ehLogico() {
		return false;
	}
	public boolean ehAuto() {
		return (entidade.getId() == entidadeOposta.getId());
	}
	
	public boolean ehEditavel() {
		return false;
	}
	
	public String getTipoOriginal() {
		return this.getChaveEstrangeira().getTipoOriginal();
	}
	/*
	public String formatoInsert(String objeto) {
		return "\" + " + objeto + "." + this.getNomePropriedade() + " + \" ";
	}
	public String formatoUpdate(String objeto) {
		return "\" + " + objeto + "." + this.getNomePropriedade() + " + \" ";
	}
	*/
	public String formatoUpdateInsert(String objeto) {
		return "\" + " + objeto + "." + this.getNomePropriedade() + " + \" ";
	}
	public long getId() {
		return relacionamento.getIdRelacionamentoEntidade();
	}
	
	public String getCastTipoJson() {
		return this.getChaveEstrangeira().getCastTipoJson();
	}
	public String getTipo() {
		return this.getChaveEstrangeira().getTipo();
	}
	public String getTipoFuncaoMontador() {
		return this.getChaveEstrangeira().getTipoFuncaoMontador();
	}
	
	public String getSemEspacos(String valor) {
		String saida = valor.substring(0, 1).toUpperCase();
		boolean espaco = false;
		for (int i=1;i<valor.length();i++) {
			if (valor.substring(i, i+1).compareTo(" ")==0) {
				espaco = true;
			}  else {
				if (espaco) {
					saida += valor.substring(i,i+1).toUpperCase();
					espaco = false;
				} else {
					saida += valor.substring(i,i+1).toLowerCase();
				}
			}
			
		}
		return saida;	
	}
	
	public String getIniciais(String valor) {
		String saida = valor.substring(0, 1);
		boolean espaco = false;
		for (int i=0;i<valor.length();i++) {
			if (espaco) {
				saida += valor.substring(i,i+1);
				espaco = false;
			}
			if (valor.substring(i, i+1).compareTo(" ")==0) {
				espaco = true;
			} 
		}
		return saida;
	}
	
	public String getNomeParaConstante() {
		return this.entidade.getNomeParaConstante() + "_POR_" + this.entidadeOposta.getNomeParaConstante() 
		+ "_" + this.getNomeRelacionamento().toUpperCase();
	}
	
	public String getNomeVariavel() {
		String nome = getNomeCampoTabela();
		String saida = "";
		boolean mudar = false;
		for (int i=0;i<nome.length();i++) {
			if (nome.substring(i, i+1).compareTo("_")==0) {
				mudar = true;
			} else {
				if (mudar) {
					saida += nome.substring(i,i+1).toUpperCase();
					mudar = false;
				} else {
					saida += nome.substring(i,i+1);
				}
			}
		}
		return saida;
	}
	
	public String getIniciais() {
		String iniciais = getIniciais(nomeRelacionamento);
		return iniciais.substring(0,1).toUpperCase() + (iniciais.length()>1?iniciais.substring(1).toLowerCase():"");
	}
	
	public String getNomeCampoTabela() {
		//System.out.println("Entidade oposta:" + entidadeOposta);
		AtributoEntidade chaveOposta = entidadeOposta.getChave();
		//System.out.println("chave oposta:" + chaveOposta);
		AtributoWrapper attW = criaAtributoWrapper();
		attW.setBase(chaveOposta);
		String saida = attW.getNomeCampoTabela();
		saida += "_" + getIniciais().toLowerCase();
		return saida;
	}
	
	public String getNomeConstante() {
		String saida = getNomeCampoTabela();
		return saida.toUpperCase();
	}
	public String getNomeConstanteOposta() {
		String saida = getNomeCampoTabelaEntidadeOposta();
		return saida.toUpperCase();
	}
	
	public String getNomePropriedade() {
		AtributoEntidade chaveOposta = entidadeOposta.getChave();
		AtributoWrapper attW = criaAtributoWrapper();
		attW.setBase(chaveOposta);
		String saida = attW.getNomePropriedade();
		saida += getIniciais();
		return saida;
	}
	
	// Nome da propriedade na entidade oposta
	public String getNomePropriedadeEntidadeOposta() {
		String saida = entidade.getChaveW().getNomePropriedade();
		String iniciais = getIniciais(this.nomeRelacionamentoOposto);
		saida += iniciais.substring(0,1).toUpperCase() + iniciais.substring(1).toLowerCase();
		return saida;

	}
	// Nome do campo tabela na entidade oposta
	public String getNomeCampoTabelaEntidadeOposta() {
		String saida = entidade.getChaveW().getNomeCampoTabela();
		String iniciais = getIniciais(this.nomeRelacionamentoOposto);
		saida += "_" + iniciais.toLowerCase();
		return saida;
	}
	
	public String getNomeRelacionamento() {
		return getSemEspacos(nomeRelacionamento);
	}
	public String getNomeRelacionamentoOposto() {
		if (relacionamento.getIdEntidade1()==relacionamento.getIdEntidade2())
			return getSemEspacos(nomeRelacionamento);
		return getSemEspacos(nomeRelacionamentoOposto);
	}
	public AtributoWrapper getChaveEstrangeira() {
		AtributoWrapper attW = criaAtributoWrapper();
		attW.setBase(entidadeOposta.getChave());
		return attW;
	}
	
	public ClasseWrapper getClasseOposta() {
		return entidadeOposta;
	}
	
	public String getNome() {
		return ConversorString.getNomeComEspacoParaNotacaoNomeClasse(nomeRelacionamento) + entidadeOposta.getNomeParaClasse();
	}
	
	public void setEntidadeReferencia(ClasseWrapper entidade) {
		this.entidade = entidade;
		if (entidade.getId()==relacionamento.getIdEntidade1()) {
			entidadeOposta = AplicacaoWrapper.getPorId(relacionamento.getIdEntidade2());
			nomeRelacionamento = relacionamento.getNome1();
			nomeRelacionamentoOposto = relacionamento.getNome2();
		}
		if (entidade.getId()==relacionamento.getIdEntidade2()) {
			entidadeOposta = AplicacaoWrapper.getPorId(relacionamento.getIdEntidade1());
			nomeRelacionamento = relacionamento.getNome2();
			nomeRelacionamentoOposto = relacionamento.getNome1();
		}
		if (relacionamento.getIdEntidade1()==relacionamento.getIdEntidade2()) {
			entidadeOposta = entidade;
			if ("N".equals(relacionamento.getQtdeEntidade1())) {
				nomeRelacionamento = relacionamento.getNome2();
				nomeRelacionamentoOposto = relacionamento.getNome1();
			} else {
				nomeRelacionamento = relacionamento.getNome1();
				nomeRelacionamentoOposto = relacionamento.getNome2();
			}
		}
		//nomeRelacionamento = ConversorString.getNomeComEspacoParaNotacaoNomeClasse(nomeRelacionamento);
	}
	
	public RelacionamentoWrapper() {
		
	}
	public RelacionamentoWrapper(RelacionamentoEntidade valor) {
		relacionamento = valor;
	}
	
	public void setRelacionamento(RelacionamentoEntidade valor) {
		relacionamento = valor;
	}


	public boolean ehChave() {
		return false;
	}
}
