package loopback.cliente.modelo;

import gerapp.modelo.Aplicacao;
import loopback.android.Model;

public class AplicacaoRest  extends Model{

	private String projetoMySqlId;
	private String namespace;
	private Integer id_aplicacao;
	private String diretorio;
	private String nome;
	private String diretorio_java;
	
	
	public String getProjetoMySqlId() {
		return projetoMySqlId;
	}
	public void setProjetoMySqlId(String projetoMySqlId) {
		this.projetoMySqlId = projetoMySqlId;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public Integer getId_aplicacao() {
		return id_aplicacao;
	}
	public void setId_aplicacao(Integer id_aplicacao) {
		this.id_aplicacao = id_aplicacao;
	}
	public String getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDiretorio_java() {
		return diretorio_java;
	}
	public void setDiretorio_java(String diretorio_java) {
		this.diretorio_java = diretorio_java;
	}
	
	
	public String toString() {
		return this.id_aplicacao + " - " + namespace; 
	}
	
	public Aplicacao atualiza(Aplicacao aplicacao) {
		
		aplicacao.setIdAplicacao(this.id_aplicacao);
		return aplicacao;
	}
	
}
