package gerapp.app;

import gerapp.modelo.node.ItemAngular;
import gerapp.modelo.node.ItemComponente;
import gerapp.modelo.node.ModuloComponente;

import java.io.IOException;
import java.util.List;

import jet.angular.loopback.IndexModel;
import jet.angular.loopback.IndexPrincipal;
import jet.angular.loopback.IndexService;
import jet.angular.loopback.LoopbackModel;
import jet.angular.loopback.LoopbackService;
import jet.angular.loopback.SDKModel;
import jet.angular.modulo.ModuloSpec;
import jet.angular.projeto.ItemDados;
import jet.angular.projeto.ModuloServicoTs;
import jet.ionic3.app.AppComponentTs;
import jet.ionic3.app.AppModuleTs;
import jet.ionic3.app.AppScss;
import jet.ionic3.app.ThemeVariables;
import jet.ionic3.page.PageModuleTs;
import jet.ionic3.page.PageScss;
import jet.ionic3.page.detalhe.DetalhePageHtml;
import jet.ionic3.page.detalhe.DetalhePageTs;
import jet.ionic3.page.form.FormPageHtml;
import jet.ionic3.page.form.FormPageTs;
import jet.ionic3.page.lista.ListaPageHtml;
import jet.ionic3.page.lista.ListaPageTs;
import jet.ionic3.page.listaGrid.ListaGridPageHtml;
import jet.ionic3.page.listaGrid.ListaGridPageTs;
import jet.ionic3.page.listaItem.ListaItemPageHtml;
import jet.ionic3.page.listaItem.ListaItemPageProtBaseTs;
import jet.ionic3.page.listaItem.ListaItemPageTs;
import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaAppWrapper;

public class GeradorIonic3 extends GeradorNodeBase {

	
	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;
	
	

	private String getDiretorioAngular(Recursos recurso) {
		return PATH + recurso.getConfiguracao().getNamespace() + "/ionic3_ger/src/";
	}
	
	
	
	
	protected void criaArquivoProjeto(Recursos recurso) throws IOException {
		String raizDestino = PATH + recurso.getConfiguracao().getNamespace() + "/ionic3_ger/";
		String raizOrigem =  "./fixos/fixoIonic3/";
		
		String pathDestino = raizDestino;
		String pathOrigem = raizOrigem;
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("ionic.config.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("package.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("package-lock.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("tsconfig.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("tslint.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("tslint.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivo(".gitignore", pathOrigem, pathDestino, recurso);
		
		
		
		pathDestino = raizDestino + "src/";
		pathOrigem = raizOrigem + "src/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("index.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("manifest.json", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("service-worker.js", pathOrigem, pathDestino, recurso);
		
		pathDestino = raizDestino + "src/app/";
		pathOrigem = raizOrigem + "src/app/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		//this.copiaArquivo("app.component.ts", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("app.html", pathOrigem, pathDestino, recurso);
		//this.copiaArquivo("app.module.ts", pathOrigem, pathDestino, recurso);
		//this.copiaArquivo("app.scss", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("main.ts", pathOrigem, pathDestino, recurso);
		
		pathDestino = raizDestino + "src/assets/icon/";
		pathOrigem = raizOrigem + "src/assets/icon/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("favicon.ico", pathOrigem, pathDestino, recurso);
		
		pathDestino = raizDestino + "src/assets/imgs/";
		pathOrigem = raizOrigem + "src/assets/imgs/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("logo.png", pathOrigem, pathDestino, recurso);
		
		pathDestino = raizDestino + "src/pages/home/";
		pathOrigem = raizOrigem + "src/pages/home/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("home.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("home.scss", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("home.ts", pathOrigem, pathDestino, recurso);
		
		pathDestino = raizDestino + "src/pages/list/";
		pathOrigem = raizOrigem + "src/pages/list/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("list.html", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("list.scss", pathOrigem, pathDestino, recurso);
		this.copiaArquivo("list.ts", pathOrigem, pathDestino, recurso);
		
		pathDestino = raizDestino + "src/theme/";
		pathOrigem = raizOrigem + "src/theme/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		
		
		pathDestino = raizDestino + "src/shared/sdk/services/integracao/";
		pathOrigem = "./fixos/angular/integracao/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.copiaArquivo("list.html", pathOrigem, pathDestino, recurso);


	}
	
	
	
	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		List<ItemComponente> listaTela = recurso.getListaTelaApp();
		for (ItemComponente tela : listaTela) {
			carregaEntidade((TelaAppWrapper) tela,recurso);
			recurso.setItemCorrente(tela);
			criaTelaApp(recurso, (TelaAppWrapper) tela);
		}
		this.arquivosLoopbackClient(recurso);
		this.criaModuloServico(recurso);
		this.criaDadosPrototipo(recurso);
		this.criaArquivoAplicacao(recurso);
	}
	
	private void criaArquivoAplicacao(Recursos recurso) throws IOException {
		
		String nomeArquivo = getDiretorioAngular(recurso) + "/app/app.component.ts";
		String conteudo = AppComponentTs.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		nomeArquivo = getDiretorioAngular(recurso) + "/app/app.module.ts";
		conteudo = AppModuleTs.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
		nomeArquivo = getDiretorioAngular(recurso) + "/app/app.scss";
		conteudo = AppScss.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
		nomeArquivo = getDiretorioAngular(recurso) + "/theme/variables.scss";
		conteudo = ThemeVariables.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

	}
	
	
	private void criaTelaApp(Recursos recurso, TelaAppWrapper tela) throws IOException {
		
		System.out.println("Tela: " + tela.getNome());
		System.out.println("Item Tela: " + tela);
		
		if (!tela.possuiEntidade()) return;
		
		String pathDestino = getDiretorioAngular(recurso) + "/pages/" + tela.getPathArquivo() + "/" ;
		this.criaCaminhoSeNaoExiste(pathDestino);
		//this.limpaCaminho(pathDestino);
		
		String nomeArquivo = pathDestino + tela.getArquivo() + ".module.ts";
		String conteudo = PageModuleTs.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
		nomeArquivo = pathDestino + tela.getArquivo() + ".scss";
		if (!this.existe(nomeArquivo)) {
			conteudo = PageScss.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
		}
		
		if (tela.tipoLista()) {
			nomeArquivo = pathDestino + tela.getArquivo() + ".ts";
			if (!this.existe(nomeArquivo) || tela.sobrescreveTs()) {
				conteudo = ListaPageTs.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo) || tela.sobrescreveHtml()) {
				conteudo = ListaPageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
		if (tela.tipoDetalhe()) {
			nomeArquivo = pathDestino + tela.getArquivo() + ".ts";
			if (!this.existe(nomeArquivo) || tela.sobrescreveTs()) {
				conteudo = DetalhePageTs.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo) || tela.sobrescreveHtml()) {
				conteudo = DetalhePageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
		if (tela.tipoEdita()) {
			nomeArquivo = pathDestino + tela.getArquivo() + ".ts";
			if (!this.existe(nomeArquivo) || tela.sobrescreveTs()) {
				conteudo = FormPageTs.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo) || tela.sobrescreveHtml()) {
				conteudo = FormPageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
		
		if (tela.tipoListaGrid()) {
			nomeArquivo = pathDestino + tela.getArquivo() + ".ts";
			if (!this.existe(nomeArquivo) || tela.sobrescreveTs()) {
				conteudo = ListaGridPageTs.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo) || tela.sobrescreveHtml()) {
				conteudo = ListaGridPageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
		if (tela.tipoListaItem()) {
			nomeArquivo = pathDestino + tela.getArquivo() + "-base.ts";
			conteudo = ListaItemPageProtBaseTs.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".ts";
			if (!this.existe(nomeArquivo) || tela.sobrescreveTs()) {
				conteudo = ListaItemPageTs.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo) || tela.sobrescreveHtml()) {
				conteudo = ListaItemPageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
		if (tela.tipoListaVitrine()) {
			nomeArquivo = pathDestino + tela.getArquivo() + ".ts";
			
			if (!this.existe(nomeArquivo) || tela.sobrescreveTs()) {
				conteudo = DetalhePageTs.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo) || tela.sobrescreveHtml()) {
				conteudo = DetalhePageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
	}


	
	
	/*
	 * passou para classe superior
	 * 
	private void carregaEntidade(TelaAppWrapper tela, Recursos recursos) {
		if (tela.getIdEntidade()!=0) {
			ClasseWrapper entidade = obtemEntidadePorId(tela.getIdEntidade(),recursos);
			tela.setClasseWrapper(entidade);
		}
	}
	*/
	
	private ClasseWrapper obtemEntidadePorId(long id, Recursos recurso) {
		ClasseWrapper saida = null;
		List<ClasseWrapper> listaClasse = recurso.getListaClasse();
		for (ClasseWrapper classe : listaClasse) {
			if (classe.getId() == id) {
				saida = classe;
			}
		}
		return saida;
	}
	
	
	
	//***   Esse pedaço todo pode ser passado para uma classe geral 
	
	private void arquivosLoopbackClient(Recursos recurso) throws IOException {
		String pathDestino = getDiretorioAngular(recurso) + "/shared/sdk/";
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
		this.limpaCaminho(pathDestino + "//models//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//core//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//custom//");
		this.limpaCaminho(pathDestino + "//services//custom//");
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

	
	private void criaModuloServico(Recursos recurso) throws IOException {
		String pathDestino = getDiretorioAngular(recurso) + "/servico/"; 
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.limpaCaminho(pathDestino);
		
		String nomeArquivo = pathDestino + "servico.module.ts";
		String conteudo = ModuloServicoTs.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
		ModuloComponente modulo = new ModuloComponente("ServicoModule", "servico.module");
		recurso.setItemCorrente(modulo);
		nomeArquivo = pathDestino + modulo.getArquivo() + ".spec.ts";
		conteudo = ModuloSpec.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
	}
	
	
	private void criaDadosPrototipo(Recursos recurso) throws IOException {
		String pathDestino = getDiretorioAngular(recurso) + "/dados/"; 
		this.criaCaminhoSeNaoExiste(pathDestino);
		//this.limpaCaminho(pathDestino);
		for (ClasseWrapper corrente : listaClasse) {
			recurso.setItemCorrente((ItemAngular)corrente);
			// Modelo
			String nomeArquivo = pathDestino + corrente.getNomeParaVariavel() + ".ts";
			if (!this.existe(nomeArquivo)) {
				String conteudo = ItemDados.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
	}
}
