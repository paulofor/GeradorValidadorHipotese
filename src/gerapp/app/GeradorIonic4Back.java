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
		this.copiaArquivoSeNaoExiste("angular.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("ionic.config.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("package.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("package-lock.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("tsconfig.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("tslint.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste(".gitignore", pathOrigem, pathDestino, recurso);

		
		pathDestino = raizDestino + "src/";
		pathOrigem = raizOrigem + "src/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivoSeNaoExiste("global.scss", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("index.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("polyfills.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("test.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("tsconfig.app.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("tsconfig.spec.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("tslint.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("zone-flags.ts", pathOrigem, pathDestino, recurso);
		
		
		
		pathDestino = raizDestino + "src/app/";
		pathOrigem = raizOrigem + "src/app/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivoSeNaoExiste("app.component.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("app.component.spec.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("app.component.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("app.module.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("app-routine.module.ts", pathOrigem, pathDestino, recurso);
		
		
		
		pathDestino = raizDestino + "src/assets/";
		pathOrigem = raizOrigem + "src/assets/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		
		pathDestino = raizDestino + "src/assets/icon/";
		pathOrigem = raizOrigem + "src/assets/icon/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		
		
		
		pathDestino = raizDestino + "src/environments/";
		pathOrigem = raizOrigem + "src/environments/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivoSeNaoExiste("environment.prod.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivoSeNaoExiste("environment.ts", pathOrigem, pathDestino, recurso);

		
		
		pathDestino = raizDestino + "src/theme/";
		pathOrigem = raizOrigem + "src/theme/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivoSeNaoExiste("variables.scss", pathOrigem, pathDestino, recurso);
	
	
	}
}
