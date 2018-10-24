package loopback.cliente.modelo;

import gerapp.modelo.FabricaVo;
import gerapp.modelo.RelacionamentoEntidade;
import loopback.android.Model;

public class RelacionamentoEntidadeRest extends Model{

	private Integer id_relacionamento_entidade;
	private String qtde_entidade1;
	private String qtde_entidade2;
	private String nome1;
	private String nome2;
	private String editavel;
	private String label_tela;
	private String tipo_apresentacao;
	private String obrigatorio;
	private String dependente;
	private Integer id_entidade1;
	private Integer id_entidade2;
	
	
	
	
	
	public Integer getId_relacionamento_entidade() {
		return id_relacionamento_entidade;
	}





	public void setId_relacionamento_entidade(Integer id_relacionamento_entidade) {
		this.id_relacionamento_entidade = id_relacionamento_entidade;
	}





	public String getQtde_entidade1() {
		return qtde_entidade1;
	}





	public void setQtde_entidade1(String qtde_entidade1) {
		this.qtde_entidade1 = qtde_entidade1;
	}





	public String getQtde_entidade2() {
		return qtde_entidade2;
	}





	public void setQtde_entidade2(String qtde_entidade2) {
		this.qtde_entidade2 = qtde_entidade2;
	}





	public String getNome1() {
		return nome1;
	}





	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}





	public String getNome2() {
		return nome2;
	}





	public void setNome2(String nome2) {
		this.nome2 = nome2;
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





	public String getTipo_apresentacao() {
		return tipo_apresentacao;
	}





	public void setTipo_apresentacao(String tipo_apresentacao) {
		this.tipo_apresentacao = tipo_apresentacao;
	}





	public String getObrigatorio() {
		return obrigatorio;
	}





	public void setObrigatorio(String obrigatorio) {
		this.obrigatorio = obrigatorio;
	}





	public String getDependente() {
		return dependente;
	}





	public void setDependente(String dependente) {
		this.dependente = dependente;
	}





	public Integer getId_entidade1() {
		return id_entidade1;
	}





	public void setId_entidade1(Integer id_entidade1) {
		this.id_entidade1 = id_entidade1;
	}





	public Integer getId_entidade2() {
		return id_entidade2;
	}





	public void setId_entidade2(Integer id_entidade2) {
		this.id_entidade2 = id_entidade2;
	}





	public RelacionamentoEntidade criaItem() {
		RelacionamentoEntidade item = FabricaVo.criaRelacionamentoEntidade();
		//item.setDependente(this.dependente);
		item.setIdEntidade1(this.id_entidade1);
		item.setIdEntidade2(this.id_entidade2);
		item.setIdRelacionamentoEntidade(this.id_relacionamento_entidade);
		item.setNome1(this.nome1);
		item.setNome2(this.nome2);
		item.setQtdeEntidade1(this.qtde_entidade1);
		item.setQtdeEntidade2(this.qtde_entidade2);
		return item;
	}

}
