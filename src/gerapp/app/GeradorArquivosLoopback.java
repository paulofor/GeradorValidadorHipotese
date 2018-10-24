package gerapp.app;

import gerapp.modelo.Aplicacao;

import java.util.ArrayList;
import java.util.List;

import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.AtributoEntidadeRest;
import loopback.cliente.modelo.EntidadeRest;
import loopback.cliente.repositorio.AtributoEntidadeRepositorio;
import loopback.cliente.repositorio.EntidadeRepositorio;
import loopback.remoting.adapters.RestAdapter;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosLoopback extends GeradorArquivosBase{
	
	private List listaEntidade = null;
	private List listaAtributo = null;
	
	public void setAplicacao(Aplicacao aplicacao)  throws DaoException{
		this.aplicacao = new AplicacaoWrapper(aplicacao);
	}
	
	public List getListaEntidade() throws DaoException{
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
	
	
	public List getListaAtributos(long idEntidade) throws DaoException{
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
		do {} while (listaAtributo == null);
		return listaAtributo;
	}
	

}
