package gerapp.app;

import gerapp.modelo.Entidade;

import java.io.IOException;

import jet.angular.ComponenteTsLista;
import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;

public class GeradorAngular extends GeradorArquivosBase {
	
	private String PATH = "../../../../ProdutosNode/";
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		String nomeArquivo = PATH + recurso.getConfiguracao().getNamespace() + 
				"//src//app//" + recurso.getClasse().getNomeParaClasse()  + "-Lista//" + 
				recurso.getClasse().getNomeParaClasse().toLowerCase() + "-lista.component.ts";
		String conteudo = ComponenteTsLista.create("\n").generate(recurso);
		geraArquivoFonte(conteudo,nomeArquivo);
	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		String nomeArquivo = recurso.getConfiguracao().getPathAndroid() + "//servico//FabricaServico.java";
		//String conteudo = FabricaServico.create("\n").generate(recurso);
		//geraArquivoFonte(conteudo,nomeArquivo);
		
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
