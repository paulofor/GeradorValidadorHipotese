package app;

import gerapp.app.GeradorAngular;
import gerapp.modelo.Aplicacao;
import gerapp.modelo.FabricaVo;
import loopback.cliente.modelo.AplicacaoRest;



public class TestadorApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Ola Mundo !");
		Aplicacao aplicacao = FabricaVo.criaAplicacao();
		aplicacao.setIdAplicacao(1);
		GeradorAngular gerador = new GeradorAngular();
		//GeradorArquivosAndroid2 gerador = new GeradorArquivosAndroid2();
		//GeradorArquivosCpp gerador = new GeradorArquivosCpp();
		try {
			gerador.setAplicacao(aplicacao);
			gerador.criaArquivos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void executa(AplicacaoRest appRest) {
		Aplicacao aplicacao = FabricaVo.criaAplicacao();
		//aplicacao.setIdAplicacao(1);
		aplicacao = appRest.atualiza(aplicacao);
		GeradorAngular gerador = new GeradorAngular();
		try {
			gerador.setAplicacao(aplicacao);
			gerador.criaArquivos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
