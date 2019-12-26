package app;

import gerapp.app.GeradorIonic3Back;
import gerapp.modelo.Aplicacao;
import loopback.android.callback.ObjectCallback;
import loopback.cliente.modelo.AplicacaoRest;
import loopback.cliente.repositorio.AplicacaoRepositorio;
import loopback.remoting.adapters.RestAdapter;

public class CriaIonic3BackObj {

	
	private String ambiente = null;
	/**
	 * @param args
	 */
	public void run(String ambiente) {
		this.ambiente = ambiente;
		System.out.println("Ola Mundo " + ambiente);

		RestAdapter adapter = new RestAdapter("https://www.digicom.inf.br:21101/api");
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

	public void executa(AplicacaoRest appRest) {
		Aplicacao aplicacao = appRest.criaItem();
		GeradorIonic3Back gerador = new GeradorIonic3Back(this.ambiente);
		try {
			gerador.setAplicacao(aplicacao);
			gerador.criaArquivos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
