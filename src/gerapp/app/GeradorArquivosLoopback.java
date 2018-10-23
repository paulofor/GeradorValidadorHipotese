package gerapp.app;

import gerapp.modelo.Aplicacao;

import java.util.List;

import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.EntidadeRest;
import loopback.cliente.repositorio.EntidadeRepositorio;
import loopback.remoting.adapters.RestAdapter;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosLoopback extends GeradorArquivosBase{
	
	private List listaCorrente = null;
	
	public void setAplicacao(Aplicacao aplicacao)  throws DaoException{
		this.aplicacao = new AplicacaoWrapper(aplicacao);
	}
	
	public List getListaEntidade() throws DaoException{
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		EntidadeRepositorio rep = adapter.createRepository(EntidadeRepositorio.class);

		rep.findByIdAplicacao(aplicacao.getId(), new ListCallback<EntidadeRest>() { 
         
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<EntidadeRest> lista) {
				// TODO Auto-generated method stub
				for (EntidadeRest item : lista) {
					System.out.println("ID:" + item.getId());
				}
				listaCorrente = lista;
			} 
        });
		do {
			
		} while (listaCorrente == null);
		return listaCorrente;
	}
	
	

}
