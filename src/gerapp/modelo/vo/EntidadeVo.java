package gerapp.modelo.vo;


import br.com.digicom.lib.*;


import gerapp.modelo.*;
import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;


public  class EntidadeVo   implements Entidade { 
  private EntidadeAssembled _assembled =  new EntidadeAssembled();
  private EntidadeDerivadaI derivada;
      public EntidadeVo()
      {
      derivada = new EntidadeDerivada(this);
	}
  private long _idEntidade = 0;
	public long getIdEntidade() {
		return _idEntidade;
	}
	public void setIdEntidade( long dado ) {
		_idEntidade = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      boolean _associativa;
	public boolean getAssociativa() {
		return _associativa;
	}
	public void setAssociativa( boolean dado ) {
		_associativa = dado;
	}
      long _idAplicacao;
	public long getIdAplicacao() {
		return _idAplicacao;
	}
	public void setIdAplicacao( long dado ) {
		_idAplicacao = dado;
	}
      long _idAtributoEntidadeI;
	public long getIdAtributoEntidadeI() {
		return _idAtributoEntidadeI;
	}
	public void setIdAtributoEntidadeI( long dado ) {
		_idAtributoEntidadeI = dado;
	}
      long _idAtributoEntidadeC;
	public long getIdAtributoEntidadeC() {
		return _idAtributoEntidadeC;
	}
	public void setIdAtributoEntidadeC( long dado ) {
		_idAtributoEntidadeC = dado;
	}
	public Aplicacao getAplicacao () {
		return _assembled.getAplicacao ();
	}
	public void setAplicacao ( Aplicacao dado ) {
		_assembled.setAplicacao (dado);
	}
	public AtributoEntidade getAtributoEntidadeIdentificador() {
		return _assembled.getAtributoEntidadeIdentificador();
	}
	public void setAtributoEntidadeIdentificador( AtributoEntidade dado ) {
		_assembled.setAtributoEntidadeIdentificador(dado);
	}
	public AtributoEntidade getAtributoEntidadeChave() {
		return _assembled.getAtributoEntidadeChave();
	}
	public void setAtributoEntidadeChave( AtributoEntidade dado ) {
		_assembled.setAtributoEntidadeChave(dado);
	}

	public  String getXml() {
     String saidaXml;
      saidaXml = "";
      saidaXml = "<Entidade ";
      saidaXml = saidaXml + "IdEntidade='" + this.getIdEntidade() + "' ";
      saidaXml = saidaXml + "Nome='" + this.getNome() + "' ";
      saidaXml = saidaXml + "Associativa='" + this.getAssociativa() + "' ";
      saidaXml = saidaXml + "IdAplicacao='" + this.getIdAplicacao() + "' ";
      saidaXml = saidaXml + "IdAtributoEntidadeI='" + this.getIdAtributoEntidadeI() + "' ";
      saidaXml = saidaXml + "IdAtributoEntidadeC='" + this.getIdAtributoEntidadeC() + "' ";
      saidaXml = saidaXml + "/>";
      return saidaXml;
	}

}
