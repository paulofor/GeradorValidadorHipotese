package jet.wrappers.angular;

import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.Entidade;
import gerapp.modelo.ProcValor;
import gerapp.modelo.RelacionamentoEntidade;
import gerapp.modelo.node.ItemComponente;
import jet.wrappers.base.AtributoWrapper;
import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.ProcValorWrapper;
import jet.wrappers.base.RelacionamentoWrapper;

public class ClasseWrapperAngular extends ClasseWrapper implements ItemComponente {

	private String tipo;
	
	public ClasseWrapperAngular(Entidade ent) {
		super(ent);
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	@Override
	public String getPathArquivo() {
		return getNomeParaArquivo() + "-" + getTipoMinusculo();
	}

	@Override
	public String getArquivo() {
		return getNomeParaArquivo() + "-" + getTipoMinusculo() + ".component";
	}

	private String getTipoMinusculo() {
		String nome = this.tipo;
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
	
	@Override
	public String getNome() {
		return this.entidade.getNome() + this.tipo + "Component";
	}
	
	public String getNomeControle() {
		return "app-" + getPathArquivo();
	}
}
