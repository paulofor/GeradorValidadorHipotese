package gerapp.modelo.agregados;


import gerapp.modelo.agregados.*;
import gerapp.modelo.*;


public  class FiltroColecaoAssembled   implements FiltroColecaoAssembledI { 
  private Entidade _Entidade ;
	public Entidade getEntidade () {
		return _Entidade ;
	}
	public void setEntidade ( Entidade dado ) {
		_Entidade  = dado;
	}
  private Entidade _EntidadeTipo;
	public Entidade getEntidadeTipo() {
		return _EntidadeTipo;
	}
	public void setEntidadeTipo( Entidade dado ) {
		_EntidadeTipo = dado;
	}
}
