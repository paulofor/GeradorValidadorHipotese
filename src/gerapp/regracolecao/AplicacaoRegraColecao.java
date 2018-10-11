package gerapp.regracolecao;

import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;

import gerapp.dao.*;
import gerapp.modelo.*;
import gerapp.regracolecao.filtro.*;

public abstract class AplicacaoRegraColecao {
	public AplicacaoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		AplicacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida;
		AplicacaoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoEntidadeEmEntidadeLista() != -1) {
			saida = dao.ListaNaoRelacionadaEmEntidadeLista(filtroWork
					.getCodigoEntidadeEmEntidadeLista());
			return saida;
		}
		saida = dao.ListaCorrente();
		return saida;
	}

	private AplicacaoFiltro _filtro;

	public AplicacaoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new AplicacaoFiltro();
		return _filtro;
	}

	public void setFiltro(AplicacaoFiltro dado) {
		_filtro = dado;
	}

	private AplicacaoFiltro[] _listaEntrada;

	public AplicacaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}

	public void setListaEntrada(AplicacaoFiltro[] dado) {
		_listaEntrada = dado;
	}

	public Aplicacao MontaAplicacao() throws DaoException {
		Aplicacao saida;
		AplicacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MontaAplicacao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract Aplicacao MontaAplicacao(DaoConexao conexao)
			throws DaoException;

	protected AplicacaoDao getDao() {
		return DBB.getInstancia().getAplicacaoDao();
	}

	protected void preparaDaoParaConexao(AplicacaoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		AplicacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		AplicacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		AplicacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Aplicacao PreInsercao(Aplicacao item) {
		return item;
	}

	public Aplicacao PreAlteracao(Aplicacao item) {
		return item;
	}

	public Aplicacao obtemPorChave(long chave) throws DaoException {
		AplicacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Aplicacao saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Aplicacao obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		AplicacaoDao dao = getDao();
		dao.setConexao(conexao);
		Aplicacao saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		AplicacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		AplicacaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		AplicacaoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
}
