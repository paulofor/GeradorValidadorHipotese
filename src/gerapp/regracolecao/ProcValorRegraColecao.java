package gerapp.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import gerapp.dao.*;
import gerapp.modelo.*;
import gerapp.regracolecao.filtro.*;


public abstract class ProcValorRegraColecao   { 
      public ProcValorRegraColecao()
      {
		_filtro = null;
	}
	public  List ListaCorrente( DaoConexao conexao )  throws  DaoException{
     ProcValorDao dao = getDao();
		dao.setConexao(conexao);
     List saida;
     ProcValorFiltro filtroWork = getFiltro();
		if(filtroWork.getCodigoEntidadeRelacionada()!=-1)
		{
		saida = dao.ListaPorEntidadeRelacionada(filtroWork.getCodigoEntidadeRelacionada());
		return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
	}

	private  ProcValorFiltro _filtro;
	public  ProcValorFiltro getFiltro() {
		if (_filtro==null) _filtro = new ProcValorFiltro();
		return _filtro;
	}
	public void setFiltro( ProcValorFiltro dado ) {
		_filtro = dado;
	}
  private ProcValorFiltro[] _listaEntrada;
	public ProcValorFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	public void setListaEntrada( ProcValorFiltro[] dado ) {
		_listaEntrada = dado;
	}
	protected  ProcValorDao getDao() {
		return DBB.getInstancia().getProcValorDao();
	}
	protected  void preparaDaoParaConexao( ProcValorDao dao )  throws  DaoException{
	}
	public  List ListaFiltro()  throws  DaoException{
     ProcValorDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples()  throws  DaoException{
     ProcValorDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples( DaoConexao conexao )  throws  DaoException{
     ProcValorDao dao = getDao();
		dao.setConexao(conexao);
     List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}
	public  ProcValor PreInsercao( ProcValor item ) {
		return item;
	}
	public  ProcValor PreAlteracao( ProcValor item ) {
		return item;
	}
	public  ProcValor obtemPorChave( long chave )  throws  DaoException{
     ProcValorDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     ProcValor saida = obtemPorChave(chave,conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public  ProcValor obtemPorChave( long chave  ,  DaoConexao conexao )  throws  DaoException{
     ProcValorDao dao = getDao();
		dao.setConexao(conexao);
     ProcValor saida = dao.obtemPorChave(chave);
		return saida;
	}
	public  DaoConexao CriaConexao()  throws  DaoException{
     ProcValorDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		return conexao;
	}
	public  void LiberaConexao( DaoConexao conexao )  throws  DaoException{
     ProcValorDao dao = getDao();
		dao.liberaConexao(conexao);
	}
	public  List ListaCorrente()  throws  DaoException{
     ProcValorDao dao = getDao();
     DaoConexao conexao = null;
     List saida = null;
		    conexao = dao.criaConexao();
		    saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
}
