package gerapp.app;

import java.io.IOException;

import jet.wrappers.base.ClasseWrapper;

public class GeradorIonic4Back extends GeradorNodeBase{

	
	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;

	private String getDiretorioAngular(Recursos recurso) {
		return PATH + recurso.getConfiguracao().getNamespace() + "/ionic4_back/src/";
	}
	
	protected void criaArquivoProjeto(Recursos recurso) throws IOException {
		String raizDestino = PATH + recurso.getConfiguracao().getNamespace() + "/ionic4_back/";
		String raizOrigem = "./fixos/fixoIonic4/";
		
		String pathDestino = raizDestino;
		String pathOrigem = raizOrigem;
		this.criaCaminhoSeNaoExiste(pathDestino);
	}
}
