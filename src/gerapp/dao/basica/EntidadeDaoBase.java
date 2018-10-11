package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.montador.*;
import gerapp.regracolecao.filtro.*;


public  class EntidadeDaoBase  extends DaoAplicacao implements EntidadeDaoBaseI { 
      public EntidadeDaoBase()
      {
          super();
	}
      public EntidadeDaoBase( DataFonte dataSource )
      {
          super( dataSource );
	}

	protected  String ConsultaJoin() {
     String tabelas;
  tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + AplicacaoDaoBase.tabelaSelect() + " ON aplicacao.id_aplicacao = entidade.id_aplicacao  LEFT OUTER JOIN  " + AtributoEntidadeDaoBase.tabelaSelect() + " ON atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_i  LEFT OUTER JOIN  " + AtributoEntidadeDaoBase.tabelaSelect() + " ON atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_c " ;
  return tabelas;
	}


	protected  String CamposSelectJoin() {
     String select;
  select =  camposOrdenados() + " , " + AplicacaoDaoBase.camposOrdenados()+ " , " + AtributoEntidadeDaoBase.camposOrdenados()+ " , " + AtributoEntidadeDaoBase.camposOrdenados();
  return select;
	}

	protected  MontadorDaoI criaMontadorPadrao() {
		return new EntidadeMontador();
	}
	public   static String camposOrdenados() {
		String camposSaida = null;
		camposSaida = "entidade.id_entidade";
		camposSaida += ", entidade.nome";
		camposSaida += ", entidade.associativa";
		camposSaida += ", entidade.id_aplicacao";
		camposSaida += ", entidade.id_atributo_entidade_i";
		camposSaida += ", entidade.id_atributo_entidade_c";
		return camposSaida;
	}
	public   static String camposOrdenadosAlias( String nomeTabela ) {
		String camposSaida = null;
		camposSaida = " ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".associativa";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_aplicacao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_atributo_entidade_i";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_atributo_entidade_c";
		return camposSaida;
	}
	public   static String tabelaSelect() {
		return " entidade" ;
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
	public  void insereItem( Entidade item )  throws  DaoException{
		String query = null;
		query = " insert into entidade (nome , associativa , id_aplicacao , id_atributo_entidade_i , id_atributo_entidade_c) values ('" + item.getNome() + "' , '" + (item.getAssociativa()?'S':'N') + "' , '" + item.getIdAplicacao() + "' , '" + item.getIdAtributoEntidadeI() + "' , '" + item.getIdAtributoEntidadeC() + "')";
		executaSql(query);
	}
	public  void insereItemCompleto( Entidade item )  throws  DaoException{
		String query = null;
		query = " insert into entidade (id_entidade , nome , associativa , id_aplicacao , id_atributo_entidade_i , id_atributo_entidade_c) values ('" + item.getIdEntidade() + "' , '" + item.getNome() + "' , '" + (item.getAssociativa()?'S':'N') + "' , '" + item.getIdAplicacao() + "' , '" + item.getIdAtributoEntidadeI() + "' , '" + item.getIdAtributoEntidadeC() + "')";
		executaSql(query);
	}
	public  boolean insereSeNaoExiste( Entidade item )  throws  DaoException{
      Entidade teste = this.obtemPorChave(item.getIdEntidade());
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
	public  void insereItemLoad( Entidade item )  throws  DaoException{
		String query = null;
		query = " insert into entidade (nome , associativa , id_aplicacao , id_atributo_entidade_i , id_atributo_entidade_c) values ('" + item.getNome() + "' , '" + (item.getAssociativa()?'S':'N') + "' , '" + item.getIdAplicacao() + "' , '" + item.getIdAtributoEntidadeI() + "' , '" + item.getIdAtributoEntidadeC() + "')";
		executaSql(query);
     long id;
		//id = getValorLong(" SELECT LAST_INSERT_ID() ");
		id = getValorLong(" SELECT MAX(id_entidade) from entidade");
		item.setIdEntidade(id);
	}
	public  void alteraItem( Entidade item )  throws  DaoException{
		String query = null;
		query = " update entidade set nome = '" + item.getNome() + "'  , associativa = '" + (item.getAssociativa()?'S':'N') + "'  , id_aplicacao = '" + item.getIdAplicacao() + "'  , id_atributo_entidade_i = '" + item.getIdAtributoEntidadeI() + "'  , id_atributo_entidade_c = '" + item.getIdAtributoEntidadeC() + "'   where id_entidade = " + item.getIdEntidade();
		executaSql(query);
	}
	public  void excluiItem( Entidade item )  throws  DaoException{
		String query = null;
		query = " delete from entidade  where id_entidade = " + item.getIdEntidade();
		executaSql(query);
	}
	public  Entidade obtemPorChave( long chave )  throws  DaoException{
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_entidade = " + chave;
		return (Entidade)getObjeto(query);
	}
// Criar depois no Gerenciador-2005 [Melhoria] um ListaCorrente(conexao)
	public  List ListaCorrente()  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderByLista();;
		return getListaSql(sql);
	}

	public  List ListaFiltroSimples( EntidadeFiltro filtro )  throws  DaoException{
      String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
if (where.length() > 0)
		    sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	protected  String WhereFiltro( EntidadeFiltro filtro ) {
     String saida = "";
      boolean primeiro;
      primeiro = true;
      if (filtro.getCodigoAplicacao () != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_aplicacao = " + filtro.getCodigoAplicacao ();
      }
      if (filtro.getCodigoAtributoEntidadeIdentificador() != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_atributo_entidade_i = " + filtro.getCodigoAtributoEntidadeIdentificador();
      }
      if (filtro.getCodigoAtributoEntidadeChave() != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_atributo_entidade_c = " + filtro.getCodigoAtributoEntidadeChave();
      }
      return saida;
	}
	public  List ListaFiltro( EntidadeFiltro filtro )  throws  DaoException{
      String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      String where;
      where = WhereFiltro(filtro) + whereListaConcatenado();
      if (where.length() > 0)
          sql += " where " + where;
      sql += orderByLista();
      this.setMontador( new EntidadeMontadorAgrupado());
      return getListaSql(sql);
	}

	public  List ListaCorrenteAgrupada()  throws  DaoException{
     String sql;
     String campos;
     String tabelas;
      campos =  camposOrdenados() + " , " + AplicacaoDaoBase.camposOrdenados()+ " , " + AtributoEntidadeDaoBase.camposOrdenados()+ " , " + AtributoEntidadeDaoBase.camposOrdenados();
      tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + AplicacaoDaoBase.tabelaSelect() + " ON aplicacao.id_aplicacao = entidade.id_aplicacao  LEFT OUTER JOIN  " + AtributoEntidadeDaoBase.tabelaSelect() + " ON atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_i  LEFT OUTER JOIN  " + AtributoEntidadeDaoBase.tabelaSelect() + " ON atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_c " ;
      sql = "select " + campos + " from " + tabelas + " " + whereLista() + " " + orderByLista();
      this.setMontador( new EntidadeMontadorAgrupado());
      return getListaSql(sql);
	}


	public  List ListaPorAplicacao ( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where entidade.id_aplicacao = " + idItem;
      return getListaSql(sql);
	}
	public  List ListaPorAtributoEntidadeIdentificador( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where entidade.id_atributo_entidade_i = " + idItem;
      return getListaSql(sql);
	}
	public  List ListaPorAtributoEntidadeChave( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where entidade.id_atributo_entidade_c = " + idItem;
      return getListaSql(sql);
	}


	public  List ListaNaoRelacionadaEmAtributoEntidadeLista ( long idAtributoEntidade )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}
	public  List ListaNaoRelacionadaEmFiltroColecaoLista ( long idFiltroColecao )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}
	public  List ListaNaoRelacionadaEmFiltroColecaoListaTipo( long idFiltroColecao )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}
	public  List ListaNaoRelacionadaEmRegraColecaoLista ( long idRegraColecao )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}
	public  List ListaNaoRelacionadaEmRelacionamentoEntidadeLista1( long idRelacionamentoEntidade )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}
	public  List ListaNaoRelacionadaEmRelacionamentoEntidadeLista2( long idRelacionamentoEntidade )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}
	public  List ListaNaoRelacionadaEmProcValorListaRelacionada( long idProcValor )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}

	public   static String joinAplicacao () {
      return "aplicacao.id_aplicacao = entidade.id_aplicacao";
	}
	public   static String joinAtributoEntidadeIdentificador() {
      return "atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_i";
	}
	public   static String joinAtributoEntidadeChave() {
      return "atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_c";
	}
	public   static String joinTotal() {
      return "aplicacao.id_aplicacao = entidade.id_aplicacao and atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_i and atributo_entidade.id_atributo_entidade = entidade.id_atributo_entidade_c";
	}
}
