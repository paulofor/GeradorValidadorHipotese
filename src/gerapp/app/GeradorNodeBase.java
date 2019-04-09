package gerapp.app;

import gerapp.modelo.Entidade;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;

public abstract class GeradorNodeBase extends GeradorArquivosLoopback {
	
	@Override
	protected ClasseWrapper criaWrapper(Entidade entidade) {
		return new ClasseWrapperAngular(entidade);
	}
}
