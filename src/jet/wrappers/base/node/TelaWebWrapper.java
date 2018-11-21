package jet.wrappers.base.node;

import gerapp.modelo.ComponenteTela;
import loopback.cliente.modelo.TelaWebRest;

public class TelaWebWrapper implements ComponenteTela{

	private TelaWebRest principal = null;
	
	public TelaWebWrapper(TelaWebRest principal) {
		this.principal = principal;
	}
	
	public String getNomeMenu() {
		return principal.getNomeMenu();
	}
	
	public String getNomeUrl() {
		String nome = principal.getNome();
		return nome.toLowerCase();
	}
	

	@Override
	public String getArquivo() {
		String nome = principal.getNome();
		return nome.toLowerCase() + "-tela";
	}

	@Override
	public String getNome() {
		return principal.getNome() + "TelaComponent";
	}
}
