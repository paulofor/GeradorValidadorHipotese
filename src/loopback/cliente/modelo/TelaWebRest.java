package loopback.cliente.modelo;

import loopback.android.Model;

public class TelaWebRest extends Model{
	
	private Long id;
	private String objetivo;
	private String nome;
	private String nomeMenu;
	private Long aplicacaoId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeMenu() {
		return nomeMenu;
	}
	public void setNomeMenu(String nomeMenu) {
		this.nomeMenu = nomeMenu;
	}
	public Long getAplicacaoId() {
		return aplicacaoId;
	}
	public void setAplicacaoId(Long aplicacaoId) {
		this.aplicacaoId = aplicacaoId;
	}
	
	
}
