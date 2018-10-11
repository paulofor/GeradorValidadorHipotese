package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.montador.*;
import gerapp.regracolecao.filtro.*;


public  class ProcValorDaoBase  extends DaoAplicacao implements ProcValorDaoBaseI { 
      public ProcValorDaoBase()
      {
          super();
	}
      public ProcValorDaoBase( DataFonte dataSource )
      {
          super( dataSource );
	}

	protected  String ConsultaJoin() {
     String tabelas;
  tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = proc_valor.id_entidade_r " ;
  return tabelas;
	}


	protected  String CamposSelectJoin() {
     String select;
  select =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados();
  return select;
	}

	protected  MontadorDaoI criaMontadorPadrao() {
		return new ProcValorMontador();
	}
	public   static String camposOrdenados() {
		String camposSaida = null;
		camposSaida = "proc_valor.id_proc_valor";
		camposSaida += ", proc_valor.nome";
		camposSaida += ", proc_valor.possui_totalizacao";
		camposSaida += ", proc_valor.descricao";
		camposSaida += ", proc_valor.possui_int";
		camposSaida += ", proc_valor.possui_moeda";
		camposSaida += ", proc_valor.soma_negativo";
		camposSaida += ", proc_valor.calculado_demanda";
		camposSaida += ", proc_valor.tipo";
		camposSaida += ", proc_valor.id_entidade_r";
		return camposSaida;
	}
	public   static String camposOrdenadosAlias( String nomeTabela ) {
		String camposSaida = null;
		camposSaida = " ";
		camposSaida += nomeTabela;
		camposSaida += ".id_proc_valor";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".possui_totalizacao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".descricao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".possui_int";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".possui_moeda";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".soma_negativo";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".calculado_demanda";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".tipo";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade_r";
		return camposSaida;
	}
	public   static String tabelaSelect() {
		return " proc_valor" ;
	}
	public  String orderByLista() {
		return orderBy();
	}
	public  String whereLista() {
		return "";
	}
	public  String whereListaConcatenado() {
		return "";
	}
	public   static String orderBy() {
		return "";
	}
	public  void insereItem( ProcValor item )  throws  DaoException{
		String query = null;
		query = " insert into proc_valor (nome , possui_totalizacao , descricao , possui_int , possui_moeda , soma_negativo , calculado_demanda , tipo , id_entidade_r) values ('" + item.getNome() + "' , '" + (item.getPossuiTotalizacao()?'S':'N') + "' , '" + item.getDescricao() + "' , '" + (item.getPossuiInt()?'S':'N') + "' , '" + (item.getPossuiMoeda()?'S':'N') + "' , '" + (item.getSomaNegativo()?'S':'N') + "' , '" + (item.getCalculadoDemanda()?'S':'N') + "' , '" + item.getTipo() + "' , '" + item.getIdEntidadeR() + "')";
		executaSql(query);
	}
	public  void insereItemCompleto( ProcValor item )  throws  DaoException{
		String query = null;
		query = " insert into proc_valor (id_proc_valor , nome , possui_totalizacao , descricao , possui_int , possui_moeda , soma_negativo , calculado_demanda , tipo , id_entidade_r) values ('" + item.getIdProcValor() + "' , '" + item.getNome() + "' , '" + (item.getPossuiTotalizacao()?'S':'N') + "' , '" + item.getDescricao() + "' , '" + (item.getPossuiInt()?'S':'N') + "' , '" + (item.getPossuiMoeda()?'S':'N') + "' , '" + (item.getSomaNegativo()?'S':'N') + "' , '" + (item.getCalculadoDemanda()?'S':'N') + "' , '" + item.getTipo() + "' , '" + item.getIdEntidadeR() + "')";
		executaSql(query);
	}
	public  boolean insereSeNaoExiste( ProcValor item )  throws  DaoException{
      ProcValor teste = this.obtemPorChave(item.getIdProcValor());
      if (teste == null)
      {
          insereItemCompleto(item);
          return true;
      }
      else
      {
          return false;
      }
	}
	public  void insereItemLoad( ProcValor item )  throws  DaoException{
		String query = null;
		query = " insert into proc_valor (nome , possui_totalizacao , descricao , possui_int , possui_moeda , soma_negativo , calculado_demanda , tipo , id_entidade_r) values ('" + item.getNome() + "' , '" + (item.getPossuiTotalizacao()?'S':'N') + "' , '" + item.getDescricao() + "' , '" + (item.getPossuiInt()?'S':'N') + "' , '" + (item.getPossuiMoeda()?'S':'N') + "' , '" + (item.getSomaNegativo()?'S':'N') + "' , '" + (item.getCalculadoDemanda()?'S':'N') + "' , '" + item.getTipo() + "' , '" + item.getIdEntidadeR() + "')";
		executaSql(query);
     long id;
		//id = getValorLong(" SELECT LAST_INSERT_ID() ");
		id = getValorLong(" SELECT MAX(id_proc_valor) from proc_valor");
		item.setIdProcValor(id);
	}
	public  void alteraItem( ProcValor item )  throws  DaoException{
		String query = null;
		query = " update proc_valor set nome = '" + item.getNome() + "'  , possui_totalizacao = '" + (item.getPossuiTotalizacao()?'S':'N') + "'  , descricao = '" + item.getDescricao() + "'  , possui_int = '" + (item.getPossuiInt()?'S':'N') + "'  , possui_moeda = '" + (item.getPossuiMoeda()?'S':'N') + "'  , soma_negativo = '" + (item.getSomaNegativo()?'S':'N') + "'  , calculado_demanda = '" + (item.getCalculadoDemanda()?'S':'N') + "'  , tipo = '" + item.getTipo() + "'  , id_entidade_r = '" + item.getIdEntidadeR() + "'   where id_proc_valor = " + item.getIdProcValor();
		executaSql(query);
	}
	public  void excluiItem( ProcValor item )  throws  DaoException{
		String query = null;
		query = " delete from proc_valor  where id_proc_valor = " + item.getIdProcValor();
		executaSql(query);
	}
	public  ProcValor obtemPorChave( long chave )  throws  DaoException{
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_proc_valor = " + chave;
		return (ProcValor)getObjeto(query);
	}
// Criar depois no Gerenciador-2005 [Melhoria] um ListaCorrente(conexao)
	public  List ListaCorrente()  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderByLista();;
		return getListaSql(sql);
	}

	public  List ListaFiltroSimples( ProcValorFiltro filtro )  throws  DaoException{
      String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
if (where.length() > 0)
		    sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	protected  String WhereFiltro( ProcValorFiltro filtro ) {
     String saida = "";
      boolean primeiro;
      primeiro = true;
      if (filtro.getCodigoEntidadeRelacionada() != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_entidade_r = " + filtro.getCodigoEntidadeRelacionada();
      }
      return saida;
	}
	public  List ListaFiltro( ProcValorFiltro filtro )  throws  DaoException{
      String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      String where;
      where = WhereFiltro(filtro) + whereListaConcatenado();
      if (where.length() > 0)
          sql += " where " + where;
      sql += orderByLista();
      this.setMontador( new ProcValorMontadorAgrupado());
      return getListaSql(sql);
	}

	public  List ListaCorrenteAgrupada()  throws  DaoException{
     String sql;
     String campos;
     String tabelas;
      campos =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados();
      tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = proc_valor.id_entidade_r " ;
      sql = "select " + campos + " from " + tabelas + " " + whereLista() + " " + orderByLista();
      this.setMontador( new ProcValorMontadorAgrupado());
      return getListaSql(sql);
	}


	public  List ListaPorEntidadeRelacionada( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where proc_valor.id_entidade_r = " + idItem;
      return getListaSql(sql);
	}



	public   static String joinEntidadeRelacionada() {
      return "entidade.id_entidade = proc_valor.id_entidade_r";
	}
	public   static String joinTotal() {
      return "entidade.id_entidade = proc_valor.id_entidade_r";
	}
}
