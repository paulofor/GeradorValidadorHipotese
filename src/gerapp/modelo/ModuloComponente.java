package gerapp.modelo;

import java.util.List;

public class ModuloComponente {

	
	private String nomeModulo;
	private List<ComponenteTela> listaComponente;
	private String nomeArquivo;
	
	public ModuloComponente(String nome) {
		nomeModulo = nome;
	}

	public List<ComponenteTela> getListaComponente() {
		return listaComponente;
	}

	public void setListaComponente(List<ComponenteTela> listaComponente) {
		this.listaComponente = listaComponente;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	public String getNome() {
		return nomeModulo;
	}
	public String getNomeVariavel() {
		return nomeModulo.substring(0,1).toLowerCase() + nomeModulo.substring(1);
	}
}
