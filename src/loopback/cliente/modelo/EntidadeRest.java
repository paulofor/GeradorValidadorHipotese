package loopback.cliente.modelo;

import gerapp.modelo.Entidade;
import loopback.android.Model;

public class EntidadeRest extends Model{

	private Integer id_entidade;
	private String nome;
	private Integer id_chave;
	private Integer classe_pai;
	private Integer ordenacao;
	private String associativa;
	private Integer id_atributo_identificador;
	private Integer id_entidade_pai;
	private Integer id_aplicacao;
	public Integer getId_entidade() {
		return id_entidade;
	}
	public void setId_entidade(Integer id_entidade) {
		this.id_entidade = id_entidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId_chave() {
		return id_chave;
	}
	public void setId_chave(Integer id_chave) {
		this.id_chave = id_chave;
	}
	public Integer getClasse_pai() {
		return classe_pai;
	}
	public void setClasse_pai(Integer classe_pai) {
		this.classe_pai = classe_pai;
	}
	public Integer getOrdenacao() {
		return ordenacao;
	}
	public void setOrdenacao(Integer ordenacao) {
		this.ordenacao = ordenacao;
	}
	public String getAssociativa() {
		return associativa;
	}
	public void setAssociativa(String associativa) {
		this.associativa = associativa;
	}
	public Integer getId_atributo_identificador() {
		return id_atributo_identificador;
	}
	public void setId_atributo_identificador(Integer id_atributo_identificador) {
		this.id_atributo_identificador = id_atributo_identificador;
	}
	public Integer getId_entidade_pai() {
		return id_entidade_pai;
	}
	public void setId_entidade_pai(Integer id_entidade_pai) {
		this.id_entidade_pai = id_entidade_pai;
	}
	public Integer getId_aplicacao() {
		return id_aplicacao;
	}
	public void setId_aplicacao(Integer id_aplicacao) {
		this.id_aplicacao = id_aplicacao;
	}
	
	public Entidade criaItem() {
		Entidade item = FabricaVo.
	}
}
