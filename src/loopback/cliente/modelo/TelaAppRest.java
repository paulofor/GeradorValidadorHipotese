package loopback.cliente.modelo;

import java.util.Map;

import loopback.android.Model;
import loopback.android.remoting.BeanUtil;

public class TelaAppRest extends Model{

	private String nome;
	private String tipo;
	private Integer entidadeId;
	private Integer entidadePutId;
	private Integer conceitoProdutoId;
	private Integer sobrescreveHtml;
	private Integer sobrescreveTs;
	private String nomeMenu;
	private String chave;
	
	private Integer telaEdicaoId;
	private TelaAppRest telaEdicao;
	
	public void setTelaEdicao(Object telaEdicao) {
		this.telaEdicao = new TelaAppRest();
		BeanUtil.setProperties(this.telaEdicao, (Map<String, ? extends Object>) telaEdicao, true);
	}
	public TelaAppRest getTelaEdicao() {
		return this.telaEdicao;
	}
	
	
	
	public Integer getTelaEdicaoId() {
		return telaEdicaoId;
	}
	public void setTelaEdicaoId(Integer telaEdicaoId) {
		this.telaEdicaoId = telaEdicaoId;
	}
	public String getNomeMenu() {
		return nomeMenu;
	}
	public void setNomeMenu(String nomeMenu) {
		this.nomeMenu = nomeMenu;
	}
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
	public Integer getEntidadePutId() {
		return entidadePutId;
	}
	public void setEntidadePutId(Integer entidadePutId) {
		this.entidadePutId = entidadePutId;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getChave() {
		return this.chave;
	}
	
}
