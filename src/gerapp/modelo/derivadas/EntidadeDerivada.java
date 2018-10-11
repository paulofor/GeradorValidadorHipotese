package gerapp.modelo.derivadas;


import java.util.List;

import br.com.digicom.lib.*;


import gerapp.modelo.*;


public  class EntidadeDerivada   implements EntidadeDerivadaI { 
  private Entidade principal;
      public EntidadeDerivada( Entidade itemPrincipal )
      {
      principal = itemPrincipal;
	}
    
    List<AtributoEntidade> listaAtributoEntidade;
    public void setListaAtributoEntidade(List<AtributoEntidade> lista) {
    	this.listaAtributoEntidade = lista;
    }
  	public List<AtributoEntidade> getListaAtributoEntidade() {
  		return this.listaAtributoEntidade;
  	}
}
