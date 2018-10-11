package gerapp.modelo;


import gerapp.modelo.vo.*;


public  class FabricaVo   { 
	public   static Aplicacao criaAplicacao() {
          return new AplicacaoVo();
	}
	public   static AtributoEntidade criaAtributoEntidade() {
          return new AtributoEntidadeVo();
	}
	public   static Entidade criaEntidade() {
          return new EntidadeVo();
	}
	public   static FiltroColecao criaFiltroColecao() {
          return new FiltroColecaoVo();
	}
	public   static ProcValor criaProcValor() {
          return new ProcValorVo();
	}
	public   static RegraColecao criaRegraColecao() {
          return new RegraColecaoVo();
	}
	public   static RelacionamentoEntidade criaRelacionamentoEntidade() {
          return new RelacionamentoEntidadeVo();
	}
}
