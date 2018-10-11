package gerapp.regracolecao;


import gerapp.regracolecao.impl.*;


public  class FabricaRegra   { 
	private static FabricaRegra _instancia =  null;
	public static FabricaRegra getInstancia() {
		if (_instancia==null) _instancia = new FabricaRegra();
		return _instancia;
	}
	private  AplicacaoRegraColecao _aplicacaoRegraColecao;
	public  AplicacaoRegraColecao getAplicacaoRegraColecao() {
		if (_aplicacaoRegraColecao==null) _aplicacaoRegraColecao = new AplicacaoRegraColecaoImpl();
		return _aplicacaoRegraColecao;
	}
	private  AtributoEntidadeRegraColecao _atributoEntidadeRegraColecao;
	public  AtributoEntidadeRegraColecao getAtributoEntidadeRegraColecao() {
		if (_atributoEntidadeRegraColecao==null) _atributoEntidadeRegraColecao = new AtributoEntidadeRegraColecaoImpl();
		return _atributoEntidadeRegraColecao;
	}
	private  EntidadeRegraColecao _entidadeRegraColecao;
	public  EntidadeRegraColecao getEntidadeRegraColecao() {
		if (_entidadeRegraColecao==null) _entidadeRegraColecao = new EntidadeRegraColecaoImpl();
		return _entidadeRegraColecao;
	}
	private  FiltroColecaoRegraColecao _filtroColecaoRegraColecao;
	public  FiltroColecaoRegraColecao getFiltroColecaoRegraColecao() {
		if (_filtroColecaoRegraColecao==null) _filtroColecaoRegraColecao = new FiltroColecaoRegraColecaoImpl();
		return _filtroColecaoRegraColecao;
	}
	private  ProcValorRegraColecao _procValorRegraColecao;
	public  ProcValorRegraColecao getProcValorRegraColecao() {
		if (_procValorRegraColecao==null) _procValorRegraColecao = new ProcValorRegraColecaoImpl();
		return _procValorRegraColecao;
	}
	private  RegraColecaoRegraColecao _regraColecaoRegraColecao;
	public  RegraColecaoRegraColecao getRegraColecaoRegraColecao() {
		if (_regraColecaoRegraColecao==null) _regraColecaoRegraColecao = new RegraColecaoRegraColecaoImpl();
		return _regraColecaoRegraColecao;
	}
	private  RelacionamentoEntidadeRegraColecao _relacionamentoEntidadeRegraColecao;
	public  RelacionamentoEntidadeRegraColecao getRelacionamentoEntidadeRegraColecao() {
		if (_relacionamentoEntidadeRegraColecao==null) _relacionamentoEntidadeRegraColecao = new RelacionamentoEntidadeRegraColecaoImpl();
		return _relacionamentoEntidadeRegraColecao;
	}
}
