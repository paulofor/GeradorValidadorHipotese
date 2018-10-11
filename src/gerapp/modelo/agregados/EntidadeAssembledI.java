package gerapp.modelo.agregados;


import gerapp.modelo.*;

public interface EntidadeAssembledI
 { 
	public Aplicacao getAplicacao ();
	public void setAplicacao ( Aplicacao dado );
	public AtributoEntidade getAtributoEntidadeIdentificador();
	public void setAtributoEntidadeIdentificador( AtributoEntidade dado );
	public AtributoEntidade getAtributoEntidadeChave();
	public void setAtributoEntidadeChave( AtributoEntidade dado );
}
