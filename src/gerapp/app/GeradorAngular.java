package gerapp.app;

import gerapp.modelo.Entidade;

import java.io.IOException;
import java.util.List;

import jet.angular.componente.ComponenteScssVazio;
import jet.angular.componente.aplicacao.SidebarHtml;
import jet.angular.componente.lista.ComponenteHtmlLista;
import jet.angular.componente.lista.ComponenteSpecLista;
import jet.angular.componente.lista.ComponenteTsLista;
import jet.angular.componente.tela.ComponenteSpecTela;
import jet.angular.componente.tela.ComponenteTsTela;
import jet.angular.loopback.IndexModel;
import jet.angular.loopback.IndexPrincipal;
import jet.angular.loopback.IndexService;
import jet.angular.loopback.LoopbackModel;
import jet.angular.loopback.LoopbackService;
import jet.angular.loopback.SDKModel;
import jet.angular.projeto.PackageJson;
import jet.angular.projeto.PrincipalRouting;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaWebWrapper;

public class GeradorAngular extends GeradorArquivosLoopback {

	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;

	private String getDiretorioAngular(Recursos recurso) {
		return PATH + recurso.getConfiguracao().getNamespace() + "//front//src//app//";
	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		this.arquivosLoopbackClient(recurso);

		this.arquivosLoginFixo(recurso);
		this.arquivosPrincipalFixo(recurso);
		this.arquivosApp(recurso);
		
		this.arquivosProjeto(recurso);
		this.principalRouting(recurso);
		this.arquivosAdmHome(recurso);
		this.arquivosSidebar(recurso);
		

		this.criaComponentesTela(recurso);
		this.criaComponentesLista(recurso);
	}

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		entidade = recurso.getClasse();
		//componenteListaSimples(recurso);
	}

	/*
	 * Customizados:
	 * 
	 * sdk/index.ts sdk/models/todos + index sdk/services/index sdk/core/
	 */

	private void criaComponentesTela(Recursos recurso) throws IOException {
		String pathOrigem = ".//fixos//angular//componente-tela//";
		for (TelaWebWrapper tela : recurso.getListaTelaWeb()) {
			recurso.setTelaWebCorrente(tela);
			String pathDestino = getDiretorioAngular(recurso) + "//tela//" + tela.getNomeArquivoComponente() + "-tela//" ;
			this.criaCaminhoSeNaoExiste(pathDestino);
			this.limpaCaminho(pathDestino);
			this.copiaArquivo(pathOrigem + "componente-tela.css", pathDestino + tela.getNomeArquivoComponente() + "-tela.component.scss");
			this.copiaArquivo(pathOrigem + "componente-tela.html", pathDestino + tela.getNomeArquivoComponente() + "-tela.component.html");

			String nomeArquivo = pathDestino + tela.getNomeArquivoComponente() + "-tela.component.ts";
			String conteudo = ComponenteTsTela.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
			nomeArquivo = pathDestino + tela.getNomeArquivoComponente() + "-tela.component.spec.ts";
			conteudo = ComponenteSpecTela.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
		}
	}
	private void criaComponentesLista(Recursos recurso) throws IOException {
		for (ClasseWrapper classe : recurso.getListaClasse()) {
			recurso.setClasse(classe);
			String pathDestino = getDiretorioAngular(recurso) + "//lista//" + classe.getNomeParaClasse().toLowerCase() + "-lista//" ;
			this.criaCaminhoSeNaoExiste(pathDestino);
			this.limpaCaminho(pathDestino);
			
			String nomeArquivo = pathDestino + classe.getNomeParaClasse().toLowerCase() + "-lista.component.ts";
			String conteudo = ComponenteTsLista.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);

			nomeArquivo = pathDestino + classe.getNomeParaClasse().toLowerCase() + "-lista.component.html";
			conteudo = ComponenteHtmlLista.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);

			nomeArquivo = pathDestino + classe.getNomeParaClasse().toLowerCase() + "-lista.component.scss";
			conteudo = ComponenteScssVazio.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);

			nomeArquivo = pathDestino + classe.getNomeParaClasse().toLowerCase() + "-lista.component.spec.ts";
			conteudo = ComponenteSpecLista.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
		}
	}
	
	private void principalRouting(Recursos recurso) throws IOException {
		String pathDestino = getDiretorioAngular(recurso) + "//principal-routing//";
		this.criaCaminhoSeNaoExiste(pathDestino);

		String pathOrigem = ".//fixos//angular//principal-routing//";

		String nomeArquivo = pathDestino + "//principal-routing.module.ts";
		String conteudo = PrincipalRouting.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		this.copiaArquivo("principal.css", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("principal-routing.module.spec.ts", pathOrigem, pathDestino, recurso);

	}

	private void arquivosAdmHome(Recursos recurso) throws IOException {
		String pathDestino = getDiretorioAngular(recurso) + "//adm-home//";
		this.criaCaminhoSeNaoExiste(pathDestino);
		String pathOrigem = ".//fixos//angular//adm-home//";

		this.copiaArquivo("adm-home.component.css", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("adm-home.component.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("adm-home.component.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("adm-home.component.spec.ts", pathOrigem, pathDestino, recurso);
	}

	private void arquivosSidebar(Recursos recurso) throws IOException {
		String pathDestino = getDiretorioAngular(recurso) + "//sidebar//";
		this.criaCaminhoSeNaoExiste(pathDestino);
		String pathOrigem = ".//fixos//angular//sidebar//";

		this.copiaArquivo("sidebar.component.css", pathOrigem, pathDestino, recurso);
		// this.copiaArquivo("sidebar.component.html", pathOrigem, pathDestino,
		// recurso);
		this.copiaArquivo("sidebar.component.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("sidebar.component.spec.ts", pathOrigem, pathDestino, recurso);

		String nomeArquivo = pathDestino + "sidebar.component.html";
		String conteudo = SidebarHtml.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
	}

	private void arquivosLoginFixo(Recursos recurso) throws IOException {
		String pathOrigem = ".//fixos//angular//login//";
		String pathDestino = getDiretorioAngular(recurso) + "login//";

		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("login.component.css", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("login.component.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("login.component.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("login.component.spec.ts", pathOrigem, pathDestino, recurso);

	}

	private void arquivosPrincipalFixo(Recursos recurso) throws IOException {
		String pathOrigem = ".//fixos//angular//principal//";
		String pathDestino = getDiretorioAngular(recurso) + "principal//";

		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("principal.component.css", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("principal.component.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("principal.component.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("principal.component.spec.ts", pathOrigem, pathDestino, recurso);
	}

	private void arquivosProjeto(Recursos recurso) throws IOException {
		String pathDestino = PATH + recurso.getConfiguracao().getNamespace() + "//front//";
		String conteudo = "";
		String nomeArquivo = "";
		nomeArquivo = pathDestino + "//package.json";
		conteudo = PackageJson.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
	}
	
	private void arquivosApp(Recursos recurso) throws IOException {
		String pathOrigem = ".//fixos//angular//app-src//";
		String pathDestino = getDiretorioAngular(recurso);

		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("app.module.ts", pathOrigem, pathDestino, recurso);

	}

	private void arquivosLoopbackClient(Recursos recurso) throws IOException {
		String pathDestino = getDiretorioAngular(recurso) + "shared//sdk//";
		String conteudo = "";
		String nomeArquivo = "";
		arquivosLoopbackClientFixo(recurso, pathDestino);
		// Index Principal
		nomeArquivo = pathDestino + "//index.ts";
		conteudo = IndexPrincipal.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		// Index Modelo
		nomeArquivo = pathDestino + "//models//index.ts";
		conteudo = IndexModel.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		// Index Service
		nomeArquivo = pathDestino + "//services//custom//index.ts";
		conteudo = IndexService.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		// SDKModels
		nomeArquivo = pathDestino + "//services//custom//SDKModels.ts";
		conteudo = SDKModel.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		List<ClasseWrapper> listaClasse = recurso.getListaClasse();
		for (ClasseWrapper corrente : listaClasse) {
			recurso.setClasse(corrente);
			// Modelo
			nomeArquivo = pathDestino + "//models//" + corrente.getNomeParaClasse() + ".ts";
			conteudo = LoopbackModel.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
			// Servico
			nomeArquivo = pathDestino + "//services//custom//" + corrente.getNomeParaClasse() + ".ts";
			conteudo = LoopbackService.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
		}
	}

	private void arquivosLoopbackClientFixo(Recursos recurso, String pathDestino) throws IOException {
		// Path currentRelativePath = Paths.get("");
		// String s = currentRelativePath.toAbsolutePath().toString();
		// System.out.println("Current relative path is: " + s);
		String pathOrigem = ".//fixos//angular//loopback//sdk//";

		this.criaCaminhoSeNaoExiste(pathDestino);
		this.criaCaminhoSeNaoExiste(pathDestino + "//models//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//core//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//custom//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//sockets//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//storage//");

		// Raiz
		this.copiaArquivo("lb.config.ts", pathOrigem, pathDestino, recurso);

		// Models
		this.copiaArquivo("//models//BaseModels.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//models//Container.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//models//FireLoop.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//models//FireLoopRef.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//models//User.ts", pathOrigem, pathDestino, recurso);

		// Services
		this.copiaArquivo("//services//index.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//core//auth.service.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//core//base.service.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//core//error.service.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//core//index.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//core//io.service.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//core//real.time.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//custom//Container.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//custom//logger.service.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//custom//SDKModels.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//services//custom//User.ts", pathOrigem, pathDestino, recurso);

		// Sockets
		this.copiaArquivo("//sockets//socket.browser.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//sockets//socket.connections.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//sockets//socket.driver.ts", pathOrigem, pathDestino, recurso);

		// Storage
		this.copiaArquivo("//storage//cookie.browser.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//storage//storage.browser.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("//storage//storage.swaps.ts", pathOrigem, pathDestino, recurso);

	}

	private void copiaArquivo(String arquivo, String pathOrigem, String pathDestino, Recursos recurso)
			throws IOException {
		this.copiaArquivo(pathOrigem + arquivo, pathDestino + arquivo);
	}

	/*
	private void componenteListaSimples(Recursos recurso) throws IOException {
		String caminhoComponente = this.getDiretorioAngular(recurso) + recurso.getClasse().getNomeParaClasse()
				+ "-Lista//";
		if (!existe(caminhoComponente)) {
			this.criaCaminho(caminhoComponente);
		}
	}
	*/

	@Override
	protected ClasseWrapper criaWrapper(Entidade entidade) {
		return new ClasseWrapperAngular(entidade);
	}

	

}
