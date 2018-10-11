package gerapp.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import gerapp.dao.*;
import gerapp.modelo.*;
import gerapp.regracolecao.filtro.*;


public abstract class EntidadeRegraColecao   { 
      public EntidadeRegraColecao()
      {
		_filtro = null;
	}
	public  List ListaCorrente( DaoConexao conexao )  throws  DaoException{
     EntidadeDao dao = getDao();
		dao.setConexao(conexao);
     List saida;
     EntidadeFiltro filtroWork = getFiltro();
		if(filtroWork.getCodigoAplicacao ()!=-1)
		{
		saida = dao.ListaPorAplicacao (filtroWork.getCodigoAplicacao ());
		return saida;
		}
		if(filtroWork.getCodigoAtributoEntidadeIdentificador()!=-1)
		{
		saida = dao.ListaPorAtributoEntidadeIdentificador(filtroWork.getCodigoAtributoEntidadeIdentificador());
		return saida;
		}
		if(filtroWork.getCodigoAtributoEntidadeChave()!=-1)
		{
		saida = dao.ListaPorAtributoEntidadeChave(filtroWork.getCodigoAtributoEntidadeChave());
		return saida;
		}
      if(filtroWork.getCodigoAtributoEntidadeEmAtributoEntidadeLista ()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmAtributoEntidadeLista (filtroWork.getCodigoAtributoEntidadeEmAtributoEntidadeLista ());
		return saida;
      }
      if(filtroWork.getCodigoFiltroColecaoEmFiltroColecaoLista ()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmFiltroColecaoLista (filtroWork.getCodigoFiltroColecaoEmFiltroColecaoLista ());
		return saida;
      }
      if(filtroWork.getCodigoFiltroColecaoEmFiltroColecaoListaTipo()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmFiltroColecaoListaTipo(filtroWork.getCodigoFiltroColecaoEmFiltroColecaoListaTipo());
		return saida;
      }
      if(filtroWork.getCodigoRegraColecaoEmRegraColecaoLista ()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmRegraColecaoLista (filtroWork.getCodigoRegraColecaoEmRegraColecaoLista ());
		return saida;
      }
      if(filtroWork.getCodigoRelacionamentoEntidadeEmRelacionamentoEntidadeLista1()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmRelacionamentoEntidadeLista1(filtroWork.getCodigoRelacionamentoEntidadeEmRelacionamentoEntidadeLista1());
		return saida;
      }
      if(filtroWork.getCodigoRelacionamentoEntidadeEmRelacionamentoEntidadeLista2()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmRelacionamentoEntidadeLista2(filtroWork.getCodigoRelacionamentoEntidadeEmRelacionamentoEntidadeLista2());
		return saida;
      }
      if(filtroWork.getCodigoProcValorEmProcValorListaRelacionada()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmProcValorListaRelacionada(filtroWork.getCodigoProcValorEmProcValorListaRelacionada());
		return saida;
      }
		saida = dao.ListaCorrenteAgrupada();
		return saida;
	}

	private  EntidadeFiltro _filtro;
	public  EntidadeFiltro getFiltro() {
		if (_filtro==null) _filtro = new EntidadeFiltro();
		return _filtro;
	}
	public void setFiltro( EntidadeFiltro dado ) {
		_filtro = dado;
	}
  private EntidadeFiltro[] _listaEntrada;
	public EntidadeFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	public void setListaEntrada( EntidadeFiltro[] dado ) {
		_listaEntrada = dado;
	}
	protected  EntidadeDao getDao() {
		return DBB.getInstancia().getEntidadeDao();
	}
	protected  void preparaDaoParaConexao( EntidadeDao dao )  throws  DaoException{
	}
	public  List ListaFiltro()  throws  DaoException{
     EntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples()  throws  DaoException{
     EntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples( DaoConexao conexao )  throws  DaoException{
     EntidadeDao dao = getDao();
		dao.setConexao(conexao);
     List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}
	public  Entidade PreInsercao( Entidade item ) {
		return item;
	}
	public  Entidade PreAlteracao( Entidade item ) {
		return item;
	}
	public  Entidade obtemPorChave( long chave )  throws  DaoException{
     EntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     Entidade saida = obtemPorChave(chave,conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public  Entidade obtemPorChave( long chave  ,  DaoConexao conexao )  throws  DaoException{
     EntidadeDao dao = getDao();
		dao.setConexao(conexao);
     Entidade saida = dao.obtemPorChave(chave);
		return saida;
	}
	public  DaoConexao CriaConexao()  throws  DaoException{
     EntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		return conexao;
	}
	public  void LiberaConexao( DaoConexao conexao )  throws  DaoException{
     EntidadeDao dao = getDao();
		dao.liberaConexao(conexao);
	}
	public  List ListaCorrente()  throws  DaoException{
     EntidadeDao dao = getDao();
     DaoConexao conexao = null;
     List saida = null;
		    conexao = dao.criaConexao();
		    saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
}
