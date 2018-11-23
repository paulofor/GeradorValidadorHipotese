package gerapp.modelo.node;


public class ItemComponentexxx implements ItemAngular{

	private String nome;
	private String arquivo;
	
	public ItemComponentexxx(String nome, String arquivo) {
		this.nome = nome;
		this.arquivo = arquivo;
	}
	
	public String getNomeVariavel() {
		return nome.substring(0,1).toLowerCase() + nome.substring(1);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	
}
