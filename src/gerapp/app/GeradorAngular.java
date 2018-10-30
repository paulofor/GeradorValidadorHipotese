package gerapp.app;

import gerapp.modelo.Entidade;

import java.io.IOException;
import java.util.List;

import jet.angular.componente.ComponenteScssVazio;
import jet.angular.componente.lista.ComponenteHtmlLista;
import jet.angular.componente.lista.ComponenteSpecLista;
import jet.angular.componente.lista.ComponenteTsLista;
import jet.angular.loopback.IndexModel;
import jet.angular.loopback.IndexPrincipal;
import jet.angular.loopback.IndexService;
import jet.angular.loopback.LoopbackModel;
import jet.angular.loopback.LoopbackService;
import jet.angular.loopback.SDKModel;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;

public class GeradorAngular extends GeradorArquivosLoopback {

	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;

	
	
	private String getDiretorioAngular(Recursos recurso) {
		return PATH + recurso.getConfiguracao().getNamespace() + 
			"//front//src//app//";
	}

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		entidade = recurso.getClasse();
		componenteListaSimples(recurso);
	}
	
	/*
	Customizados:
	
	sdk/index.ts
	sdk/models/todos + index
	sdk/services/index
	sdk/core/
	 */
	
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
		//Path currentRelativePath = Paths.get("");
		//String s = currentRelativePath.toAbsolutePath().toString();
		//System.out.println("Current relative path is: " + s);
		String pathOrigem = ".//fixos//angular//loopback//sdk//";
		
		this.criaCaminhoSeNaoExiste(pathDestino);
		this.criaCaminhoSeNaoExiste(pathDestino + "//models//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//core//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//services//custom//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//sockets//");
		this.criaCaminhoSeNaoExiste(pathDestino + "//storage//");
		
		// Raiz
		this.copiaLoopbakCliente("lb.config.ts", pathOrigem, pathDestino, recurso);

		// Models
		this.copiaLoopbakCliente("//models//BaseModels.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//models//Container.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//models//FireLoop.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//models//FireLoopRef.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//models//User.ts", pathOrigem , pathDestino, recurso);
		
		// Services 
		this.copiaLoopbakCliente("//services//index.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//core//auth.service.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//core//base.service.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//core//error.service.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//core//index.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//core//io.service.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//core//real.time.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//custom//Container.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//custom//logger.service.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//custom//SDKModels.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//services//custom//User.ts", pathOrigem , pathDestino, recurso);


		
		// Sockets
		this.copiaLoopbakCliente("//sockets//socket.browser.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//sockets//socket.connections.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//sockets//socket.driver.ts", pathOrigem , pathDestino, recurso);
		
		// Storage 
		this.copiaLoopbakCliente("//storage//cookie.browser.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//storage//storage.browser.ts", pathOrigem , pathDestino, recurso);
		this.copiaLoopbakCliente("//storage//storage.swaps.ts", pathOrigem , pathDestino, recurso);
		
	}
	
	private void copiaLoopbakCliente(String arquivo, String pathOrigem, String pathDestino, Recursos recurso) throws IOException {
		this.copiaArquivo(pathOrigem + arquivo, pathDestino + arquivo);
	}


	
	
	
	private void componenteListaSimples(Recursos recurso) throws IOException {
		String caminhoComponente = this.getDiretorioAngular(recurso)  
			+ recurso.getClasse().getNomeParaClasse()
			+ "-Lista//";
		if (!existe(caminhoComponente)) {
			this.criaCaminho(caminhoComponente);
		}
		
		String nomeArquivo = caminhoComponente + 
			entidade.getNomeParaClasse().toLowerCase()
			+ "-lista.component.ts";
		String conteudo = ComponenteTsLista.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		
		nomeArquivo = caminhoComponente + entidade.getNomeParaClasse().toLowerCase()
			+ "-lista.component.html";
		conteudo = ComponenteHtmlLista.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		nomeArquivo = caminhoComponente + entidade.getNomeParaClasse().toLowerCase()
				+ "-lista.component.scss";
		conteudo = ComponenteScssVazio.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		nomeArquivo = caminhoComponente + entidade.getNomeParaClasse().toLowerCase()
				+ "-lista.component.spec.ts";
		conteudo = ComponenteSpecLista.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		this.arquivosLoopbackClient(recurso);
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
