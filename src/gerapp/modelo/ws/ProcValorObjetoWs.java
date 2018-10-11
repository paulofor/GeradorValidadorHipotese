package gerapp.modelo.ws;


import gerapp.modelo.vo.*;
import gerapp.modelo.*;


public  class ProcValorObjetoWs   { 
      long _idProcValor;
	public long getIdProcValor() {
		return _idProcValor;
	}
	public void setIdProcValor( long dado ) {
		_idProcValor = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      boolean _possuiTotalizacao;
	public boolean getPossuiTotalizacao() {
		return _possuiTotalizacao;
	}
	public void setPossuiTotalizacao( boolean dado ) {
		_possuiTotalizacao = dado;
	}
      String _descricao;
	public String getDescricao() {
		return _descricao;
	}
	public void setDescricao( String dado ) {
		_descricao = dado;
	}
      boolean _possuiInt;
	public boolean getPossuiInt() {
		return _possuiInt;
	}
	public void setPossuiInt( boolean dado ) {
		_possuiInt = dado;
	}
      boolean _possuiMoeda;
	public boolean getPossuiMoeda() {
		return _possuiMoeda;
	}
	public void setPossuiMoeda( boolean dado ) {
		_possuiMoeda = dado;
	}
      boolean _somaNegativo;
	public boolean getSomaNegativo() {
		return _somaNegativo;
	}
	public void setSomaNegativo( boolean dado ) {
		_somaNegativo = dado;
	}
      boolean _calculadoDemanda;
	public boolean getCalculadoDemanda() {
		return _calculadoDemanda;
	}
	public void setCalculadoDemanda( boolean dado ) {
		_calculadoDemanda = dado;
	}
      String _tipo;
	public String getTipo() {
		return _tipo;
	}
	public void setTipo( String dado ) {
		_tipo = dado;
	}
      long _idEntidadeR;
	public long getIdEntidadeR() {
		return _idEntidadeR;
	}
	public void setIdEntidadeR( long dado ) {
		_idEntidadeR = dado;
	}
  private EntidadeObjetoWs _EntidadeRelacionada;
	public EntidadeObjetoWs getEntidadeRelacionada() {
		return _EntidadeRelacionada;
	}
	public void setEntidadeRelacionada( EntidadeObjetoWs dado ) {
		_EntidadeRelacionada = dado;
	}
}
