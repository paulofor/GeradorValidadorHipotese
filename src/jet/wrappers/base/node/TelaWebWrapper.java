package jet.wrappers.base.node;

import gerapp.modelo.node.ItemComponente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import loopback.cliente.modelo.TelaComponenteWebRest;
import loopback.cliente.modelo.TelaWebRest;

public class TelaWebWrapper implements ItemComponente{

	private TelaWebRest principal = null;
	private List<ItemComponente> listaComponente = null;
	
	public TelaWebWrapper(TelaWebRest principal) {
		this.principal = principal;
		listaComponente = new ArrayList<ItemComponente>();
		for (TelaComponenteWebRest rel : principal.getTelaComponenteWebs()) {
			listaComponente.add(new ComponenteWebWrapper(rel.getComponenteWeb()));
		}
	}
	
	public Iterator<ItemComponente>  getComponenteIterator() {
		return listaComponente.iterator();
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
		return nome.toLowerCase() + "-tela.component";
	}

	@Override
	public String getNome() {
		return principal.getNome() + "TelaComponent";
	}

	@Override
	public String getPathArquivo() {
		String nome = principal.getNome();
		return nome.toLowerCase() + "-tela";
	}

	@Override
	public String getNomeControle() {
		String nome = principal.getNome();
		return nome.toLowerCase() + "-tela";
	}
}
