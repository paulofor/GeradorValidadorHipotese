package gerapp.modelo.ws;


import gerapp.modelo.vo.*;
import gerapp.modelo.*;


public  class RegraColecaoObjetoWs   { 
      long _idRegraColecao;
	public long getIdRegraColecao() {
		return _idRegraColecao;
	}
	public void setIdRegraColecao( long dado ) {
		_idRegraColecao = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _descricao;
	public String getDescricao() {
		return _descricao;
	}
	public void setDescricao( String dado ) {
		_descricao = dado;
	}
      boolean _retornaColecao;
	public boolean getRetornaColecao() {
		return _retornaColecao;
	}
	public void setRetornaColecao( boolean dado ) {
		_retornaColecao = dado;
	}
      boolean _recebeColecao;
	public boolean getRecebeColecao() {
		return _recebeColecao;
	}
	public void setRecebeColecao( boolean dado ) {
		_recebeColecao = dado;
	}
      boolean _ativoJava;
	public boolean getAtivoJava() {
		return _ativoJava;
	}
	public void setAtivoJava( boolean dado ) {
		_ativoJava = dado;
	}
      boolean _ativoCpp;
	public boolean getAtivoCpp() {
		return _ativoCpp;
	}
	public void setAtivoCpp( boolean dado ) {
		_ativoCpp = dado;
	}
      boolean _ativoFlex;
	public boolean getAtivoFlex() {
		return _ativoFlex;
	}
	public void setAtivoFlex( boolean dado ) {
		_ativoFlex = dado;
	}
      boolean _ativoCs;
	public boolean getAtivoCs() {
		return _ativoCs;
	}
	public void setAtivoCs( boolean dado ) {
		_ativoCs = dado;
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
}
