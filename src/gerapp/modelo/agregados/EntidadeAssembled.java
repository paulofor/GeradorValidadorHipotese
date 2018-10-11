package gerapp.modelo.agregados;


import gerapp.modelo.agregados.*;
import gerapp.modelo.*;


public  class EntidadeAssembled   implements EntidadeAssembledI { 
  private Aplicacao _Aplicacao ;
	public Aplicacao getAplicacao () {
		return _Aplicacao ;
	}
	public void setAplicacao ( Aplicacao dado ) {
		_Aplicacao  = dado;
	}
  private AtributoEntidade _AtributoEntidadeIdentificador;
	public AtributoEntidade getAtributoEntidadeIdentificador() {
		return _AtributoEntidadeIdentificador;
	}
	public void setAtributoEntidadeIdentificador( AtributoEntidade dado ) {
		_AtributoEntidadeIdentificador = dado;
	}
  private AtributoEntidade _AtributoEntidadeChave;
	public AtributoEntidade getAtributoEntidadeChave() {
		return _AtributoEntidadeChave;
	}
	public void setAtributoEntidadeChave( AtributoEntidade dado ) {
		_AtributoEntidadeChave = dado;
	}
}
