package gerapp.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import gerapp.dao.*;
import gerapp.modelo.*;
import gerapp.regracolecao.filtro.*;


public abstract class AtributoEntidadeRegraColecao   { 
      public AtributoEntidadeRegraColecao()
      {
		_filtro = null;
	}
	public  List ListaCorrente( DaoConexao conexao )  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
		dao.setConexao(conexao);
     List saida;
     AtributoEntidadeFiltro filtroWork = getFiltro();
		if(filtroWork.getCodigoEntidade ()!=-1)
		{
		saida = dao.ListaPorEntidade (filtroWork.getCodigoEntidade ());
		return saida;
		}
      if(filtroWork.getCodigoEntidadeEmEntidadeListaIdentificador()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmEntidadeListaIdentificador(filtroWork.getCodigoEntidadeEmEntidadeListaIdentificador());
		return saida;
      }
      if(filtroWork.getCodigoEntidadeEmEntidadeListaChave()!=-1)
      {
      saida = dao.ListaNaoRelacionadaEmEntidadeListaChave(filtroWork.getCodigoEntidadeEmEntidadeListaChave());
		return saida;
      }
		saida = dao.ListaCorrenteAgrupada();
		return saida;
	}

	private  AtributoEntidadeFiltro _filtro;
	public  AtributoEntidadeFiltro getFiltro() {
		if (_filtro==null) _filtro = new AtributoEntidadeFiltro();
		return _filtro;
	}
	public void setFiltro( AtributoEntidadeFiltro dado ) {
		_filtro = dado;
	}
  private AtributoEntidadeFiltro[] _listaEntrada;
	public AtributoEntidadeFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	public void setListaEntrada( AtributoEntidadeFiltro[] dado ) {
		_listaEntrada = dado;
	}
	protected  AtributoEntidadeDao getDao() {
		return DBB.getInstancia().getAtributoEntidadeDao();
	}
	protected  void preparaDaoParaConexao( AtributoEntidadeDao dao )  throws  DaoException{
	}
	public  List ListaFiltro()  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples()  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples( DaoConexao conexao )  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
		dao.setConexao(conexao);
     List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}
	public  AtributoEntidade PreInsercao( AtributoEntidade item ) {
		return item;
	}
	public  AtributoEntidade PreAlteracao( AtributoEntidade item ) {
		return item;
	}
	public  AtributoEntidade obtemPorChave( long chave )  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     AtributoEntidade saida = obtemPorChave(chave,conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public  AtributoEntidade obtemPorChave( long chave  ,  DaoConexao conexao )  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
		dao.setConexao(conexao);
     AtributoEntidade saida = dao.obtemPorChave(chave);
		return saida;
	}
	public  DaoConexao CriaConexao()  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		return conexao;
	}
	public  void LiberaConexao( DaoConexao conexao )  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
		dao.liberaConexao(conexao);
	}
	public  List ListaCorrente()  throws  DaoException{
     AtributoEntidadeDao dao = getDao();
     DaoConexao conexao = null;
     List saida = null;
		    conexao = dao.criaConexao();
		    saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
}
