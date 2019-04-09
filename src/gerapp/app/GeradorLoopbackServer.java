package gerapp.app;

import gerapp.modelo.node.ItemLoopbackServer;

import java.io.IOException;

import jet.server.ModelJs;
import jet.server.ModelJson;
import jet.server.app.ModelConfigJson;

public class GeradorLoopbackServer extends GeradorNodeBase {
	
	private String PATH = "../../../../ProdutoServer/";

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		System.out.println("...criaArquivoEntidade");
		String pathDestino = PATH + "//common//models//" 
			+ recurso.getConfiguracao().getNamespace() + "//"; 
		this.criaCaminhoSeNaoExiste(pathDestino);
		
		
		
		ItemLoopbackServer classe = (ItemLoopbackServer) recurso.getClasse();
		String nomeArquivo = pathDestino + classe.getNomeParaArquivoServer() + ".js";
		String conteudo = ModelJs.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
		nomeArquivo = pathDestino + classe.getNomeParaArquivoServer() + ".json";
		conteudo = ModelJson.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
	}

	@Override
	protected void criaArquivoProjeto(Recursos recurso) throws IOException {
		System.out.println("...criaArquivoProjeto");
	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		System.out.println("...criaArquivoUnico");
		String pathDestino = PATH + "//server/"; 
		this.criaCaminhoSeNaoExiste(pathDestino);
		
		String nomeArquivo = pathDestino + "model-config.json";
		String conteudo = ModelConfigJson.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
	}

	

	@Override
	public void limpaArquivos(Recursos recurso) throws IOException {
		System.out.println("...limpaArquivos");
	}

	

}
