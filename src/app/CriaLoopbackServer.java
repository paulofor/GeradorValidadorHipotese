package app;

import gerapp.app.GeradorLoopbackServer;
import gerapp.modelo.Aplicacao;
import loopback.android.callback.ObjectCallback;
import loopback.cliente.modelo.AplicacaoRest;
import loopback.cliente.repositorio.AplicacaoRepositorio;
import loopback.remoting.adapters.RestAdapter;

public class CriaLoopbackServer {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Ola Mundo - Loopback Server");
		
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		AplicacaoRepositorio rep = adapter.createRepository(AplicacaoRepositorio.class);
		
		rep.findById(32, new ObjectCallback<AplicacaoRest>() { 
            @Override 
            public void onSuccess(AplicacaoRest model) { 
            	System.out.println("Sucesso: " + model);
            	executa(model);
            }
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			} 
	    });
	}
	
	
	public static void executa(AplicacaoRest appRest) {
		Aplicacao aplicacao = appRest.criaItem();
		GeradorLoopbackServer gerador = new GeradorLoopbackServer();
		try {
			gerador.setAplicacao(aplicacao);
			gerador.criaArquivos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
