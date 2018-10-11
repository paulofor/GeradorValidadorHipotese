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
		// TODO Auto-generated constructor stub
	}

	@Override
	protected RelacionamentoWrapper criaRelacionamentoWrapper(
			RelacionamentoEntidade relac) {
		// TODO Auto-generated method stub
		return new RelacionamentoWrapperAngular(relac);
	}

	@Override
	protected AtributoWrapper criaAtributoWrapper(AtributoEntidade item) {
		// TODO Auto-generated method stub
		return new AtributoWrapperAngular(item);
	}

	@Override
	protected ProcValorWrapper criaProcValorWrapper(ProcValor item) {
		// TODO Auto-generated method stub
		return new ProcValorWrapperAngular(item);
	}

}
