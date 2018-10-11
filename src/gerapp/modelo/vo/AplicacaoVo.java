package gerapp.modelo.vo;


import br.com.digicom.lib.*;


import gerapp.modelo.*;
import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;


public class AplicacaoVo implements Aplicacao { 
  private AplicacaoAssembled _assembled =  new AplicacaoAssembled();
  private AplicacaoDerivadaI derivada;
      public AplicacaoVo()
      {
      derivada = new AplicacaoDerivada(this);
	}
  private long _idAplicacao = 0;
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
	
	   String _diretorio_cpp;
		public String getDiretorioCpp() {
			return _diretorio_cpp;
		}
		public void setDiretorioCpp( String dado ) {
			_diretorio_cpp = dado;
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

	public  String getXml() {
     String saidaXml;
      saidaXml = "";
      saidaXml = "<Aplicacao ";
      saidaXml = saidaXml + "IdAplicacao='" + this.getIdAplicacao() + "' ";
      saidaXml = saidaXml + "Nome='" + this.getNome() + "' ";
      saidaXml = saidaXml + "Namespace='" + this.getNamespace() + "' ";
      saidaXml = saidaXml + "DiretorioJava='" + this.getDiretorioJava() + "' ";
      saidaXml = saidaXml + "DiretorioFlex='" + this.getDiretorioFlex() + "' ";
      saidaXml = saidaXml + "Diretorio='" + this.getDiretorio() + "' ";
      saidaXml = saidaXml + "BancoDados='" + this.getBancoDados() + "' ";
      saidaXml = saidaXml + "VersaoVs='" + this.getVersaoVs() + "' ";
      saidaXml = saidaXml + "Url='" + this.getUrl() + "' ";
      saidaXml = saidaXml + "/>";
      return saidaXml;
	}

}
