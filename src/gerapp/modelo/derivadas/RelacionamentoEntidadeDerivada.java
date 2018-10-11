package gerapp.modelo.derivadas;


import br.com.digicom.lib.*;


import gerapp.modelo.*;


public  class RelacionamentoEntidadeDerivada   implements RelacionamentoEntidadeDerivadaI { 
  private RelacionamentoEntidade principal;
      public RelacionamentoEntidadeDerivada( RelacionamentoEntidade itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
