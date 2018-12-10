package loopback.cliente.modelo;

import loopback.android.Model;

public class ComponenteWebRest extends Model{

	private String nome;
	
	private Integer entidadeId;
	
	private Integer aplicacaoId;
	
	private Integer tipoComponenteWebId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEntidadeId() {
		return entidadeId;
	}

	public void setEntidadeId(Integer entidadeId) {
		this.entidadeId = entidadeId;
	}

	public Integer getAplicacaoId() {
		return aplicacaoId;
	}

	public void setAplicacaoId(Integer aplicacaoId) {
		this.aplicacaoId = aplicacaoId;
	}

	public Integer getTipoComponenteWebId() {
		return tipoComponenteWebId;
	}

	public void setTipoComponenteWebId(Integer tipoComponenteWebId) {
		this.tipoComponenteWebId = tipoComponenteWebId;
	}
	
	
	
}
