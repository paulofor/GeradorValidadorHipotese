package app;

import gerapp.modelo.Aplicacao;
import gerapp.modelo.FabricaVo;

import gerapp.app.GeradorAngular;



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

}
