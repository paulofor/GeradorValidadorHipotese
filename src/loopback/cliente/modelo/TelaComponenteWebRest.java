package loopback.cliente.modelo;

import java.util.HashMap;
import java.util.Map;

import loopback.android.Model;
import loopback.android.remoting.BeanUtil;

public class TelaComponenteWebRest extends Model{

	private Integer ordenacao;
	private Integer componenteWebId;
	private Integer telaWebId;
	private ComponenteWebRest componenteWeb;
	
	
	public Integer getOrdenacao() {
		return ordenacao;
	}
	public void setOrdenacao(Integer ordenacao) {
		this.ordenacao = ordenacao;
	}
	public Integer getComponenteWebId() {
		return componenteWebId;
	}
	public void setComponenteWebId(Integer componenteWebId) {
		this.componenteWebId = componenteWebId;
	}
	public Integer getTelaWebId() {
		return telaWebId;
	}
	public void setTelaWebId(Integer telaWebId) {
		this.telaWebId = telaWebId;
	}
	public ComponenteWebRest getComponenteWeb() {
		return componenteWeb;
	}
	
	
	public void setComponenteWeb(HashMap componenteWeb) {
		Object objeto = new ComponenteWebRest();
		BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) componenteWeb, true);
		this.componenteWeb = (ComponenteWebRest) objeto;
		System.out.println("Componente: " + this.componenteWeb.getNome());
	}
	
	
	
	
	
}
