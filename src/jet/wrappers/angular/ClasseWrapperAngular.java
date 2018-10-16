package jet.wrappers.angular;

import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.Entidade;
import gerapp.modelo.ProcValor;
import gerapp.modelo.RelacionamentoEntidade;
import jet.wrappers.base.AtributoWrapper;
import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.ProcValorWrapper;
import jet.wrappers.base.RelacionamentoWrapper;

public class ClasseWrapperAngular extends ClasseWrapper {

	public ClasseWrapperAngular(Entidade ent) {
		super(ent);
	}

	@Override
	protected RelacionamentoWrapper criaRelacionamentoWrapper(
			RelacionamentoEntidade relac) {
		return new RelacionamentoWrapperAngular(relac);
	}

	@Override
	protected AtributoWrapper criaAtributoWrapper(AtributoEntidade item) {
		return new AtributoWrapperAngular(item);
	}

	@Override
	protected ProcValorWrapper criaProcValorWrapper(ProcValor item) {
		return new ProcValorWrapperAngular(item);
	}

	public String getNomeParaArquivo() {
		String nome = this.getNomeParaClasse();
		String saida = "";
		for (int i=0;i < nome.length(); i++) {
			if (Character.isUpperCase(nome.charAt(i))) {
				if (i==0) saida += ("" + nome.charAt(i)).toLowerCase();
				else saida += "-" + ("" + nome.charAt(i)).toLowerCase();
			} else {
				saida += ("" + nome.charAt(i));
			}
		}
		return saida;
	}
}
