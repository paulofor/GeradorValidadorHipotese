package loopback.cliente.modelo;

import loopback.android.Model;

public class TelaAppRest extends Model{

	private String nome;
	private String tipo;
	private Long entidadeId;
	private Long conceitoProdutoId;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getEntidadeId() {
		return entidadeId;
	}
	public void setEntidadeId(Long entidadeId) {
		this.entidadeId = entidadeId;
	}
	public Long getConceitoProdutoId() {
		return conceitoProdutoId;
	}
	public void setConceitoProdutoId(Long conceitoProdutoId) {
		this.conceitoProdutoId = conceitoProdutoId;
	}
	
	
}
