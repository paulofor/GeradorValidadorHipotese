package gerapp.modelo.node;


import java.util.List;

public class ModuloComponente implements ItemAngular{

	
	private String nomeModulo;
	private List<ItemComponente> listaComponente;
	private String nomeArquivo;
	
	public ModuloComponente(String nome, String arquivo) {
		nomeModulo = nome;
		nomeArquivo = arquivo;
	}

	public List<ItemComponente> getListaComponente() {
		return listaComponente;
	}

	public void setListaComponente(List<ItemComponente> listaComponente) {
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
