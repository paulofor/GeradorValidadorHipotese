package gerapp.modelo.derivadas;


import br.com.digicom.lib.*;


import gerapp.modelo.*;


public  class ProcValorDerivada   implements ProcValorDerivadaI { 
  private ProcValor principal;
      public ProcValorDerivada( ProcValor itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
