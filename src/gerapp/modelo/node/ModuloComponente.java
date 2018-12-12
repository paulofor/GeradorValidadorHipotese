package gerapp.modelo.node;


import java.util.ArrayList;
import java.util.List;

public class ModuloComponente implements ItemAngular{

	
	private String nomeModulo;
	private List<ItemComponente> listaComponente;
	private String nomeArquivo;
	private List<ModuloComponente> listaImportado;
	private String pathArquivo;
	
	
	public ModuloComponente(String nome, String arquivo, String path) {
		nomeModulo = nome;
		nomeArquivo = arquivo;
		pathArquivo = path;
		listaImportado = new ArrayList<ModuloComponente>();
	}
	

	public ModuloComponente(String nome, String arquivo) {
		this(nome,arquivo,"");
	}

	public String getPathArquivo() {
		return this.pathArquivo;
	}
	
	
	public List<ModuloComponente> getListaModuloImportado() {
		return listaImportado;
	}
	public void adicionaModuloImportado(ModuloComponente modulo) {
		listaImportado.add(modulo);
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
