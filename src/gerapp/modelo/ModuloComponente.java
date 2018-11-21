package gerapp.modelo;

import java.util.List;

public class ModuloComponente implements ComponenteTela{

	
	private String nomeModulo;
	private List<ComponenteTela> listaComponente;
	private String nomeArquivo;
	
	public ModuloComponente(String nome, String arquivo) {
		nomeModulo = nome;
		nomeArquivo = arquivo;
	}

	public List<ComponenteTela> getListaComponente() {
		return listaComponente;
	}

	public void setListaComponente(List<ComponenteTela> listaComponente) {
		this.listaComponente = listaComponente;
	}
	
	public String getArquivo() {
		return nomeArquivo;
	}
	
	public String getNome() {
		return nomeModulo;
	}
	public String getNomeVariavel() {
		return nomeModulo.substring(0,1).toLowerCase() + nomeModulo.substring(1);
	}
}
