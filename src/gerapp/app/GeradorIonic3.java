package gerapp.app;

import gerapp.modelo.Entidade;
import gerapp.modelo.node.ItemAngular;
import gerapp.modelo.node.ItemComponente;
import gerapp.modelo.node.ModuloComponente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import jet.ionic3.page.PageModuleTs;
import jet.ionic3.page.PageScss;
import jet.ionic3.page.detalhe.DetalhePageHtml;
import jet.ionic3.page.detalhe.DetalhePageTs;
import jet.ionic3.page.lista.ListaPageHtml;
import jet.ionic3.page.lista.ListaPageTs;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaAppWrapper;

public class GeradorIonic3 extends GeradorArquivosLoopback{

	
	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;
	
	

	private String getDiretorioAngular(Recursos recurso) {
		return PATH + recurso.getConfiguracao().getNamespace() + "/ionic3_ger/src/";
	}
	
	private void criaProjeto(Recursos recurso) {
		String pathApp = PATH + recurso.getConfiguracao().getNamespace() + "/ionic3_ger";
		try {
			Process processo = Runtime.getRuntime().exec("cd " + pathApp);
			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(processo.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
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
	}
	
	private void criaTelaApp(Recursos recurso, TelaAppWrapper tela) throws IOException {
		
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
			conteudo = ListaPageTs.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo)) {
				conteudo = ListaPageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
		if (tela.tipoDetalhe()) {
			nomeArquivo = pathDestino + tela.getArquivo() + ".ts";
			conteudo = DetalhePageTs.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
			
			nomeArquivo = pathDestino + tela.getArquivo() + ".html";
			if (!this.existe(nomeArquivo)) {
				conteudo = DetalhePageHtml.create("\n").generate(recurso);
				geraArquivoFonte(conteudo, nomeArquivo);
			}
		}
	}


	@Override
	protected ClasseWrapper criaWrapper(Entidade entidade) {
		return new ClasseWrapperAngular(entidade);
	}
	
	
	private void carregaEntidade(TelaAppWrapper tela, Recursos recursos) {
		if (tela.getIdEntidade()!=0) {
			ClasseWrapper entidade = obtemEntidadePorId(tela.getIdEntidade(),recursos);
			tela.setClasseWrapper(entidade);
		}
	}
	
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
