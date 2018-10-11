package gerapp.modelo.ws;


import gerapp.modelo.vo.*;
import gerapp.modelo.*;


public  class AtributoEntidadeObjetoWs   { 
      long _idAtributoEntidade;
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
  private EntidadeObjetoWs _Entidade ;
	public EntidadeObjetoWs getEntidade () {
		return _Entidade ;
	}
	public void setEntidade ( EntidadeObjetoWs dado ) {
		_Entidade  = dado;
	}
      boolean _chave;
	public boolean getChave() {
		return _chave;
	}
	public void setChave( boolean dado ) {
		_chave = dado;
	}
      boolean _identificador;
	public boolean getIdentificador() {
		return _identificador;
	}
	public void setIdentificador( boolean dado ) {
		_identificador = dado;
	}
}
