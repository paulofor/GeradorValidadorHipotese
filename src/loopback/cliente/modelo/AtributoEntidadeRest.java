package loopback.cliente.modelo;

import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.FabricaVo;
import loopback.android.Model;

public class AtributoEntidadeRest  extends Model {

	
	private Integer id_atributo_entidade;
	private String nome;
	private String tipo;
	private String obrigatorio;
	private String editavel;
	private String label_tela;
	private Integer ordenacao_tela;
	private Integer id_entidade;
	
	public Integer getId_atributo_entidade() {
		return id_atributo_entidade;
	}
	public void setId_atributo_entidade(Integer id_atributo_entidade) {
		this.id_atributo_entidade = id_atributo_entidade;
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
	public String getObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(String obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	public String getEditavel() {
		return editavel;
	}
	public void setEditavel(String editavel) {
		this.editavel = editavel;
	}
	public String getLabel_tela() {
		return label_tela;
	}
	public void setLabel_tela(String label_tela) {
		this.label_tela = label_tela;
	}
	public Integer getOrdenacao_tela() {
		return ordenacao_tela;
	}
	public void setOrdenacao_tela(Integer ordenacao_tela) {
		this.ordenacao_tela = ordenacao_tela;
	}
	public Integer getId_entidade() {
		return id_entidade;
	}
	public void setId_entidade(Integer id_entidade) {
		this.id_entidade = id_entidade;
	}
	public AtributoEntidade criaItem() {
		AtributoEntidade vo = FabricaVo.criaAtributoEntidade();
		vo.setIdAtributoEntidade(this.id_atributo_entidade);
		vo.setNome(this.nome);
		vo.setTipo(this.tipo);
		vo.setLabelTela(this.label_tela);
		return vo;
	}
	
	
	
}
