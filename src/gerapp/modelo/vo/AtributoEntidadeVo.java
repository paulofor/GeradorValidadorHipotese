package gerapp.modelo.vo;


import br.com.digicom.lib.*;


import gerapp.modelo.*;
import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;


public  class AtributoEntidadeVo   implements AtributoEntidade { 
  private AtributoEntidadeAssembled _assembled =  new AtributoEntidadeAssembled();
  private AtributoEntidadeDerivadaI derivada;
      public AtributoEntidadeVo()
      {
      derivada = new AtributoEntidadeDerivada(this);
	}
  private long _idAtributoEntidade = 0;
	public long getIdAtributoEntidade() {
		return _idAtributoEntidade;
	}
	public void setIdAtributoEntidade( long dado ) {
		_idAtributoEntidade = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _tipo;
	public String getTipo() {
		return _tipo;
	}
	public void setTipo( String dado ) {
		_tipo = dado;
	}
      String _labelTela;
	public String getLabelTela() {
		return _labelTela;
	}
	public void setLabelTela( String dado ) {
		_labelTela = dado;
	}
      boolean _editavel;
	public boolean getEditavel() {
		return _editavel;
	}
	public void setEditavel( boolean dado ) {
		_editavel = dado;
	}
      boolean _obrigatorio;
	public boolean getObrigatorio() {
		return _obrigatorio;
	}
	public void setObrigatorio( boolean dado ) {
		_obrigatorio = dado;
	}
      long _ordenacaoTela;
	public long getOrdenacaoTela() {
		return _ordenacaoTela;
	}
	public void setOrdenacaoTela( long dado ) {
		_ordenacaoTela = dado;
	}
      long _idEntidade;
	public long getIdEntidade() {
		return _idEntidade;
	}
	public void setIdEntidade( long dado ) {
		_idEntidade = dado;
	}
	public Entidade getEntidade () {
		return _assembled.getEntidade ();
	}
	public void setEntidade ( Entidade dado ) {
		_assembled.setEntidade (dado);
	}

	public  String getXml() {
     String saidaXml;
      saidaXml = "";
      saidaXml = "<AtributoEntidade ";
      saidaXml = saidaXml + "IdAtributoEntidade='" + this.getIdAtributoEntidade() + "' ";
      saidaXml = saidaXml + "Nome='" + this.getNome() + "' ";
      saidaXml = saidaXml + "Tipo='" + this.getTipo() + "' ";
      saidaXml = saidaXml + "LabelTela='" + this.getLabelTela() + "' ";
      saidaXml = saidaXml + "Editavel='" + this.getEditavel() + "' ";
      saidaXml = saidaXml + "Obrigatorio='" + this.getObrigatorio() + "' ";
      saidaXml = saidaXml + "OrdenacaoTela='" + this.getOrdenacaoTela() + "' ";
      saidaXml = saidaXml + "IdEntidade='" + this.getIdEntidade() + "' ";
      saidaXml = saidaXml + "/>";
      return saidaXml;
	}

	public boolean getChave() {
		return derivada.getChave();
	}
	public void setChave( boolean dado ) {
		derivada.setChave(dado);
	}

	public boolean getIdentificador() {
		return derivada.getIdentificador();
	}
	public void setIdentificador( boolean dado ) {
		derivada.setIdentificador(dado);
	}

}
