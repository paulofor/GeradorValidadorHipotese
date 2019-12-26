package gerapp.app;

import gerapp.modelo.Aplicacao;
import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.Entidade;
import gerapp.modelo.FiltroColecao;
import gerapp.modelo.ProcValor;
import gerapp.modelo.RegraColecao;
import gerapp.modelo.RelacionamentoEntidade;
import gerapp.regracolecao.AplicacaoRegraColecao;
import gerapp.regracolecao.AtributoEntidadeRegraColecao;
import gerapp.regracolecao.EntidadeRegraColecao;
import gerapp.regracolecao.FabricaRegra;
import gerapp.regracolecao.FiltroColecaoRegraColecao;
import gerapp.regracolecao.ProcValorRegraColecao;
import gerapp.regracolecao.RegraColecaoRegraColecao;
import gerapp.regracolecao.RelacionamentoEntidadeRegraColecao;
import gerapp.regracolecao.filtro.AtributoEntidadeFiltro;
import gerapp.regracolecao.filtro.EntidadeFiltro;
import gerapp.regracolecao.filtro.FiltroColecaoFiltro;
import gerapp.regracolecao.filtro.ProcValorFiltro;
import gerapp.regracolecao.filtro.RegraColecaoFiltro;
import gerapp.regracolecao.filtro.RelacionamentoEntidadeFiltro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosBase {

	protected AplicacaoWrapper aplicacao = null;
	protected List<ClasseWrapper> listaClasse = null;

	public void setAplicacao(Aplicacao aplicacao) throws DaoException {

		AplicacaoRegraColecao aplicacaoRC = FabricaRegra.getInstancia().getAplicacaoRegraColecao();
		aplicacao = aplicacaoRC.obtemPorChave(aplicacao.getIdAplicacao());
		this.aplicacao = new AplicacaoWrapper(aplicacao);
	}

	protected void geraArquivoFonte(String texto, String nomeArquivo) throws IOException {
		FileOutputStream fos = new FileOutputStream(nomeArquivo);
		Writer w = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
		Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
		Charset UTF_8 = Charset.forName("UTF-8");

		byte[] ptext = texto.getBytes(ISO_8859_1);
		String value = new String(ptext, UTF_8);
		w.write(value);
		w.flush();
		w.close();
	}

	protected void copiaArquivo(String origem, String destino) throws IOException {
		String texto = leArquivoTexto(origem);
		geraArquivoFonte(texto, destino);
	}
	
	protected void copiaArquivoBinario(String origem, String destino) throws IOException {
		FileInputStream fin = new FileInputStream(origem);
		FileOutputStream fout = new FileOutputStream(destino);
		byte[] b = new byte[1024];
		int noOfBytes = 0;
		while( (noOfBytes = fin.read(b)) != -1 )
		{
			fout.write(b, 0, noOfBytes);
		}
		fin.close();
		fout.close();	
	}

	protected void copiaArquivoSeNaoExiste(String origem, String destino) throws IOException {
		if (!this.existe(destino)) copiaArquivo(origem,destino);
	}
	
	
	public String leArquivoTexto(String fileName) throws IOException {
		String returnValue = "";
		FileReader file;
		String line = "";
		file = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(file);
		try {
			while ((line = reader.readLine()) != null) {
				returnValue += line + "\n";
			}
		} finally {
			reader.close();
		}
		return returnValue;
	}

	protected void limpaCaminho(String caminhoArquivo) throws IOException {
		File caminho = new File(caminhoArquivo);
		if (caminho.isDirectory()) {
			for (File arquivo : caminho.listFiles()) {
				if (arquivo.isFile())
					arquivo.delete();
			}
		}
	}

	protected boolean criaCaminhoSeNaoExiste(String caminho) throws IOException {
		boolean existe = existe(caminho);
		if (!existe) {
			criaCaminho(caminho);
		}
		return existe;
	}

	protected void criaCaminho(String caminhoArquivo) throws IOException {
		File caminho = new File(caminhoArquivo);
		caminho.mkdirs();
	}

	protected boolean existe(String nomeCompleto) throws IOException {
		File arquivo = new File(nomeCompleto);
		return arquivo.exists();
	}

	protected abstract ClasseWrapper criaWrapper(Entidade entidade);

	protected Configuracao criaConfiguracao() {
		Configuracao confW = new Configuracao(aplicacao);
		return confW;
	}

	private void montaListaClasse(Recursos recurso) throws DaoException {
		System.out.println("Inicio Monta Lista Classe");
		listaClasse = new ArrayList<ClasseWrapper>();
		List lista = getListaEntidade();
		Iterator iterador = lista.iterator();
		while (iterador.hasNext()) {
			Entidade entidade = (Entidade) iterador.next();
			System.out.println("Vai tratar " + entidade.getNome());
			ClasseWrapper corrente = criaWrapper(entidade);
			corrente.setRecursos(recurso);
			List<AtributoEntidade> listaAtributos = getListaAtributos(corrente.getId());

			AtributoEntidade attChave = this.getAtributo(corrente.getIdChave(), listaAtributos);
			corrente.setChave(attChave);
			AtributoEntidade attIdent = this.getAtributo(corrente.getIdIdentificador(), listaAtributos);
			corrente.setIdentificador(attIdent);
			Iterator<AtributoEntidade> itAtributoEntidade = listaAtributos.iterator();
			while (itAtributoEntidade.hasNext()) {
				AtributoEntidade atributo = itAtributoEntidade.next();
				if (attChave != null && attChave.getIdAtributoEntidade() == atributo.getIdAtributoEntidade()) {
					atributo.setChave(true);
				} else {
					atributo.setChave(false);
				}
				if (attIdent != null && attIdent.getIdAtributoEntidade() == atributo.getIdAtributoEntidade()) {
					atributo.setIdentificador(true);
				} else {
					atributo.setIdentificador(false);
				}
			}
			List<RelacionamentoEntidade> listaRelacionamento = getListaRelacionamento(corrente.getId());
			List<FiltroColecao> listaFiltro = getListaFiltro(corrente.getId());
			List<RegraColecao> listaRegra = getListaRegra(corrente.getId());
			List<ProcValor> listaProcValor = getListaProcValor(corrente.getId());
			corrente.setListaAtributoEntidade(listaAtributos);
			corrente.setListaRelacionamento(listaRelacionamento);
			corrente.setListaFiltroColecao(listaFiltro);
			corrente.setListaRegraColecao(listaRegra);
			corrente.setListaProcValor(listaProcValor);
			System.out.println("Tratou " + corrente.getNomeParaClasse());
			listaClasse.add(corrente);
		}
		
		System.out.println("Final Monta Lista Classe");
	}

	protected abstract void montaListasNovas(Recursos recurso);

	protected void verificaDiretorios(Recursos recurso) throws IOException {

	}

	public void criaArquivos() {
		// TODO Auto-generated method stub
		try {
			Recursos recurso = new Recursos();
			recurso.setConfiguracao(criaConfiguracao());
			montaListaClasse(recurso);
			AplicacaoWrapper.setEntidades(listaClasse);
			
			recurso.setListaClasse(listaClasse);
			montaListasNovas(recurso);
			verificaDiretorios(recurso);
			limpaArquivos(recurso);
			criaArquivoProjeto(recurso);
			criaArquivoUnico(recurso);
			Iterator<ClasseWrapper> iterador = listaClasse.iterator();
			while (iterador.hasNext()) {
				ClasseWrapper corrente = iterador.next();
				recurso.setClasse(corrente);
				System.out.println("Classe: " + corrente.getNomeParaClasse());
				criaArquivoEntidade(recurso);
			}
			System.out.println("Geracao de arquivos concluida.");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract void criaArquivoProjeto(Recursos recurso) throws IOException;
	
	
	public abstract void limpaArquivos(Recursos recurso) throws IOException;

	public abstract void criaArquivoUnico(Recursos recurso) throws IOException;

	public abstract void criaArquivoEntidade(Recursos recurso) throws IOException;

	public List getListaAtributos(long codigoEntidade) throws DaoException {
		AtributoEntidadeRegraColecao atributoRC = FabricaRegra.getInstancia().getAtributoEntidadeRegraColecao();
		List listaSaida = null;
		AtributoEntidadeFiltro filtro = atributoRC.getFiltro();
		filtro.setCodigoEntidade(codigoEntidade);
		listaSaida = atributoRC.ListaCorrente();
		return listaSaida;
	}

	public List getListaRelacionamento(long codigo) throws DaoException {
		RelacionamentoEntidadeRegraColecao relacRC = FabricaRegra.getInstancia()
				.getRelacionamentoEntidadeRegraColecao();
		List listaSaida = null;
		RelacionamentoEntidadeFiltro filtro = relacRC.getFiltro();
		filtro.setCodigoEntidade1(codigo);
		listaSaida = relacRC.ListaCorrente();
		filtro.setCodigoEntidade1(0);
		filtro.setCodigoEntidade2(codigo);
		listaSaida.addAll(relacRC.ListaCorrente());
		return listaSaida;
	}

	public AtributoEntidade getAtributo(long codigo) throws DaoException {
		if (codigo == 0)
			return null;
		AtributoEntidadeRegraColecao atributoRC = FabricaRegra.getInstancia().getAtributoEntidadeRegraColecao();
		AtributoEntidade saida = atributoRC.obtemPorChave(codigo);
		return saida;

	}

	public AtributoEntidade getAtributo(long codigo, List<AtributoEntidade> listaAtributo) {
		AtributoEntidade saida = null;
		for (AtributoEntidade item : listaAtributo) {
			if (item.getIdAtributoEntidade() == codigo) {
				saida = item;
				break;
			}
		}
		return saida;
	}

	public List getListaEntidade() throws DaoException {
		EntidadeRegraColecao entidadeRC = FabricaRegra.getInstancia().getEntidadeRegraColecao();
		List listaSaida = null;
		EntidadeFiltro filtro = entidadeRC.getFiltro();
		filtro.setCodigoAplicacao(aplicacao.getId());
		listaSaida = entidadeRC.ListaCorrente();
		return listaSaida;
	}

	public List getListaFiltro(long codigoEntidade) throws DaoException {
		FiltroColecaoRegraColecao filtroRC = FabricaRegra.getInstancia().getFiltroColecaoRegraColecao();
		List listaSaida = null;
		FiltroColecaoFiltro filtro = filtroRC.getFiltro();
		filtro.setCodigoEntidade(codigoEntidade);
		listaSaida = filtroRC.ListaCorrente();
		return listaSaida;
	}

	public List getListaRegra(long codigoEntidade) throws DaoException {
		RegraColecaoRegraColecao regraRC = FabricaRegra.getInstancia().getRegraColecaoRegraColecao();
		List listaSaida = null;
		RegraColecaoFiltro filtro = regraRC.getFiltro();
		filtro.setCodigoEntidade(codigoEntidade);
		listaSaida = regraRC.ListaCorrente();
		return listaSaida;
	}

	public List getListaProcValor(long codigoEntidade) throws DaoException {
		ProcValorRegraColecao valorRC = FabricaRegra.getInstancia().getProcValorRegraColecao();
		List listaSaida = null;
		ProcValorFiltro filtro = valorRC.getFiltro();
		filtro.setCodigoEntidadeRelacionada(codigoEntidade);
		listaSaida = valorRC.ListaCorrente();
		return listaSaida;
	}
}
