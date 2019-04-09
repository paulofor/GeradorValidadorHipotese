package gerapp.app;

import gerapp.modelo.Entidade;

import java.io.IOException;

import jet.wrappers.base.ClasseWrapper;

public class GeradorLoopbackServer extends GeradorArquivosLoopback{
	
	private String PATH = "../../../../ProdutosNode/";

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("...criaArquivoEntidade");
		
	}

	@Override
	protected void criaArquivoProjeto(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("...criaArquivoProjeto");
		
	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("...criaArquivoUnico");
		
	}

	

	@Override
	public void limpaArquivos(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("...limpaArquivos");
	}

	@Override
	protected void montaListasNovas(Recursos recurso) {
		// TODO Auto-generated method stub
		System.out.println("...montaListasNovas");
	}

}
