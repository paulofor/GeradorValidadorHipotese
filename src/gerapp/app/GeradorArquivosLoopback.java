package gerapp.app;

import gerapp.modelo.Aplicacao;
import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.Entidade;
import gerapp.modelo.FiltroColecao;
import gerapp.modelo.ProcValor;
import gerapp.modelo.RegraColecao;
import gerapp.modelo.RelacionamentoEntidade;
import gerapp.regracolecao.AplicacaoRegraColecao;
import gerapp.regracolecao.EntidadeRegraColecao;
import gerapp.regracolecao.FabricaRegra;
import gerapp.regracolecao.filtro.EntidadeFiltro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import loopback.cliente.repositorio.AplicacaoRepositorio;
import loopback.remoting.adapters.RestAdapter;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosLoopback extends GeradorArquivosBase{
	
	
	public void setAplicacao(Aplicacao aplicacao)  throws DaoException{
		this.aplicacao = new AplicacaoWrapper(aplicacao);
	}
	
	public List getListaEntidade() throws DaoException{
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		AplicacaoRepositorio rep = adapter.createRepository(AplicacaoRepositorio.class);
		
		
		EntidadeRegraColecao entidadeRC = FabricaRegra.getInstancia().getEntidadeRegraColecao();
		List listaSaida = null;
		EntidadeFiltro filtro = entidadeRC.getFiltro();
		filtro.setCodigoAplicacao(aplicacao.getId());
		listaSaida = entidadeRC.ListaCorrente();
		return listaSaida;
	}
	
	

}
