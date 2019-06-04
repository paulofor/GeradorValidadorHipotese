package gerapp.app;

public class Configuracao {
	

	
	

	private AplicacaoWrapper aplicacao;

	public void setAmbiente(String dado) {
		this.ambiente = dado;
	}
	
	
	public Configuracao(AplicacaoWrapper aplic) {
		aplicacao = aplic;
	}

	public String getNamespaceExtendido() {
		return "br.com.lojadigicom." + aplicacao.getNamespacePacote();
	}
	
	public String getNamespace() {
		return aplicacao.getNamespacePacote();
	}

	public String getNomePacoteServicoInterface() {
		return aplicacao.getNamespacePacote() + ".servico";
	}

	public String getNomePacoteServicoSqliteBase() {
		return aplicacao.getNamespacePacote() + ".servico.sqlite.base";
	}

	public String getNomePacoteServicoSqliteImpl() {
		return aplicacao.getNamespacePacote() + ".servico.sqlite.impl";
	}

	public String getNomePacoteServicoWsJsonBase() {
		return aplicacao.getNamespacePacote() + ".servico.wsjson.base";
	}

	public String getNomePacoteServicoWsJsonImpl() {
		return aplicacao.getNamespacePacote() + ".servico.wsjson.impl";
	}

	public String getNomeAplicacao() {
		return aplicacao.getNomeAplicacao();
	}

	public String getNomePacoteRegraColecaoBase() {
		return aplicacao.getNamespacePacote() + ".regracolecao.base";
	}

	public String getNomePacoteRegraColecaoImpl() {
		return aplicacao.getNamespacePacote() + ".regracolecao.impl";
	}

	public String getNomePacoteRegraColecaoInterface() {
		return aplicacao.getNamespacePacote() + ".regracolecao";
	}

	public String getNomePacoteModeloVo() {
		return aplicacao.getNamespacePacote() + ".modelo.vo";
	}

	public String getNomePacoteDaoBase() {
		return aplicacao.getNamespacePacote() + ".dao.base";
	}

	public String getPathCs2008() {
		return aplicacao.getPathPrincipalCs2008() + "//"
				+ aplicacao.getNamespacePath();
	}

	// CS
	public String getPathCs() {
		return aplicacao.getPathPrincipalCsWeb() + "//"
				+ aplicacao.getNamespacePath();
	}

	public String getPathAspxPage() {
		return aplicacao.getPathPrincipalCsWeb() + "//"
				+ aplicacao.getNamespacePath() + "//page";
	}

	public String getPathAspxCs() {
		return aplicacao.getPathPrincipalCsWeb() + "//"
				+ aplicacao.getNamespacePath() + "//page";
	}

	public String getPathMobileDecoratorCs() {
		return aplicacao.getPathPrincipalCsWeb() + "//"
				+ aplicacao.getNamespacePath() + "//modelo//mobile";
	}

	public String getPathMobileVoCs() {
		return aplicacao.getPathPrincipalCsWeb() + "//"
				+ aplicacao.getNamespacePath() + "//modelo//mobilevo";
	}

	public String getNomePacoteAspxClasse() {
		return aplicacao.getNamespacePacote();
	}

	public String getNomePacoteMobileDecoratorCs() {
		return aplicacao.getNamespacePacote() + ".modelo.mobile";
	}

	// Java
	public String getPathJava() {
		return aplicacao.getPathPrincipalJava() + "//"
				+ aplicacao.getNamespacePath();
	}

	// Java Android
	public String getPathAndroid() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath();
	}
	
	public String getNamespacePath() {
		return aplicacao.getNamespacePath();
	}

	public String getPathPacoteRegraColecaoBase() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//regracolecao//base";
	}

	public String getPathPacoteRegraColecaoImpl() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//regracolecao//impl";
	}

	public String getPathPacoteRegraColecaoInterface() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//regracolecao";
	}

	public String getPathPacoteModeloVo() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//modelo//vo";
	}

	public String getPathPacoteDaoBase() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//dao//base";
	}

	public String getPathServicoInterface() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//servico";
	}

	public String getPathServicoSqliteBase() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//servico//sqlite//base";
	}

	public String getPathServicoSqliteImpl() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//servico//sqlite//impl";
	}

	public String getPathServicoWsJsonBase() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//servico//wsjson//base";
	}

	public String getPathServicoWsJsonImpl() {
		return aplicacao.getPathPrincipalAndroid() + "//"
				+ aplicacao.getNamespacePath() + "//servico//wsjson//impl";
	}

	public String getPathCpp() {
		return aplicacao.getPathCpp();
	}
	
	public String getDiretorioModuloAndroid() {
		return aplicacao.getPathCpp();
	}
}
