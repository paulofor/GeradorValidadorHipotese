package gerapp.modelo.derivadas;


import br.com.digicom.lib.*;


import gerapp.modelo.*;


public  class FiltroColecaoDerivada   implements FiltroColecaoDerivadaI { 
  private FiltroColecao principal;
      public FiltroColecaoDerivada( FiltroColecao itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
