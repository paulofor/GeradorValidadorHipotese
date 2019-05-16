package jet.wrappers.base;

import gerapp.app.Recursos;
import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.Entidade;
import gerapp.modelo.FiltroColecao;
import gerapp.modelo.ProcValor;
import gerapp.modelo.RegraColecao;
import gerapp.modelo.RelacionamentoEntidade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public abstract class ClasseWrapper {

	private List<AtributoWrapper> listaAtributoW;
	private List<AtributoEntidade> listaAtributo;
	private List<RelacionamentoEntidade> listaRelacionamento;
	private List<FiltroColecao> listaFiltro;
	private List<RegraColecao> listaRegra;
	private List<ProcValor> listaProcValor;
	private AtributoEntidade chave;
	private AtributoEntidade identificador;
	private List<String> listaHtml;
	
	
	
	protected abstract RelacionamentoWrapper criaRelacionamentoWrapper(RelacionamentoEntidade item);
	protected abstract AtributoWrapper criaAtributoWrapper(AtributoEntidade item);
	protected abstract ProcValorWrapper criaProcValorWrapper(ProcValor item);
	
	protected Recursos recursos;

	private ClasseWrapper classeMatriz = null;
	
	public void setRecursos(Recursos item) {
		this.recursos = item;
	}

	public List<ProcValorWrapper> getListaDerivadaDemanda() {
		List<ProcValorWrapper> lista = new ArrayList<ProcValorWrapper>();
		for (ProcValor valor : listaProcValor) {
			if (valor.getCalculadoDemanda()) {
				lista.add(criaProcValorWrapper(valor));
			}
		}
		return lista;
	}
	
	public boolean possuiDerivadaDemanda() {
		for (ProcValor valor : listaProcValor) {
			if (valor.getCalculadoDemanda()) return true;
		}
		return false;
	}
	
	public boolean ehUsuario() {
		return "Usuario".equals(entidade.getNome());
	}
	public boolean ehDispositivo() {
		return "Dispositivo Usuario".equals(entidade.getNome());
	}
	public int qtdeAtributo() {
		return listaAtributo.size();
	}
	/*
	public boolean ehRelacionamento() {
		return entidade.getAssociativa();
	}
	*/
	
	
	public ClasseWrapper obtemClasseMatriz() {
		if (classeMatriz==null) {
			Iterator<RelacionamentoWrapper> itRel = this.obtemListaComChaveEstrangeira().iterator();
			while (itRel.hasNext()) {
				RelacionamentoWrapper rel = itRel.next();
				if (rel.getBase().getDependente()) {
					classeMatriz = rel.getClasseOposta();
					break;
				}
			}
		}
		return classeMatriz;
	}
	
	
	public RelacionamentoWrapper getUnicoDependenteLista() {
		List<RelacionamentoWrapper> listaRelac = obtemListaDependente(); 
		if (listaRelac.size()==1) {
			return listaRelac.get(0);
		} else {
			return null;
		}
	}
	
	public boolean possuiClasseMatriz() {
		return (obtemClasseMatriz()!=null);
	}
	
	public RelacionamentoWrapper outroRel(RelacionamentoWrapper rel) {
		List<RelacionamentoEntidade> listaRelSemUsuario =  getListaRelacionamentoSemUsuario();
		if (rel.getId()==listaRelSemUsuario.get(0).getIdRelacionamentoEntidade()) {
			RelacionamentoWrapper saida = criaRelacionamentoWrapper(listaRelSemUsuario.get(1));
			saida.setEntidadeReferencia(this);
			return saida;
		}
		if (rel.getId()==listaRelSemUsuario.get(1).getIdRelacionamentoEntidade()) {
			RelacionamentoWrapper saida = criaRelacionamentoWrapper(listaRelSemUsuario.get(0));
			saida.setEntidadeReferencia(this);
			return saida;
		}
		throw new RuntimeException("Existe mais de dois relacionamentos nessa associação " + this.getNomeParaClasse());
	}
	
	
	public List<RelacionamentoWrapper> getListaItemN() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			if (outroLadoN(relac)) {
				RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
				relW.setEntidadeReferencia(this);
				listaRel.add(relW);
			}
		}
		return listaRel;
	}
	
	public List<RelacionamentoWrapper> getListaItem1() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			if (!outroLadoN(relac)) {
				RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
				relW.setEntidadeReferencia(this);
				listaRel.add(relW);
			}
		}
		return listaRel;	
	}
	
	
	private List<RelacionamentoEntidade> getListaRelacionamentoSemUsuario() {
		List<RelacionamentoEntidade> listaSaida = new LinkedList<RelacionamentoEntidade>();
		for (RelacionamentoEntidade corrente : this.listaRelacionamento) {
			if (!"sincroniza".equals(corrente.getNome1()) && !"sincroniza".equals(corrente.getNome2())) {
				listaSaida.add(corrente);
			}
		}
		return listaSaida;
	}
	
	public List<AtributoWrapper> getListaCamposEdicao() {
		List<AtributoWrapper> listaSaida = new ArrayList<AtributoWrapper>();
		Iterator<AtributoEntidade> itAtt = this.getListaAtributoEntidade().iterator();
		while (itAtt.hasNext()) {
			AtributoEntidade atributo = itAtt.next();
			if (atributo.getEditavel()) {
				listaSaida.add(this.criaAtributoWrapper(atributo));			}
		}
		return listaSaida;
	}
	
	public List<AtributoTotalI> getListaAtributoTotal() {
		List<AtributoTotalI> listaSaida = new ArrayList<AtributoTotalI>();
		Iterator<AtributoEntidade> itAtt = this.getListaAtributoEntidade().iterator();
		while (itAtt.hasNext()) {
			listaSaida.add(this.criaAtributoWrapper(itAtt.next()));
		}
		Iterator<RelacionamentoWrapper> itRel = this.obtemListaComChaveEstrangeiraComUsuario().iterator();
		while (itRel.hasNext()) {
			listaSaida.add(itRel.next());
		}
		return listaSaida;
	}
	public List<AtributoTotalI> getListaAtributoTotalSemUsuario() {
		List<AtributoTotalI> listaSaida = new ArrayList<AtributoTotalI>();
		Iterator<AtributoEntidade> itAtt = this.getListaAtributoEntidade().iterator();
		while (itAtt.hasNext()) {
			listaSaida.add(this.criaAtributoWrapper(itAtt.next()));
		}
		Iterator<RelacionamentoWrapper> itRel = this.obtemListaComChaveEstrangeira().iterator();
		while (itRel.hasNext()) {
			listaSaida.add(itRel.next());
		}
		return listaSaida;
	}
	
	public List<RelacionamentoWrapper> obtemListaDependente() {
		// Semelhante a lista de obtemListaSemChaveEstrangeira mas que é dependente.
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			if ((!possuiChaveEstrangeira(relac) || relac.getIdEntidade1()==relac.getIdEntidade2()) && relac.getDependente()) {
				RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
				relW.setEntidadeReferencia(this);
				listaRel.add(relW);
			}
		}
		return listaRel;
	}
	public List<RelacionamentoWrapper> obtemListaDependentePai() {
		// Semelhante a lista de obtemListaComChaveEstrangeira mas que é dependente.
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			if ((possuiChaveEstrangeira(relac) || relac.getIdEntidade1()==relac.getIdEntidade2()) && relac.getDependente()) {
				RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
				relW.setEntidadeReferencia(this);
				listaRel.add(relW);
			}
		}
		return listaRel;
	}
	
	public boolean possuiRelacionamentoUsuario() {
		if (this.ehDispositivo()) return false;
		RelacionamentoWrapper rel = getRelacionamentoUsuario();
		return (rel!=null);
	}
	
	public RelacionamentoWrapper getRelacionamentoUsuario() {
		List<RelacionamentoWrapper> listaRel = obtemListaComChaveEstrangeiraComUsuario();
		for (RelacionamentoWrapper corrente : listaRel) {
			if ("Usuario".equals(corrente.getClasseOposta().getNomeParaClasse())) {
				return corrente;
			}
		}
		return null;
	}
	
	
	
	public List<RelacionamentoWrapper> obtemListaComChaveEstrangeiraComUsuario() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		if (!this.ehUsuario()) {
			Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
			while (itRelac.hasNext()) {
				RelacionamentoEntidade relac = itRelac.next();
				if (possuiChaveEstrangeira(relac) && relac.getQtdeEntidade1().compareTo(relac.getQtdeEntidade2())!=0) {
					RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
					relW.setEntidadeReferencia(this);
					listaRel.add(relW);
				}
			}
		}
		return listaRel;
	}
	
	
	public List<RelacionamentoWrapper> obtemListaComChaveEstrangeira() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			if (!ComUsuario(relac)) {
				if (possuiChaveEstrangeira(relac) && relac.getQtdeEntidade1().compareTo(relac.getQtdeEntidade2())!=0) {
					RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
					relW.setEntidadeReferencia(this);
					listaRel.add(relW);
				}
			}
		}
		return listaRel;
	}
	public List<RelacionamentoWrapper> obtemListaComChaveEstrangeiraSemUsuario() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			if (!ComUsuario(relac)) {
				if (possuiChaveEstrangeira(relac) && relac.getQtdeEntidade1().compareTo(relac.getQtdeEntidade2())!=0) {
					RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
					relW.setEntidadeReferencia(this);
					if (relW.getClasseOposta()==null || !relW.getClasseOposta().ehUsuario()) {
						relW.setEntidadeReferencia(this);
						listaRel.add(relW);
					}
				}
			}
		}
		return listaRel;
	}
	
	private boolean ComUsuario(RelacionamentoEntidade rel) {
		//RelacionamentoWrapper relW = criaRelacionamentoWrapper(rel);
		//if (relW.getClasseOposta()!=null && relW.getClasseOposta().ehUsuario()) return true;
		return ("sincroniza".equals(rel.getNome1()) || "sincroniza".equals(rel.getNome2())); 
	}
	
	public List<RelacionamentoWrapper> obtemListaSemChaveEstrangeira() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		if (!this.ehUsuario()) {
			Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
			while (itRelac.hasNext()) {
				RelacionamentoEntidade relac = itRelac.next();
				if (!possuiChaveEstrangeira(relac) || relac.getIdEntidade1()==relac.getIdEntidade2()) {
					RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
					relW.setEntidadeReferencia(this);
					listaRel.add(relW);
				}
			}
		}
		return listaRel;
	}
	
	public List<RelacionamentoWrapper> obtemListaSemChaveEstrangeiraComUsuario() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			if (!possuiChaveEstrangeira(relac) || relac.getIdEntidade1()==relac.getIdEntidade2()) {
				RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
				relW.setEntidadeReferencia(this);
				listaRel.add(relW);
			}
		}
		return listaRel;
	}
	
	public List<RelacionamentoWrapper> obtemListaSemChaveEstrangeiraSemUsuario() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		if (!this.ehUsuario()) {
			Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
			while (itRelac.hasNext()) {
				RelacionamentoEntidade relac = itRelac.next();
				if (!possuiChaveEstrangeira(relac) || relac.getIdEntidade1()==relac.getIdEntidade2()) {
					RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
					if (relW.getClasseOposta()==null || !relW.getClasseOposta().ehUsuario()) {
						relW.setEntidadeReferencia(this);
						listaRel.add(relW);
					}
				}
			}
		}
		return listaRel;
	}
	
	
	public List<String> obtemListaHtml() {
		listaHtml = new ArrayList<String>();
		return this.listaHtml;
	}
	
	public List<RelacionamentoWrapper> obtemListaUmPraUm() {
		List<RelacionamentoWrapper> listaRel = new ArrayList<RelacionamentoWrapper> ();
		Iterator<RelacionamentoEntidade> itRelac = listaRelacionamento.iterator();
		boolean umPraUm = false;
		while (itRelac.hasNext()) {
			RelacionamentoEntidade relac = itRelac.next();
			umPraUm = ("1".equals(relac.getQtdeEntidade1())) && ("1".equals(relac.getQtdeEntidade2()));
			if (umPraUm) {
				RelacionamentoWrapper relW = criaRelacionamentoWrapper(relac);
				relW.setEntidadeReferencia(this);
				listaRel.add(relW);
			}
		}
		return listaRel;
	}
	
	private boolean possuiChaveEstrangeira(RelacionamentoEntidade rel) {
		if (this.entidade.getIdEntidade()==rel.getIdEntidade1()) {
			if (rel.getQtdeEntidade2().toUpperCase().equals("1")) {
				return true;
			}
		}
		if (this.entidade.getIdEntidade()==rel.getIdEntidade2()) {
			if (rel.getQtdeEntidade1().toUpperCase().equals("1")) {
				return true;
			}
		}
		return false;
	}
	
	private boolean outroLadoN(RelacionamentoEntidade rel) {
		if (this.entidade.getIdEntidade()==rel.getIdEntidade1()) {
			if (rel.getQtdeEntidade1().toUpperCase().equals("N")) {
				return true;
			}
		}
		if (this.entidade.getIdEntidade()==rel.getIdEntidade2()) {
			if (rel.getQtdeEntidade2().toUpperCase().equals("N")) {
				return true;
			}
		}
		return false;
	}
	private boolean outroLado1(RelacionamentoEntidade rel) {
		if (this.entidade.getIdEntidade()==rel.getIdEntidade1()) {
			if (rel.getQtdeEntidade1().toUpperCase().equals("1")) {
				return true;
			}
		}
		if (this.entidade.getIdEntidade()==rel.getIdEntidade2()) {
			if (rel.getQtdeEntidade2().toUpperCase().equals("1")) {
				return true;
			}
		}
		return false;
	}
	
	public void setChave(AtributoEntidade chave) {
		this.chave = chave;
	}
	public AtributoEntidade getChave() {
		return this.chave;
	}
	public AtributoWrapper getChaveW() {
		return criaAtributoWrapper(this.chave);
	}
	public AtributoWrapper getIdentificadorW() {
		if (this.identificador==null) throw new RuntimeException(this.getNomeParaClasse() + " sem identificador !!!");
		return criaAtributoWrapper(this.identificador);
	}
	public void setIdentificador(AtributoEntidade identificador) {
		this.identificador = identificador;
	}
	public AtributoEntidade getIdentificador() {
		return this.identificador;
	}
	
	public void setListaFiltroColecao(List<FiltroColecao> lista){
		this.listaFiltro = lista;
	}
	public List<FiltroColecao> getListaFiltroColecao() {
		return this.listaFiltro;
	}
	
	public void setListaRegraColecao(List<RegraColecao> lista){
		this.listaRegra = lista;
	}
	public List<RegraColecao> getListaRegraColecao() {
		return this.listaRegra;
	}
	
	public void setListaRelacionamento(List<RelacionamentoEntidade> lista) {
		listaRelacionamento = lista;
	}
	public List<RelacionamentoEntidade> getListaRelacionamento() {
		return listaRelacionamento;
	}
	public void setListaAtributoEntidade(List<AtributoEntidade> lista) {
		listaAtributo = lista;
		Iterator<AtributoEntidade> it = lista.iterator();
		listaAtributoW = new LinkedList<AtributoWrapper>();
		while (it.hasNext()) {
			AtributoEntidade att = it.next();
			att.setEntidade(this.entidade);
			listaAtributoW.add(criaAtributoWrapper(att));
		}
		
	}
	
	public List<AtributoEntidade> getListaAtributoEntidadeSemChave() {
		List<AtributoEntidade> saida = new LinkedList<AtributoEntidade>();
		for (AtributoEntidade item : listaAtributo) {
			if (!item.getChave()) saida.add(item);
		}
		return saida;
	}
	
	public List<AtributoWrapper> getListaAtributoEntidadeWSemChave() {
		List<AtributoWrapper> saida = new LinkedList<AtributoWrapper>();
		for (AtributoWrapper item : listaAtributoW) {
			if (!item.ehChave()) saida.add(item);
		}
		return saida;
	}
	
	public List<AtributoEntidade> getListaAtributoEntidade() {
		return listaAtributo;
	}
	
	public List<AtributoWrapper> getListaAtributoEntidadeW() {
		return listaAtributoW;
	}
	public Iterator<AtributoWrapper> getIteratorAtributo() {
		return listaAtributoW.iterator();
	}
	
	public void setListaProcValor(List<ProcValor> lista) {
		listaProcValor = lista;
	}
	public List<ProcValor> getListaProcValor() {
		return listaProcValor;
	}
	
	
	protected Entidade entidade;
	public void setEntidade(Entidade dado) {
		entidade = dado;
	}
	
	public ClasseWrapper(Entidade ent) {
		this.entidade = ent;
	}
	
	public String getNomeParaClasse() {
		String nome = entidade.getNome().replaceAll(" ", "");
		return nome;
	}
	public String getNomeParaVariavel() {
		String nome = getNomeParaClasse();
		return nome.substring(0,1).toLowerCase() + nome.substring(1);
	}
	public String getNomeParaTabela() {
		String nome = entidade.getNome().replaceAll(" ", "_");
		nome = nome.toLowerCase();
		return nome;
	}
	public String getNomeParaConstante() {
		String nome = entidade.getNome().replaceAll(" ", "_");
		nome = nome.toUpperCase();
		return nome;
	}
	
	
	public long getId() {
		return entidade.getIdEntidade();
	}
	public long getIdChave() {
		return entidade.getIdAtributoEntidadeC();
	}
	public long getIdIdentificador() {
		return entidade.getIdAtributoEntidadeI();
	}
	public boolean isAssociativa() {
		return entidade.getAssociativa();
	}
	
	
}
