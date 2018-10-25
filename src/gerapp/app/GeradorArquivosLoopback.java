package gerapp.app;

import gerapp.modelo.Aplicacao;

import java.util.ArrayList;
import java.util.List;

import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.AtributoEntidadeRest;
import loopback.cliente.modelo.EntidadeRest;
import loopback.cliente.modelo.RelacionamentoEntidadeRest;
import loopback.cliente.repositorio.AtributoEntidadeRepositorio;
import loopback.cliente.repositorio.EntidadeRepositorio;
import loopback.cliente.repositorio.RelacionamentoEntidadeRepositorio;
import loopback.remoting.adapters.RestAdapter;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosLoopback extends GeradorArquivosBase{
	
	private List listaEntidade = null;
	private List listaAtributo = null;
	private List listaRelacionamento = null;
	
	public void setAplicacao(Aplicacao aplicacao)  throws DaoException{
		this.aplicacao = new AplicacaoWrapper(aplicacao);
	}
	
	public synchronized List getListaEntidade() throws DaoException{
		listaEntidade = null;
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		EntidadeRepositorio rep = adapter.createRepository(EntidadeRepositorio.class);

		rep.findByIdAplicacao(aplicacao.getId(), new ListCallback<EntidadeRest>() { 
         
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<EntidadeRest> lista) {
				List listaSaida = new ArrayList();
				for (EntidadeRest item : lista) {
					System.out.println("ID:" + item.getNome());
					listaSaida.add(item.criaItem());
				}
				listaEntidade = listaSaida;
			} 
        });
		do {} while (listaEntidade == null);
		return listaEntidade;
	}
	
	
	public synchronized List getListaAtributos(long idEntidade) throws DaoException{
		listaAtributo = null;
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		AtributoEntidadeRepositorio rep = adapter.createRepository(AtributoEntidadeRepositorio.class);

		rep.findByIdEntidade(idEntidade, new ListCallback<AtributoEntidadeRest>() { 
         
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<AtributoEntidadeRest> lista) {
				List listaSaida = new ArrayList();
				for (AtributoEntidadeRest item : lista) {
					System.out.println("ID:" + item.getNome());
					listaSaida.add(item.criaItem());
				}
				listaAtributo = listaSaida;
			} 
        });
		do {
			System.out.println("aguardando listaAtributo");
		} while (listaAtributo == null);
		return listaAtributo;
	}
	
	public synchronized List getListaRelacionamento(long idEntidade) throws DaoException{
		listaRelacionamento = null;
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		RelacionamentoEntidadeRepositorio rep = adapter.createRepository(RelacionamentoEntidadeRepositorio.class);

		rep.findByIdEntidade(idEntidade, new ListCallback<RelacionamentoEntidadeRest>() { 
         
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<RelacionamentoEntidadeRest> lista) {
				List listaSaida = new ArrayList();
				for (RelacionamentoEntidadeRest item : lista) {
					System.out.println("ID-Rel:" + item.getId_relacionamento_entidade());
					listaSaida.add(item.criaItem());
				}
				listaRelacionamento = listaSaida;
			} 
        });
		do {
			System.out.println("aguardando listaRelacionamento");
		} while (listaRelacionamento == null);
		return listaRelacionamento;
	}
	
	public List getListaFiltro(long idEntidade) {
		return new ArrayList();
	}
	public List getListaRegra(long idEntidade) {
		return new ArrayList();
	}
	public List getListaProcValor(long idEntidade) {
		return new ArrayList();
	}
}
