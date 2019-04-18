package gerapp.app;

import java.util.List;

import gerapp.modelo.Entidade;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaAppWrapper;

public abstract class GeradorNodeBase extends GeradorArquivosLoopback {
	
	@Override
	protected ClasseWrapper criaWrapper(Entidade entidade) {
		return new ClasseWrapperAngular(entidade);
	}
	
	protected final void carregaEntidade(TelaAppWrapper tela, Recursos recursos) {
		if (tela.getIdEntidade()!=0) {
			ClasseWrapper entidade = obtemEntidadePorId(tela.getIdEntidade(),recursos);
			tela.setClasseWrapper(entidade);
		}
	}
	
	private final ClasseWrapper obtemEntidadePorId(long id, Recursos recurso) {
		ClasseWrapper saida = null;
		List<ClasseWrapper> listaClasse = recurso.getListaClasse();
		for (ClasseWrapper classe : listaClasse) {
			if (classe.getId() == id) {
				saida = classe;
			}
		}
		return saida;
	}
}
