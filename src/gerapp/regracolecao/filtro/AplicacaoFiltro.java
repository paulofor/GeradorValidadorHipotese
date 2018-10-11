package gerapp.regracolecao.filtro;


import gerapp.modelo.*;


public  class AplicacaoFiltro   { 
      Aplicacao _AplicacaoObj;
	public Aplicacao getAplicacaoObj() {
		return _AplicacaoObj;
	}
	public void setAplicacaoObj( Aplicacao dado ) {
		_AplicacaoObj = dado;
	}



  private long _codigoEntidadeEmEntidadeLista  = -1;
	public long getCodigoEntidadeEmEntidadeLista () {
		return _codigoEntidadeEmEntidadeLista ;
	}
	public void setCodigoEntidadeEmEntidadeLista ( long dado ) {
		_codigoEntidadeEmEntidadeLista  = dado;
	}

}
