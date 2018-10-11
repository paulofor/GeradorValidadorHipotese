package gerapp.modelo.vo;


import br.com.digicom.lib.*;


import gerapp.modelo.*;
import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;


public  class RegraColecaoVo   implements RegraColecao { 
  private RegraColecaoAssembled _assembled =  new RegraColecaoAssembled();
  private RegraColecaoDerivadaI derivada;
      public RegraColecaoVo()
      {
      derivada = new RegraColecaoDerivada(this);
	}
  private long _idRegraColecao = 0;
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
	public Entidade getEntidade () {
		return _assembled.getEntidade ();
	}
	public void setEntidade ( Entidade dado ) {
		_assembled.setEntidade (dado);
	}

	public  String getXml() {
     String saidaXml;
      saidaXml = "";
      saidaXml = "<RegraColecao ";
      saidaXml = saidaXml + "IdRegraColecao='" + this.getIdRegraColecao() + "' ";
      saidaXml = saidaXml + "Nome='" + this.getNome() + "' ";
      saidaXml = saidaXml + "Descricao='" + this.getDescricao() + "' ";
      saidaXml = saidaXml + "RetornaColecao='" + this.getRetornaColecao() + "' ";
      saidaXml = saidaXml + "RecebeColecao='" + this.getRecebeColecao() + "' ";
      saidaXml = saidaXml + "AtivoJava='" + this.getAtivoJava() + "' ";
      saidaXml = saidaXml + "AtivoCpp='" + this.getAtivoCpp() + "' ";
      saidaXml = saidaXml + "AtivoFlex='" + this.getAtivoFlex() + "' ";
      saidaXml = saidaXml + "AtivoCs='" + this.getAtivoCs() + "' ";
      saidaXml = saidaXml + "IdEntidade='" + this.getIdEntidade() + "' ";
      saidaXml = saidaXml + "/>";
      return saidaXml;
	}
	
	public String getNomeParaConstante() {
	    return _nome.toUpperCase();
	}
}
