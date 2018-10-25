package gerapp.app;

import gerapp.modelo.Entidade;

import java.io.IOException;

import jet.angular.componente.ComponenteScssVazio;
import jet.angular.componente.lista.ComponenteHtmlLista;
import jet.angular.componente.lista.ComponenteSpecLista;
import jet.angular.componente.lista.ComponenteTsLista;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;

public class GeradorAngular extends GeradorArquivosLoopback {

	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;

	
	
	
	
	
	
	@Override
	protected void verificaDiretorios(Recursos recurso) throws IOException {
		if (!existe(this.getDiretorioAppAngular(recurso))) {
			this.criaCaminho(this.getDiretorioAppAngular(recurso));
		}
	}

	private String getDiretorioAppAngular(Recursos recurso) {
		return PATH + recurso.getConfiguracao().getNamespace();
	}

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		componenteListaSimples(recurso);
	}

	private void componenteListaSimples(Recursos recurso) throws IOException {
		String nomeArquivo = PATH + recurso.getConfiguracao().getNamespace()
				+ "//src//app//" + recurso.getClasse().getNomeParaClasse()
				+ "-Lista//"
				+ recurso.getClasse().getNomeParaClasse().toLowerCase()
				+ "-lista.component.ts";
		String conteudo = ComponenteTsLista.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		nomeArquivo = PATH + recurso.getConfiguracao().getNamespace()
				+ "//src//app//" + recurso.getClasse().getNomeParaClasse()
				+ "-Lista//"
				+ recurso.getClasse().getNomeParaClasse().toLowerCase()
				+ "-lista.component.html";
		conteudo = ComponenteHtmlLista.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		nomeArquivo = PATH + recurso.getConfiguracao().getNamespace()
				+ "//src//app//" + recurso.getClasse().getNomeParaClasse()
				+ "-Lista//"
				+ recurso.getClasse().getNomeParaClasse().toLowerCase()
				+ "-lista.component.scss";
		conteudo = ComponenteScssVazio.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		nomeArquivo = PATH + recurso.getConfiguracao().getNamespace()
				+ "//src//app//" + recurso.getClasse().getNomeParaClasse()
				+ "-Lista//"
				+ recurso.getClasse().getNomeParaClasse().toLowerCase()
				+ "-lista.component.spec.ts";
		conteudo = ComponenteSpecLista.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		//String nomeArquivo = recurso.getConfiguracao().getPathAndroid()
		//		+ "//servico//FabricaServico.java";
		// String conteudo = FabricaServico.create("\n").generate(recurso);
		// geraArquivoFonte(conteudo,nomeArquivo);

	}

	@Override
	protected ClasseWrapper criaWrapper(Entidade entidade) {
		return new ClasseWrapperAngular(entidade);
	}

	@Override
	public void limpaArquivos(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub

	}

}
