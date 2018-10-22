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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosBase {

	protected AplicacaoWrapper aplicacao = null;
	protected List<ClasseWrapper> listaClasse = null;
	
	public void setAplicacao(Aplicacao aplicacao)  throws DaoException{

		AplicacaoRegraColecao aplicacaoRC = FabricaRegra.getInstancia().getAplicacaoRegraColecao();
		aplicacao = aplicacaoRC.obtemPorChave(aplicacao.getIdAplicacao());
		this.aplicacao = new AplicacaoWrapper(aplicacao);
	}
	
	protected void geraArquivoFonte(String texto, String nomeArquivo) throws IOException {
		FileWriter x = new FileWriter(nomeArquivo); 
		x.write(texto); 
		x.close(); 
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
	
	protected void criaCaminho(String caminhoArquivo) throws IOException {
		File caminho = new File(caminhoArquivo);
		caminho.mkdirs();
	}
	
	protected boolean existe(String nomeCompleto) throws IOException {
		//String nomeCompleto = caminhoArquivo + File.separator + nomeArquivo;
		File arquivo = new File(nomeCompleto);
		return arquivo.exists();
	}
	
	protected abstract ClasseWrapper criaWrapper(Entidade entidade);
	protected Configuracao criaConfiguracao() {
		Configuracao confW = new Configuracao(aplicacao);
		return confW;
	}
	
	private void montaListaClasse() throws DaoException{
		listaClasse = new ArrayList<ClasseWrapper>();
		List lista = getListaEntidade();
		Iterator iterador = lista.iterator();
		while (iterador.hasNext()) {
			Entidade entidade = (Entidade) iterador.next();
			ClasseWrapper corrente = criaWrapper(entidade);
			List<AtributoEntidade> listaAtributos = getListaAtributos(corrente.getId());
			
			AtributoEntidade attChave = this.getAtributo(corrente.getIdChave());
			corrente.setChave(attChave);
			AtributoEntidade attIdent = this.getAtributo(corrente.getIdIdentificador());
			corrente.setIdentificador(attIdent);
			Iterator<AtributoEntidade> itAtributoEntidade = listaAtributos.iterator();
			while (itAtributoEntidade.hasNext()) {
				AtributoEntidade atributo = itAtributoEntidade.next();
				if (attChave!=null && attChave.getIdAtributoEntidade()==atributo.getIdAtributoEntidade()) {
					atributo.setChave(true);
				} else {
					atributo.setChave(false);
				}
				if (attIdent!=null && attIdent.getIdAtributoEntidade()==atributo.getIdAtributoEntidade()) {
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
			listaClasse.add(corrente);
		}
	}
	
	
	
	
	public void criaArquivos() {
		// TODO Auto-generated method stub
		try {
			
			montaListaClasse();
			AplicacaoWrapper.setEntidades(listaClasse);
			Recursos recurso = new Recursos();
			recurso.setConfiguracao(criaConfiguracao());
			recurso.setListaClasse(listaClasse);
			limpaArquivos(recurso);
			criaArquivoUnico(recurso);
			Iterator<ClasseWrapper> iterador = listaClasse.iterator();
			while (iterador.hasNext()) {
				ClasseWrapper corrente = iterador.next();
				recurso.setClasse(corrente);
				System.out.println("Classe: " + corrente.getNomeParaClasse());
				criaArquivoEntidade(recurso);
			}
			System.out.println("Geracao de arquivos concluida.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
		RelacionamentoEntidadeRegraColecao relacRC = FabricaRegra.getInstancia().getRelacionamentoEntidadeRegraColecao();
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
		if (codigo==0) return null;
		AtributoEntidadeRegraColecao atributoRC = FabricaRegra.getInstancia().getAtributoEntidadeRegraColecao();
		AtributoEntidade saida = atributoRC.obtemPorChave(codigo);
		return saida;
		
	}

	
	public List getListaEntidade() throws DaoException{
		EntidadeRegraColecao entidadeRC = FabricaRegra.getInstancia().getEntidadeRegraColecao();
		List listaSaida = null;
		EntidadeFiltro filtro = entidadeRC.getFiltro();
		filtro.setCodigoAplicacao(aplicacao.getId());
		listaSaida = entidadeRC.ListaCorrente();
		return listaSaida;
	}
	public List getListaFiltro(long codigoEntidade) throws DaoException{
		FiltroColecaoRegraColecao filtroRC = FabricaRegra.getInstancia().getFiltroColecaoRegraColecao();
		List listaSaida = null;
		FiltroColecaoFiltro filtro = filtroRC.getFiltro();
		filtro.setCodigoEntidade(codigoEntidade);
		listaSaida = filtroRC.ListaCorrente();
		return listaSaida;
	}
	
	public List getListaRegra(long codigoEntidade) throws DaoException{
		RegraColecaoRegraColecao regraRC = FabricaRegra.getInstancia().getRegraColecaoRegraColecao();
		List listaSaida = null;
		RegraColecaoFiltro filtro = regraRC.getFiltro();
		filtro.setCodigoEntidade(codigoEntidade);
		listaSaida = regraRC.ListaCorrente();
		return listaSaida;
	}
	
	public List getListaProcValor(long codigoEntidade) throws DaoException{
		ProcValorRegraColecao valorRC = FabricaRegra.getInstancia().getProcValorRegraColecao();
		List listaSaida = null;
		ProcValorFiltro filtro = valorRC.getFiltro();
		filtro.setCodigoEntidadeRelacionada(codigoEntidade);
		listaSaida = valorRC.ListaCorrente();
		return listaSaida;
	}
}
