package gerapp.app;

import gerapp.modelo.node.ItemComponente;
import gerapp.modelo.node.ItemLoopbackServer;

import java.io.IOException;
import java.util.List;

import jet.server.app.ModelConfigJson;
import jet.server.model.ModelJs;
import jet.server.model.ModelJson;
import jet.wrappers.base.node.TelaAppWrapper;

public class GeradorLoopbackServer extends GeradorNodeBase {

	private String PATH = "../../../../ProdutoServer/";

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		System.out.println("...criaArquivoEntidade");
		String pathDestino = PATH + "//common//models//";

		this.criaCaminhoSeNaoExiste(pathDestino);

		ItemLoopbackServer classe = (ItemLoopbackServer) recurso.getClasse();
		String nomeArquivo = pathDestino + classe.getNomeParaArquivoServer() + ".json";
		String conteudo = ModelJson.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);

		nomeArquivo = pathDestino + classe.getNomeParaArquivoServer() + ".js";
		if (!this.existe(nomeArquivo)) {
			conteudo = ModelJs.create("\n").generate(recurso);
			geraArquivoFonte(conteudo, nomeArquivo);
		}

	}

	@Override
	protected void criaArquivoProjeto(Recursos recurso) throws IOException {
		System.out.println("...criaArquivoProjeto");
	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		List<ItemComponente> listaTela = recurso.getListaTelaApp();
		for (ItemComponente tela : listaTela) {
			carregaEntidade((TelaAppWrapper) tela, recurso);
			recurso.setItemCorrente(tela);

		}
		try {
			System.out.println("wait..");
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("...criaArquivoUnico");
		String pathDestino = PATH + "//server//"
				+ recurso.getConfiguracao().getNamespace() + "/";
		this.criaCaminhoSeNaoExiste(pathDestino);

		String nomeArquivo = pathDestino + "model-config.json";
		String conteudo = ModelConfigJson.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
	}

	@Override
	public void limpaArquivos(Recursos recurso) throws IOException {
		System.out.println("...limpaArquivos");
	}

}
