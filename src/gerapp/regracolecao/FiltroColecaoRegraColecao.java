package gerapp.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import gerapp.dao.*;
import gerapp.modelo.*;
import gerapp.regracolecao.filtro.*;


public abstract class FiltroColecaoRegraColecao   { 
      public FiltroColecaoRegraColecao()
      {
		_filtro = null;
	}
	public  List ListaCorrente( DaoConexao conexao )  throws  DaoException{
     FiltroColecaoDao dao = getDao();
		dao.setConexao(conexao);
     List saida;
     FiltroColecaoFiltro filtroWork = getFiltro();
		if(filtroWork.getCodigoEntidade ()!=-1)
		{
		saida = dao.ListaPorEntidade (filtroWork.getCodigoEntidade ());
		return saida;
		}
		if(filtroWork.getCodigoEntidadeTipo()!=-1)
		{
		saida = dao.ListaPorEntidadeTipo(filtroWork.getCodigoEntidadeTipo());
		return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
	}

	private  FiltroColecaoFiltro _filtro;
	public  FiltroColecaoFiltro getFiltro() {
		if (_filtro==null) _filtro = new FiltroColecaoFiltro();
		return _filtro;
	}
	public void setFiltro( FiltroColecaoFiltro dado ) {
		_filtro = dado;
	}
  private FiltroColecaoFiltro[] _listaEntrada;
	public FiltroColecaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	public void setListaEntrada( FiltroColecaoFiltro[] dado ) {
		_listaEntrada = dado;
	}
	protected  FiltroColecaoDao getDao() {
		return DBB.getInstancia().getFiltroColecaoDao();
	}
	protected  void preparaDaoParaConexao( FiltroColecaoDao dao )  throws  DaoException{
	}
	public  List ListaFiltro()  throws  DaoException{
     FiltroColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples()  throws  DaoException{
     FiltroColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples( DaoConexao conexao )  throws  DaoException{
     FiltroColecaoDao dao = getDao();
		dao.setConexao(conexao);
     List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}
	public  FiltroColecao PreInsercao( FiltroColecao item ) {
		return item;
	}
	public  FiltroColecao PreAlteracao( FiltroColecao item ) {
		return item;
	}
	public  FiltroColecao obtemPorChave( long chave )  throws  DaoException{
     FiltroColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     FiltroColecao saida = obtemPorChave(chave,conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public  FiltroColecao obtemPorChave( long chave  ,  DaoConexao conexao )  throws  DaoException{
     FiltroColecaoDao dao = getDao();
		dao.setConexao(conexao);
     FiltroColecao saida = dao.obtemPorChave(chave);
		return saida;
	}
	public  DaoConexao CriaConexao()  throws  DaoException{
     FiltroColecaoDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		return conexao;
	}
	public  void LiberaConexao( DaoConexao conexao )  throws  DaoException{
     FiltroColecaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}
	public  List ListaCorrente()  throws  DaoException{
     FiltroColecaoDao dao = getDao();
     DaoConexao conexao = null;
     List saida = null;
		    conexao = dao.criaConexao();
		    saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
}
