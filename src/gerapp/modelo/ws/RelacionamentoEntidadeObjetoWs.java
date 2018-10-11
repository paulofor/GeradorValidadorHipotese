package gerapp.modelo.ws;


import gerapp.modelo.vo.*;
import gerapp.modelo.*;


public  class RelacionamentoEntidadeObjetoWs   { 
      long _idRelacionamentoEntidade;
	public long getIdRelacionamentoEntidade() {
		return _idRelacionamentoEntidade;
	}
	public void setIdRelacionamentoEntidade( long dado ) {
		_idRelacionamentoEntidade = dado;
	}
      boolean _dependente;
	public boolean getDependente() {
		return _dependente;
	}
	public void setDependente( boolean dado ) {
		_dependente = dado;
	}
      boolean _obrigatorio;
	public boolean getObrigatorio() {
		return _obrigatorio;
	}
	public void setObrigatorio( boolean dado ) {
		_obrigatorio = dado;
	}
      String _tipoApresentacao;
	public String getTipoApresentacao() {
		return _tipoApresentacao;
	}
	public void setTipoApresentacao( String dado ) {
		_tipoApresentacao = dado;
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
      String _nome2;
	public String getNome2() {
		return _nome2;
	}
	public void setNome2( String dado ) {
		_nome2 = dado;
	}
      String _nome1;
	public String getNome1() {
		return _nome1;
	}
	public void setNome1( String dado ) {
		_nome1 = dado;
	}
      String _qtdeEntidade2;
	public String getQtdeEntidade2() {
		return _qtdeEntidade2;
	}
	public void setQtdeEntidade2( String dado ) {
		_qtdeEntidade2 = dado;
	}
      String _qtdeEntidade1;
	public String getQtdeEntidade1() {
		return _qtdeEntidade1;
	}
	public void setQtdeEntidade1( String dado ) {
		_qtdeEntidade1 = dado;
	}
      boolean _criacaoIndependenteCpp;
	public boolean getCriacaoIndependenteCpp() {
		return _criacaoIndependenteCpp;
	}
	public void setCriacaoIndependenteCpp( boolean dado ) {
		_criacaoIndependenteCpp = dado;
	}
      long _idEntidade1;
	public long getIdEntidade1() {
		return _idEntidade1;
	}
	public void setIdEntidade1( long dado ) {
		_idEntidade1 = dado;
	}
      long _idEntidade2;
	public long getIdEntidade2() {
		return _idEntidade2;
	}
	public void setIdEntidade2( long dado ) {
		_idEntidade2 = dado;
	}
  private EntidadeObjetoWs _Entidade1;
	public EntidadeObjetoWs getEntidade1() {
		return _Entidade1;
	}
	public void setEntidade1( EntidadeObjetoWs dado ) {
		_Entidade1 = dado;
	}
  private EntidadeObjetoWs _Entidade2;
	public EntidadeObjetoWs getEntidade2() {
		return _Entidade2;
	}
	public void setEntidade2( EntidadeObjetoWs dado ) {
		_Entidade2 = dado;
	}
}
