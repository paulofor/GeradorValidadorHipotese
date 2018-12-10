package loopback.cliente.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import loopback.android.Model;
import loopback.android.remoting.BeanUtil;

public class TelaWebRest extends Model{
	

	private String objetivo;
	private String nome;
	private String nomeMenu;
	private Long aplicacaoId;
	private List<TelaComponenteWebRest> telaComponenteWebs; 
	
	
	
	public List<TelaComponenteWebRest> getTelaComponenteWebs() {
		return telaComponenteWebs;
	}
	public void setTelaComponenteWebs(ArrayList telaComponenteWebs) {
		this.telaComponenteWebs = new ArrayList<TelaComponenteWebRest>();
		for (int i=0; i<telaComponenteWebs.size(); i++) {
			Object objeto = new TelaComponenteWebRest();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) telaComponenteWebs.get(i), true);
			this.telaComponenteWebs.add((TelaComponenteWebRest) objeto);
		}
		System.out.println(this + " tam: " + this.telaComponenteWebs.size());
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
