package jet.wrappers.base.node;

import loopback.cliente.modelo.TelaWebRest;

public class TelaWebWrapper {

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
	public String getNomeArquivoComponente() {
		String nome = principal.getNome();
		return nome.toLowerCase();
	}
	
	public String getNomeComponente() {
		return principal.getNome();
	}
}
