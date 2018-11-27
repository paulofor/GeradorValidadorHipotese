package gerapp.app;

import gerapp.modelo.Aplicacao;
import gerapp.modelo.Entidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaWebWrapper;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.AtributoEntidadeRest;
import loopback.cliente.modelo.EntidadeRest;
import loopback.cliente.modelo.RelacionamentoEntidadeRest;
import loopback.cliente.modelo.TelaWebRest;
import loopback.cliente.repositorio.AtributoEntidadeRepositorio;
import loopback.cliente.repositorio.EntidadeRepositorio;
import loopback.cliente.repositorio.RelacionamentoEntidadeRepositorio;
import loopback.cliente.repositorio.TelaWebRepositorio;
import loopback.remoting.adapters.RestAdapter;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosLoopback extends GeradorArquivosBase {

	private List listaEntidade = null;
	private List listaAtributo = null;
	private List listaRelacionamento = null;

	// Listas novas com objetos rest
	protected List<TelaWebRest> listaTelaWeb = null;

	public void setAplicacao(Aplicacao aplicacao) throws DaoException {
		this.aplicacao = new AplicacaoWrapper(aplicacao);
	}

	@Override
	public void criaArquivoEntidade(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void criaArquivoUnico(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected ClasseWrapper criaWrapper(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limpaArquivos(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void montaListasNovas(Recursos recursos) {
		recursos.setListaTelaWeb(getListaTelaWeb());
	}

	public synchronized List getListaEntidade() throws DaoException {
		listaEntidade = null;
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		EntidadeRepositorio rep = adapter.createRepository(EntidadeRepositorio.class);
		rep.findByIdAplicacao(aplicacao.getId(), new ListCallback<EntidadeRest>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<EntidadeRest> lista) {
				List listaSaida = new ArrayList();
				for (EntidadeRest item : lista) {
					System.out.println("ID:" + item.getId());
					listaSaida.add(item.criaItem());
				}
				listaEntidade = listaSaida;
			}
		});
		do {
		} while (listaEntidade == null);
		return listaEntidade;
	}

	public synchronized List getListaTelaWeb() {
		listaEntidade = null;
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		TelaWebRepositorio rep = adapter.createRepository(TelaWebRepositorio.class);
		System.out.println("Chamada TelaWeb...");
		rep.findByIdAplicacao(aplicacao.getId(),new ListCallback<TelaWebRest>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<TelaWebRest> lista) {
				System.out.println("Resposta TelaWeb");
				List listaSaida = new ArrayList();
				for (TelaWebRest item : lista) {
					listaSaida.add(new TelaWebWrapper(item));
				}
				listaTelaWeb = listaSaida;
			}
		});
		do {
			System.out.print("-");
		} while (listaTelaWeb == null);
		return listaTelaWeb;
	}

	public synchronized List getListaAtributos(long idEntidade) throws DaoException {
		listaAtributo = null;
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		AtributoEntidadeRepositorio rep = adapter.createRepository(AtributoEntidadeRepositorio.class);
		System.out.println("Chamada Atributos");
		rep.findByIdEntidade(idEntidade, new ListCallback<AtributoEntidadeRest>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<AtributoEntidadeRest> lista) {
				System.out.println("Respostsa Atributos");
				List listaSaida = new ArrayList();
				for (AtributoEntidadeRest item : lista) {
					System.out.println("ID:" + item.getNome());
					listaSaida.add(item.criaItem());
				}
				listaAtributo = listaSaida;
			}
		});
		do {
			//System.out.println("");
		} while (listaAtributo == null);
		return listaAtributo;
	}

	public synchronized List getListaRelacionamento(long idEntidade) throws DaoException {
		listaRelacionamento = null;
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		RelacionamentoEntidadeRepositorio rep = adapter.createRepository(RelacionamentoEntidadeRepositorio.class);
		
		rep.findByIdEntidade(idEntidade, new ListCallback<RelacionamentoEntidadeRest>() {

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<RelacionamentoEntidadeRest> lista) {
				List listaSaida = new ArrayList();
				for (RelacionamentoEntidadeRest item : lista) {
					System.out.println("ID-Rel:" + item.getId_relacionamento_entidade());
					listaSaida.add(item.criaItem());
				}
				listaRelacionamento = listaSaida;
			}
		});
		do {
			//System.out.print("-");
		} while (listaRelacionamento == null);
		return listaRelacionamento;
	}

	public List getListaFiltro(long idEntidade) {
		return new ArrayList();
	}

	public List getListaRegra(long idEntidade) {
		return new ArrayList();
	}

	public List getListaProcValor(long idEntidade) {
		return new ArrayList();
	}
}
