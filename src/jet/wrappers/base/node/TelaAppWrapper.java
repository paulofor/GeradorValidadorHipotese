package jet.wrappers.base.node;

import gerapp.modelo.node.ItemComponente;
import loopback.cliente.modelo.TelaAppRest;
import loopback.cliente.modelo.TelaWebRest;

public class TelaAppWrapper implements ItemComponente{

	
	private TelaAppRest principal = null;
	
	public TelaAppWrapper(TelaAppRest principal) {
		this.principal = principal;
	}
	
	
	@Override
	public String getNomeControle() {
		return "nome-controle";
	}

	@Override
	public String getPathArquivo() {
		return "path-arquivo";
	}

	@Override
	public String getArquivo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
