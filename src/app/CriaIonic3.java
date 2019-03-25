package app;

import gerapp.app.GeradorIonic3;
import gerapp.modelo.Aplicacao;
import loopback.android.callback.ObjectCallback;
import loopback.cliente.modelo.AplicacaoRest;
import loopback.cliente.repositorio.AplicacaoRepositorio;
import loopback.remoting.adapters.RestAdapter;

public class CriaIonic3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Ola Mundo");
		
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		AplicacaoRepositorio rep = adapter.createRepository(AplicacaoRepositorio.class);
		
		rep.findById(27, new ObjectCallback<AplicacaoRest>() { 
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
		GeradorIonic3 gerador = new GeradorIonic3();
		try {
			gerador.setAplicacao(aplicacao);
			gerador.criaArquivos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
