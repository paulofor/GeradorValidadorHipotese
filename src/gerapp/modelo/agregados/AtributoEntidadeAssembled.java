package gerapp.modelo.agregados;


import gerapp.modelo.agregados.*;
import gerapp.modelo.*;


public  class AtributoEntidadeAssembled   implements AtributoEntidadeAssembledI { 
  private Entidade _Entidade ;
	public Entidade getEntidade () {
		return _Entidade ;
	}
	public void setEntidade ( Entidade dado ) {
		_Entidade  = dado;
	}
}
