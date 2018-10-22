package app;

import java.util.List;

import loopback.android.callback.ObjectCallback;
import loopback.cliente.modelo.AplicacaoRest;
import loopback.cliente.repositorio.AplicacaoRepositorio;
import loopback.remoting.adapters.RestAdapter;

public class TesteCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Ola Mundo");
		
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		AplicacaoRepositorio rep = adapter.createRepository(AplicacaoRepositorio.class);
		
		rep.findById(1, new ObjectCallback<AplicacaoRest>() { 
            @Override 
            public void onSuccess(AplicacaoRest model) { 
            	System.out.println("Sucesso: " + model);
            	TestadorApp.executa(model);
            }
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			} 
        });
               
	}

}
