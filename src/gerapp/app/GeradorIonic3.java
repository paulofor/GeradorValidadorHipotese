package gerapp.app;

import gerapp.modelo.Entidade;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;

public class GeradorIonic3 extends GeradorArquivosLoopback{

	
	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;

	private String getDiretorioAngular(Recursos recurso) {
		return PATH + recurso.getConfiguracao().getNamespace() + "//ionic3//src//app//";
	}
	
	
	@Override
	protected ClasseWrapper criaWrapper(Entidade entidade) {
		return new ClasseWrapperAngular(entidade);
	}
}
