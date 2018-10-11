package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.montador.*;
import gerapp.regracolecao.filtro.*;


public  class FiltroColecaoDaoBase  extends DaoAplicacao implements FiltroColecaoDaoBaseI { 
      public FiltroColecaoDaoBase()
      {
          super();
	}
      public FiltroColecaoDaoBase( DataFonte dataSource )
      {
          super( dataSource );
	}

	protected  String ConsultaJoin() {
     String tabelas;
  tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = filtro_colecao.id_entidade  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = filtro_colecao.id_entidade_t " ;
  return tabelas;
	}


	protected  String CamposSelectJoin() {
     String select;
  select =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados()+ " , " + EntidadeDaoBase.camposOrdenados();
  return select;
	}

	protected  MontadorDaoI criaMontadorPadrao() {
		return new FiltroColecaoMontador();
	}
	public   static String camposOrdenados() {
		String camposSaida = null;
		camposSaida = "filtro_colecao.id_filtro_colecao";
		camposSaida += ", filtro_colecao.nome_campo_filtro";
		camposSaida += ", filtro_colecao.tipo_campo_filtro";
		camposSaida += ", filtro_colecao.id_entidade";
		camposSaida += ", filtro_colecao.id_entidade_t";
		return camposSaida;
	}
	public   static String camposOrdenadosAlias( String nomeTabela ) {
		String camposSaida = null;
		camposSaida = " ";
		camposSaida += nomeTabela;
		camposSaida += ".id_filtro_colecao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome_campo_filtro";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".tipo_campo_filtro";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade_t";
		return camposSaida;
	}
	public   static String tabelaSelect() {
		return " filtro_colecao" ;
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
	public  void insereItem( FiltroColecao item )  throws  DaoException{
		String query = null;
		query = " insert into filtro_colecao (nome_campo_filtro , tipo_campo_filtro , id_entidade , id_entidade_t) values ('" + item.getNomeCampoFiltro() + "' , '" + item.getTipoCampoFiltro() + "' , '" + item.getIdEntidade() + "' , '" + item.getIdEntidadeT() + "')";
		executaSql(query);
	}
	public  void insereItemCompleto( FiltroColecao item )  throws  DaoException{
		String query = null;
		query = " insert into filtro_colecao (id_filtro_colecao , nome_campo_filtro , tipo_campo_filtro , id_entidade , id_entidade_t) values ('" + item.getIdFiltroColecao() + "' , '" + item.getNomeCampoFiltro() + "' , '" + item.getTipoCampoFiltro() + "' , '" + item.getIdEntidade() + "' , '" + item.getIdEntidadeT() + "')";
		executaSql(query);
	}
	public  boolean insereSeNaoExiste( FiltroColecao item )  throws  DaoException{
      FiltroColecao teste = this.obtemPorChave(item.getIdFiltroColecao());
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
	public  void insereItemLoad( FiltroColecao item )  throws  DaoException{
		String query = null;
		query = " insert into filtro_colecao (nome_campo_filtro , tipo_campo_filtro , id_entidade , id_entidade_t) values ('" + item.getNomeCampoFiltro() + "' , '" + item.getTipoCampoFiltro() + "' , '" + item.getIdEntidade() + "' , '" + item.getIdEntidadeT() + "')";
		executaSql(query);
     long id;
		//id = getValorLong(" SELECT LAST_INSERT_ID() ");
		id = getValorLong(" SELECT MAX(id_filtro_colecao) from filtro_colecao");
		item.setIdFiltroColecao(id);
	}
	public  void alteraItem( FiltroColecao item )  throws  DaoException{
		String query = null;
		query = " update filtro_colecao set nome_campo_filtro = '" + item.getNomeCampoFiltro() + "'  , tipo_campo_filtro = '" + item.getTipoCampoFiltro() + "'  , id_entidade = '" + item.getIdEntidade() + "'  , id_entidade_t = '" + item.getIdEntidadeT() + "'   where id_filtro_colecao = " + item.getIdFiltroColecao();
		executaSql(query);
	}
	public  void excluiItem( FiltroColecao item )  throws  DaoException{
		String query = null;
		query = " delete from filtro_colecao  where id_filtro_colecao = " + item.getIdFiltroColecao();
		executaSql(query);
	}
	public  FiltroColecao obtemPorChave( long chave )  throws  DaoException{
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_filtro_colecao = " + chave;
		return (FiltroColecao)getObjeto(query);
	}
// Criar depois no Gerenciador-2005 [Melhoria] um ListaCorrente(conexao)
	public  List ListaCorrente()  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderByLista();;
		return getListaSql(sql);
	}

	public  List ListaFiltroSimples( FiltroColecaoFiltro filtro )  throws  DaoException{
      String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
if (where.length() > 0)
		    sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	protected  String WhereFiltro( FiltroColecaoFiltro filtro ) {
     String saida = "";
      boolean primeiro;
      primeiro = true;
      if (filtro.getCodigoEntidade () != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_entidade = " + filtro.getCodigoEntidade ();
      }
      if (filtro.getCodigoEntidadeTipo() != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_entidade_t = " + filtro.getCodigoEntidadeTipo();
      }
      return saida;
	}
	public  List ListaFiltro( FiltroColecaoFiltro filtro )  throws  DaoException{
      String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      String where;
      where = WhereFiltro(filtro) + whereListaConcatenado();
      if (where.length() > 0)
          sql += " where " + where;
      sql += orderByLista();
      this.setMontador( new FiltroColecaoMontadorAgrupado());
      return getListaSql(sql);
	}

	public  List ListaCorrenteAgrupada()  throws  DaoException{
     String sql;
     String campos;
     String tabelas;
      campos =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados()+ " , " + EntidadeDaoBase.camposOrdenados();
      tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = filtro_colecao.id_entidade  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = filtro_colecao.id_entidade_t " ;
      sql = "select " + campos + " from " + tabelas + " " + whereLista() + " " + orderByLista();
      this.setMontador( new FiltroColecaoMontadorAgrupado());
      return getListaSql(sql);
	}


	public  List ListaPorEntidade ( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where filtro_colecao.id_entidade = " + idItem;
      return getListaSql(sql);
	}
	public  List ListaPorEntidadeTipo( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where filtro_colecao.id_entidade_t = " + idItem;
      return getListaSql(sql);
	}



	public   static String joinEntidade () {
      return "entidade.id_entidade = filtro_colecao.id_entidade";
	}
	public   static String joinEntidadeTipo() {
      return "entidade.id_entidade = filtro_colecao.id_entidade_t";
	}
	public   static String joinTotal() {
      return "entidade.id_entidade = filtro_colecao.id_entidade and entidade.id_entidade = filtro_colecao.id_entidade_t";
	}
}
