package gerapp.regracolecao;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import gerapp.dao.*;
import gerapp.modelo.*;
import gerapp.regracolecao.filtro.*;


public abstract class RelacionamentoEntidadeRegraColecao   { 
      public RelacionamentoEntidadeRegraColecao()
      {
		_filtro = null;
	}
	public  List ListaCorrente( DaoConexao conexao )  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
		dao.setConexao(conexao);
     List saida;
     RelacionamentoEntidadeFiltro filtroWork = getFiltro();
		if(filtroWork.getCodigoEntidade1()!=-1)
		{
		saida = dao.ListaPorEntidade1(filtroWork.getCodigoEntidade1());
		return saida;
		}
		if(filtroWork.getCodigoEntidade2()!=-1)
		{
		saida = dao.ListaPorEntidade2(filtroWork.getCodigoEntidade2());
		return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
	}

	private  RelacionamentoEntidadeFiltro _filtro;
	public  RelacionamentoEntidadeFiltro getFiltro() {
		if (_filtro==null) _filtro = new RelacionamentoEntidadeFiltro();
		return _filtro;
	}
	public void setFiltro( RelacionamentoEntidadeFiltro dado ) {
		_filtro = dado;
	}
  private RelacionamentoEntidadeFiltro[] _listaEntrada;
	public RelacionamentoEntidadeFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	public void setListaEntrada( RelacionamentoEntidadeFiltro[] dado ) {
		_listaEntrada = dado;
	}
	protected  RelacionamentoEntidadeDao getDao() {
		return DBB.getInstancia().getRelacionamentoEntidadeDao();
	}
	protected  void preparaDaoParaConexao( RelacionamentoEntidadeDao dao )  throws  DaoException{
	}
	public  List ListaFiltro()  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples()  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     List saida = null;
		 saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public  List ListaFiltroSimples( DaoConexao conexao )  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
		dao.setConexao(conexao);
     List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}
	public  RelacionamentoEntidade PreInsercao( RelacionamentoEntidade item ) {
		return item;
	}
	public  RelacionamentoEntidade PreAlteracao( RelacionamentoEntidade item ) {
		return item;
	}
	public  RelacionamentoEntidade obtemPorChave( long chave )  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
     RelacionamentoEntidade saida = obtemPorChave(chave,conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public  RelacionamentoEntidade obtemPorChave( long chave  ,  DaoConexao conexao )  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
		dao.setConexao(conexao);
     RelacionamentoEntidade saida = dao.obtemPorChave(chave);
		return saida;
	}
	public  DaoConexao CriaConexao()  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
     DaoConexao conexao = dao.criaConexao();
		return conexao;
	}
	public  void LiberaConexao( DaoConexao conexao )  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
		dao.liberaConexao(conexao);
	}
	public  List ListaCorrente()  throws  DaoException{
     RelacionamentoEntidadeDao dao = getDao();
     DaoConexao conexao = null;
     List saida = null;
		    conexao = dao.criaConexao();
		    saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
}
