package gerapp.modelo.ws;


import gerapp.modelo.vo.*;
import gerapp.modelo.*;


public  class FiltroColecaoObjetoWs   { 
      long _idFiltroColecao;
	public long getIdFiltroColecao() {
		return _idFiltroColecao;
	}
	public void setIdFiltroColecao( long dado ) {
		_idFiltroColecao = dado;
	}
      String _nomeCampoFiltro;
	public String getNomeCampoFiltro() {
		return _nomeCampoFiltro;
	}
	public void setNomeCampoFiltro( String dado ) {
		_nomeCampoFiltro = dado;
	}
      String _tipoCampoFiltro;
	public String getTipoCampoFiltro() {
		return _tipoCampoFiltro;
	}
	public void setTipoCampoFiltro( String dado ) {
		_tipoCampoFiltro = dado;
	}
      long _idEntidade;
	public long getIdEntidade() {
		return _idEntidade;
	}
	public void setIdEntidade( long dado ) {
		_idEntidade = dado;
	}
      long _idEntidadeT;
	public long getIdEntidadeT() {
		return _idEntidadeT;
	}
	public void setIdEntidadeT( long dado ) {
		_idEntidadeT = dado;
	}
  private EntidadeObjetoWs _Entidade ;
	public EntidadeObjetoWs getEntidade () {
		return _Entidade ;
	}
	public void setEntidade ( EntidadeObjetoWs dado ) {
		_Entidade  = dado;
	}
  private EntidadeObjetoWs _EntidadeTipo;
	public EntidadeObjetoWs getEntidadeTipo() {
		return _EntidadeTipo;
	}
	public void setEntidadeTipo( EntidadeObjetoWs dado ) {
		_EntidadeTipo = dado;
	}
}
