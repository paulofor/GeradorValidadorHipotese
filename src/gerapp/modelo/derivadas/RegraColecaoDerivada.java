package gerapp.modelo.derivadas;


import br.com.digicom.lib.*;


import gerapp.modelo.*;


public  class RegraColecaoDerivada   implements RegraColecaoDerivadaI { 
  private RegraColecao principal;
      public RegraColecaoDerivada( RegraColecao itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
