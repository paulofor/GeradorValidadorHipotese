package gerapp.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import gerapp.dao.*;
import gerapp.modelo.*;
import gerapp.regracolecao.filtro.*;


public abstract class RegraColecaoRegraColecao   { 
      public RegraColecaoRegraColecao()
      {
		_filtro = null;
	}
	public  List ListaCorrente( DaoConexao conexao )  throws  DaoException{
     RegraColecaoDao dao = getDao();
		dao.setConexao(conexao);
     List saida;
     RegraColecaoFiltro filtroWork = getFiltro();
		if(filtroWork.getCodigoEntidade ()!=-1)
		{
		saida = dao.ListaPorEntidade (filtroWork.getCodigoEntidade ());
		return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
	}

	private  RegraColecaoFiltro _filtro;
	public  RegraColecaoFiltro getFiltro() {
		if (_filtro==null) _filtro = new RegraColecaoFiltro();
		return _filtro;
	}
	public void setFiltro( RegraColecaoFiltro dado ) {
		_filtro = dado;
	}
  private RegraColecaoFiltro[] _listaEntrada;
	public RegraColecaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	public void setListaEntrada( RegraColecaoFiltro[] dado ) {
		_listaEntrada = dado;
	}
	protected  RegraColecaoDao getDao() {
		return DBB.getInstancia().getRegraColecaoDao();
	}
	protected  void preparaDaoParaConexao( RegraColecaoDao dao )  throws  DaoException{
	}
	public  List ListaFiltro()  throws  DaoException{
     RegraColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples()  throws  DaoException{
     RegraColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples( DaoConexao conexao )  throws  DaoException{
     RegraColecaoDao dao = getDao();
		dao.setConexao(conexao);
     List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}
	public  RegraColecao PreInsercao( RegraColecao item ) {
		return item;
	}
	public  RegraColecao PreAlteracao( RegraColecao item ) {
		return item;
	}
	public  RegraColecao obtemPorChave( long chave )  throws  DaoException{
     RegraColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     RegraColecao saida = obtemPorChave(chave,conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public  RegraColecao obtemPorChave( long chave  ,  DaoConexao conexao )  throws  DaoException{
     RegraColecaoDao dao = getDao();
		dao.setConexao(conexao);
     RegraColecao saida = dao.obtemPorChave(chave);
		return saida;
	}
	public  DaoConexao CriaConexao()  throws  DaoException{
     RegraColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		return conexao;
	}
	public  void LiberaConexao( DaoConexao conexao )  throws  DaoException{
     RegraColecaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}
	public  List ListaCorrente()  throws  DaoException{
     RegraColecaoDao dao = getDao();
     DaoConexao conexao = null;
     List saida = null;
		    conexao = dao.criaConexao();
		    saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
}
