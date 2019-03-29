package loopback.cliente.modelo;

import loopback.android.Model;

public class TelaAppRest extends Model{

	private String nome;
	private String tipo;
	private Integer entidadeId;
	private Integer conceitoProdutoId;
	private Integer sobrescreveHtml;
	private Integer sobrescreveTs;
	
	
	public Integer getSobrescreveTs() {
		return sobrescreveTs;
	}
	public void setSobrescreveTs(Integer sobrescreveTs) {
		this.sobrescreveTs = sobrescreveTs;
	}
	public Integer getSobrescreveHtml() {
		return sobrescreveHtml;
	}
	public void setSobrescreveHtml(Integer sobrescreveHtml) {
		this.sobrescreveHtml = sobrescreveHtml;
	}
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
	public Integer getEntidadeId() {
		return entidadeId;
	}
	public void setEntidadeId(Integer entidadeId) {
		this.entidadeId = entidadeId;
	}
	public Integer getConceitoProdutoId() {
		return conceitoProdutoId;
	}
	public void setConceitoProdutoId(Integer conceitoProdutoId) {
		this.conceitoProdutoId = conceitoProdutoId;
	}
	
	
}
