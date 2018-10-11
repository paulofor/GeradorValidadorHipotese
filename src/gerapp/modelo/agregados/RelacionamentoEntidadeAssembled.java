package gerapp.modelo.agregados;


import gerapp.modelo.agregados.*;
import gerapp.modelo.*;


public  class RelacionamentoEntidadeAssembled   implements RelacionamentoEntidadeAssembledI { 
  private Entidade _Entidade1;
	public Entidade getEntidade1() {
		return _Entidade1;
	}
	public void setEntidade1( Entidade dado ) {
		_Entidade1 = dado;
	}
  private Entidade _Entidade2;
	public Entidade getEntidade2() {
		return _Entidade2;
	}
	public void setEntidade2( Entidade dado ) {
		_Entidade2 = dado;
	}
}
