package gerapp.regracolecao.filtro;


import gerapp.modelo.*;


public  class AtributoEntidadeFiltro   { 

  private long _codigo_idEntidade = -1;
	public long getCodigoEntidade () {
		return _codigo_idEntidade;
	}
	public void setCodigoEntidade ( long dado ) {
		_codigo_idEntidade = dado;
	}


  private long _codigoEntidadeEmEntidadeListaIdentificador = -1;
	public long getCodigoEntidadeEmEntidadeListaIdentificador() {
		return _codigoEntidadeEmEntidadeListaIdentificador;
	}
	public void setCodigoEntidadeEmEntidadeListaIdentificador( long dado ) {
		_codigoEntidadeEmEntidadeListaIdentificador = dado;
	}
  private long _codigoEntidadeEmEntidadeListaChave = -1;
	public long getCodigoEntidadeEmEntidadeListaChave() {
		return _codigoEntidadeEmEntidadeListaChave;
	}
	public void setCodigoEntidadeEmEntidadeListaChave( long dado ) {
		_codigoEntidadeEmEntidadeListaChave = dado;
	}

}
