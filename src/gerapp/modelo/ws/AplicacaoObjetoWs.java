package gerapp.modelo.ws;


import gerapp.modelo.vo.*;
import gerapp.modelo.*;


public  class AplicacaoObjetoWs   { 
      long _idAplicacao;
	public long getIdAplicacao() {
		return _idAplicacao;
	}
	public void setIdAplicacao( long dado ) {
		_idAplicacao = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _namespace;
	public String getNamespace() {
		return _namespace;
	}
	public void setNamespace( String dado ) {
		_namespace = dado;
	}
      String _diretorioJava;
	public String getDiretorioJava() {
		return _diretorioJava;
	}
	public void setDiretorioJava( String dado ) {
		_diretorioJava = dado;
	}
      String _diretorioFlex;
	public String getDiretorioFlex() {
		return _diretorioFlex;
	}
	public void setDiretorioFlex( String dado ) {
		_diretorioFlex = dado;
	}
      String _diretorio;
	public String getDiretorio() {
		return _diretorio;
	}
	public void setDiretorio( String dado ) {
		_diretorio = dado;
	}
      String _bancoDados;
	public String getBancoDados() {
		return _bancoDados;
	}
	public void setBancoDados( String dado ) {
		_bancoDados = dado;
	}
      String _versaoVs;
	public String getVersaoVs() {
		return _versaoVs;
	}
	public void setVersaoVs( String dado ) {
		_versaoVs = dado;
	}
      String _url;
	public String getUrl() {
		return _url;
	}
	public void setUrl( String dado ) {
		_url = dado;
	}
}
