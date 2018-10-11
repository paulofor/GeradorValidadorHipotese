package gerapp.modelo.agregados;


import gerapp.modelo.agregados.*;
import gerapp.modelo.*;


public  class ProcValorAssembled   implements ProcValorAssembledI { 
  private Entidade _EntidadeRelacionada;
	public Entidade getEntidadeRelacionada() {
		return _EntidadeRelacionada;
	}
	public void setEntidadeRelacionada( Entidade dado ) {
		_EntidadeRelacionada = dado;
	}
}
