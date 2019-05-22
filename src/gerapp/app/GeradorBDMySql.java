package gerapp.app;

import java.io.IOException;

import jet.server.database.MySqlCreate;

public class GeradorBDMySql extends GeradorNodeBase{

	private String PATH = "../../../../ProdutoServer/scripts/";
	
	@Override
	protected void criaArquivoProjeto(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub
		String pathDestino = PATH + recurso.getConfiguracao().getNamespace() + "/";
		this.criaCaminhoSeNaoExiste(pathDestino);
		
		String nomeArquivo = pathDestino + "cria-tabelas.sql";
		String conteudo = MySqlCreate.create("\n").generate(recurso);
		geraArquivoFonte(conteudo, nomeArquivo);
		
		System.out.println("Arquivo: " + nomeArquivo);
	}

}
