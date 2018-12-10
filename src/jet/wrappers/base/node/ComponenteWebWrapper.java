package jet.wrappers.base.node;

import gerapp.modelo.node.ItemComponente;
import loopback.cliente.modelo.ComponenteWebRest;

public class ComponenteWebWrapper implements ItemComponente{

	private ComponenteWebRest principal = null;
	
	
	
	public ComponenteWebWrapper(ComponenteWebRest componenteWeb) {
		this.principal = componenteWeb;
	}

	@Override
	public String getNomeControle() {
		return "meu-controle";
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
