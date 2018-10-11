package gerapp.modelo.vo;


import br.com.digicom.lib.*;


import gerapp.modelo.*;
import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;


public  class FiltroColecaoVo   implements FiltroColecao { 
  private FiltroColecaoAssembled _assembled =  new FiltroColecaoAssembled();
  private FiltroColecaoDerivadaI derivada;
      public FiltroColecaoVo()
      {
      derivada = new FiltroColecaoDerivada(this);
	}
  private long _idFiltroColecao = 0;
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
	public Entidade getEntidade () {
		return _assembled.getEntidade ();
	}
	public void setEntidade ( Entidade dado ) {
		_assembled.setEntidade (dado);
	}
	public Entidade getEntidadeTipo() {
		return _assembled.getEntidadeTipo();
	}
	public void setEntidadeTipo( Entidade dado ) {
		_assembled.setEntidadeTipo(dado);
	}

	public  String getXml() {
     String saidaXml;
      saidaXml = "";
      saidaXml = "<FiltroColecao ";
      saidaXml = saidaXml + "IdFiltroColecao='" + this.getIdFiltroColecao() + "' ";
      saidaXml = saidaXml + "NomeCampoFiltro='" + this.getNomeCampoFiltro() + "' ";
      saidaXml = saidaXml + "TipoCampoFiltro='" + this.getTipoCampoFiltro() + "' ";
      saidaXml = saidaXml + "IdEntidade='" + this.getIdEntidade() + "' ";
      saidaXml = saidaXml + "IdEntidadeT='" + this.getIdEntidadeT() + "' ";
      saidaXml = saidaXml + "/>";
      return saidaXml;
	}

}
