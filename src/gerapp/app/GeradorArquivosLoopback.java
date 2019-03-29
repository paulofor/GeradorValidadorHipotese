package gerapp.app;

import gerapp.modelo.Aplicacao;
import gerapp.modelo.Entidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.node.TelaAppWrapper;
import jet.wrappers.base.node.TelaWebWrapper;
import loopback.android.callback.ListCallback;
import loopback.android.callback.ObjectCallback;
import loopback.cliente.modelo.AtributoEntidadeRest;
import loopback.cliente.modelo.EntidadeRest;
import loopback.cliente.modelo.PaletaCorRest;
import loopback.cliente.modelo.RelacionamentoEntidadeRest;
import loopback.cliente.modelo.TelaAppRest;
import loopback.cliente.modelo.TelaWebRest;
import loopback.cliente.repositorio.AtributoEntidadeRepositorio;
import loopback.cliente.repositorio.EntidadeRepositorio;
import loopback.cliente.repositorio.PaletaCorRepositorio;
import loopback.cliente.repositorio.RelacionamentoEntidadeRepositorio;
import loopback.cliente.repositorio.TelaAppRepositorio;
import loopback.cliente.repositorio.TelaWebRepositorio;
import loopback.remoting.adapters.RestAdapter;
import br.com.digicom.lib.dao.DaoException;

public abstract class GeradorArquivosLoopback extends GeradorArquivosBase {

	private List listaEntidade = null;
	private List listaAtributo = null;
	private List listaRelacionamento = null;

	// Listas novas com objetos rest
	protected List<TelaWebRest> listaTelaWeb = null;
	protected List<TelaAppWrapper> listaTelaApp = null;
	
	protected PaletaCorRest paletaCor = null;

	
	RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
	
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
		throw new RuntimeException("Metodo precisa ser implementado");
	}

	@Override
	public void limpaArquivos(Recursos recurso) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void montaListasNovas(Recursos recursos) {
		recursos.setListaTelaWeb(getListaTelaWeb());
		recursos.setListaTelaApp(this.getListaTelaApp());
		recursos.setPaletaCor(this.obtemPaletaCor());
		for (Object entidade : listaEntidade) {
			carregaTelaParaEntidade((Entidade)entidade);
		}
		
	}
	
	private void carregaTelaParaEntidade(Entidade entidade) {
		
	}
	
	
	public synchronized PaletaCorRest obtemPaletaCor()  {
		paletaCor = null;
		
		PaletaCorRepositorio rep = adapter.createRepository(PaletaCorRepositorio.class);
		rep.findByIdAplicacao(aplicacao.getId(), new ObjectCallback<PaletaCorRest>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(PaletaCorRest item) {
				paletaCor = item;
			}
		});
		do {
		} while (paletaCor == null);
		return paletaCor;
	}
	

	public synchronized List getListaEntidade() throws DaoException {
		listaEntidade = null;
		//RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
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
		listaTelaWeb = null;
		//RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		TelaWebRepositorio rep = adapter.createRepository(TelaWebRepositorio.class);
		System.out.println("Chamada TelaWeb...");
		rep.findByIdAplicacaoGerador(aplicacao.getId(), new ListCallback<TelaWebRest>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				System.exit(1);
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
			//System.out.println("aguardando tela web...");
		} while (listaTelaWeb == null);
		return listaTelaWeb;
	}

	
	private void mostraTelaApp() {
		for (TelaAppWrapper app : this.listaTelaApp) {
			
		}
	}
	
	
	public synchronized List getListaTelaApp() {
		listaTelaApp = null;
		//RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		TelaAppRepositorio rep = adapter.createRepository(TelaAppRepositorio.class);
		System.out.println("Chamada TelaApp...");
		rep.findByIdAplicacaoGerador(aplicacao.getId(), new ListCallback<TelaAppRest>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onSuccess(List<TelaAppRest> lista) {
				System.out.println("Resposta TelaApp");
				List listaSaida = new ArrayList();
				for (TelaAppRest item : lista) {
					
					listaSaida.add(new TelaAppWrapper(item));
				}
				listaTelaApp = listaSaida;
			}
		});
		do {
			System.out.println("aguardando tela app...");
		} while (listaTelaApp == null);
		return listaTelaApp;
	}

	public synchronized List getListaAtributos(long idEntidade) throws DaoException {
		listaAtributo = null;
		//RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
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
			System.out.println("aguardando atributo");
		} while (listaAtributo == null);
		return listaAtributo;
	}

	public synchronized List getListaRelacionamento(long idEntidade) throws DaoException {
		listaRelacionamento = null;
		//RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
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
			System.out.println("aguardando relacionamento");
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

	protected void copiaArquivo(String arquivo, String pathOrigem, String pathDestino, Recursos recurso)
			throws IOException {
		this.copiaArquivo(pathOrigem + arquivo, pathDestino + arquivo);
	}
}
