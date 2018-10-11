package gerapp.modelo.ws;


import gerapp.modelo.vo.*;
import gerapp.modelo.*;


public  class EntidadeObjetoWs   { 
      long _idEntidade;
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
  private AplicacaoObjetoWs _Aplicacao ;
	public AplicacaoObjetoWs getAplicacao () {
		return _Aplicacao ;
	}
	public void setAplicacao ( AplicacaoObjetoWs dado ) {
		_Aplicacao  = dado;
	}
  private AtributoEntidadeObjetoWs _AtributoEntidadeIdentificador;
	public AtributoEntidadeObjetoWs getAtributoEntidadeIdentificador() {
		return _AtributoEntidadeIdentificador;
	}
	public void setAtributoEntidadeIdentificador( AtributoEntidadeObjetoWs dado ) {
		_AtributoEntidadeIdentificador = dado;
	}
  private AtributoEntidadeObjetoWs _AtributoEntidadeChave;
	public AtributoEntidadeObjetoWs getAtributoEntidadeChave() {
		return _AtributoEntidadeChave;
	}
	public void setAtributoEntidadeChave( AtributoEntidadeObjetoWs dado ) {
		_AtributoEntidadeChave = dado;
	}
}
