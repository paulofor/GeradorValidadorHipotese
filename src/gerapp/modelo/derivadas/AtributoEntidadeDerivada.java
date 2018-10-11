package gerapp.modelo.derivadas;

import br.com.digicom.lib.*;

import gerapp.modelo.*;

public class AtributoEntidadeDerivada implements AtributoEntidadeDerivadaI {
	private AtributoEntidade principal;

	public AtributoEntidadeDerivada(AtributoEntidade itemPrincipal) {
		principal = itemPrincipal;
	}

	private boolean chave;
	private boolean identificador;


	public boolean getChave() {
		// TODO Auto-generated method stub
		return chave;
	}


	public boolean getIdentificador() {
		// TODO Auto-generated method stub
		return identificador;
	}


	public void setChave(boolean dado) {
		// TODO Auto-generated method stub
		chave = dado;
	}


	public void setIdentificador(boolean dado) {
		// TODO Auto-generated method stub
		identificador = dado;
	}
}
