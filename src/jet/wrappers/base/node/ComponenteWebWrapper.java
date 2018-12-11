package jet.wrappers.base.node;

import gerapp.modelo.node.ItemComponente;
import gerapp.padrao.node.ConversorNome;
import loopback.cliente.modelo.ComponenteWebRest;

public class ComponenteWebWrapper implements ItemComponente{

	private ComponenteWebRest principal = null;
	
	
	
	public ComponenteWebWrapper(ComponenteWebRest componenteWeb) {
		this.principal = componenteWeb;
	}

	@Override
	public String getNomeControle() {
		return ConversorNome.getNomeControle(principal.getNome());
	}

	@Override
	public String getPathArquivo() {
		// TODO Auto-generated method stub
		return null;
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
