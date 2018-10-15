package gerapp.app;

import gerapp.modelo.Entidade;

import java.io.IOException;

import jet.wrappers.angular.ClasseWrapperAngular;
import jet.wrappers.base.ClasseWrapper;

public class GeradorAngular extends GeradorArquivosBase {
	
	
	protected Configuracao configuracao = null;
	protected ClasseWrapper entidade = null;

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		String nomeArquivo = recurso.getConfiguracao().getPathServicoInterface() + "//" + recurso.getClasse().getNomeParaClasse()  + "Servico.java";
		//String conteudo = Servico.create("\n").generate(recurso);
		//geraArquivoFonte(conteudo,nomeArquivo);
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
