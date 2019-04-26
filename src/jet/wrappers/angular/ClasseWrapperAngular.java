package jet.wrappers.angular;

import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.Entidade;
import gerapp.modelo.ProcValor;
import gerapp.modelo.RelacionamentoEntidade;
import gerapp.modelo.node.ItemComponente;
import gerapp.modelo.node.ItemLoopbackServer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jet.wrappers.base.AtributoWrapper;
import jet.wrappers.base.ClasseWrapper;
import jet.wrappers.base.ProcValorWrapper;
import jet.wrappers.base.RelacionamentoWrapper;
import jet.wrappers.base.node.TelaAppWrapper;
import loopback.cliente.modelo.TelaAppRest;

public class ClasseWrapperAngular extends ClasseWrapper implements ItemComponente, ItemLoopbackServer {

	private List<TelaAppWrapper> listaTelaAppW;
	private List<TelaAppWrapper> listaTelaAppWPut;
	
	private String tipo;
	
	public List<TelaAppWrapper> getListaTelaPorTipo(String dado) {
		List<TelaAppWrapper> listaSaida = new ArrayList<TelaAppWrapper>();
		if (listaTelaAppW!=null) {
			for (TelaAppWrapper tela : listaTelaAppW) {
				if (tela.ehTipo(dado)) listaSaida.add(tela);
			}
		}
		return listaSaida;
	}
	public List<TelaAppWrapper> getListaTelaPutPorTipo(String dado) {
		List<TelaAppWrapper> listaSaida = new ArrayList<TelaAppWrapper>();
		if (listaTelaAppWPut!=null) {
			for (TelaAppWrapper tela : listaTelaAppWPut) {
				if (tela.ehTipo(dado)) listaSaida.add(tela);
			}
		}
		return listaSaida;
	}
	
	public ClasseWrapperAngular(Entidade ent) {
		super(ent);
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setListaTelaApp(List<TelaAppRest> lista) {
		this.listaTelaAppW = new ArrayList<TelaAppWrapper>();
		for (TelaAppRest tela : lista) {
			TelaAppWrapper telaW = new TelaAppWrapper(tela);
			telaW.setClasseWrapper(this);
			this.listaTelaAppW.add(telaW);
		}
	}
	public void setListaTelaAppPut(List<TelaAppRest> lista) {
		this.listaTelaAppWPut = new ArrayList<TelaAppWrapper>();
		for (TelaAppRest tela : lista) {
			TelaAppWrapper telaW = new TelaAppWrapper(tela);
			telaW.setClasseWrapperPut(this);
			this.listaTelaAppWPut.add(telaW);
		}
	}
	
	public List<TelaAppWrapper> getListaTelaApp() {
		return listaTelaAppW;
	}
	public List<TelaAppWrapper> getListaTelaAppPut() {
		return listaTelaAppWPut;
	}

	@Override
	protected RelacionamentoWrapper criaRelacionamentoWrapper(
			RelacionamentoEntidade relac) {
		return new RelacionamentoWrapperAngular(relac);
	}

	@Override
	protected AtributoWrapper criaAtributoWrapper(AtributoEntidade item) {
		return new AtributoWrapperAngular(item);
	}

	@Override
	protected ProcValorWrapper criaProcValorWrapper(ProcValor item) {
		return new ProcValorWrapperAngular(item);
	}

	public String getNomeParaArquivo() {
		String nome = this.getNomeParaClasse();
		String saida = "";
		for (int i=0;i < nome.length(); i++) {
			if (Character.isUpperCase(nome.charAt(i))) {
				if (i==0) saida += ("" + nome.charAt(i)).toLowerCase();
				else saida += "-" + ("" + nome.charAt(i)).toLowerCase();
			} else {
				saida += ("" + nome.charAt(i));
			}
		}
		return saida;
	}

	@Override
	public String getPathArquivo() {
		return getNomeParaArquivo() + "-" + getTipoMinusculo();
	}

	@Override
	public String getArquivo() {
		return getNomeParaArquivo() + "-" + getTipoMinusculo() + ".component";
	}

	private String getTipoMinusculo() {
		if (this.tipo==null) return "";
		String nome = this.tipo;
		String saida = "";
		for (int i=0;i < nome.length(); i++) {
			if (Character.isUpperCase(nome.charAt(i))) {
				if (i==0) saida += ("" + nome.charAt(i)).toLowerCase();
				else saida += "-" + ("" + nome.charAt(i)).toLowerCase();
			} else {
				saida += ("" + nome.charAt(i));
			}
		}
		return saida;
	}
	
	@Override
	public String getNome() {
		return this.entidade.getNome() + this.tipo + "Component";
	}
	
	public String getNomeControle() {
		return "app-" + getPathArquivo();
	}

	// Server de Loopback

	@Override
	public String getNomeModeloServer() {
		return this.getNamesapaceParaClasse() + "_" + this.entidade.getNome();
	}

	@Override
	public String getNomeParaArquivoServer() {
		return this.recursos.getConfiguracao().getNamespace().toLowerCase() + File.separator + getNomeParaArquivo();
	}

	@Override
	public String getNomeParametroServer() {
		return this.entidade.getNome();
	}
	
	
	private String getNamesapaceParaClasse() {
		String nome = this.recursos.getConfiguracao().getNamespace();
		String saida = "";
		boolean colocaMaiuscula = true;
		for (int i=0;i < nome.length(); i++) {
			if (colocaMaiuscula) {
				saida += ("" + nome.charAt(i)).toUpperCase();
				colocaMaiuscula = false;
			} else {
				if (nome.charAt(i) == '_') {
					colocaMaiuscula = true;
				} else {
					saida += nome.charAt(i);
				}
			}
		}
		return saida;
	}
}
