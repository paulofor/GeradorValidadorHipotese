package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.montador.*;
import gerapp.regracolecao.filtro.*;


public  class AtributoEntidadeDaoBase  extends DaoAplicacao implements AtributoEntidadeDaoBaseI { 
      public AtributoEntidadeDaoBase()
      {
          super();
	}
      public AtributoEntidadeDaoBase( DataFonte dataSource )
      {
          super( dataSource );
	}

	protected  String ConsultaJoin() {
     String tabelas;
  tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = atributo_entidade.id_entidade " ;
  return tabelas;
	}


	protected  String CamposSelectJoin() {
     String select;
  select =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados();
  return select;
	}

	protected  MontadorDaoI criaMontadorPadrao() {
		return new AtributoEntidadeMontador();
	}
	public   static String camposOrdenados() {
		String camposSaida = null;
		camposSaida = "atributo_entidade.id_atributo_entidade";
		camposSaida += ", atributo_entidade.nome";
		camposSaida += ", atributo_entidade.tipo";
		camposSaida += ", atributo_entidade.label_tela";
		camposSaida += ", atributo_entidade.editavel";
		camposSaida += ", atributo_entidade.obrigatorio";
		camposSaida += ", atributo_entidade.ordenacao_tela";
		camposSaida += ", atributo_entidade.id_entidade";
		return camposSaida;
	}
	public   static String camposOrdenadosAlias( String nomeTabela ) {
		String camposSaida = null;
		camposSaida = " ";
		camposSaida += nomeTabela;
		camposSaida += ".id_atributo_entidade";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".tipo";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".label_tela";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".editavel";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".obrigatorio";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".ordenacao_tela";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade";
		return camposSaida;
	}
	public   static String tabelaSelect() {
		return " atributo_entidade" ;
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
	public  void insereItem( AtributoEntidade item )  throws  DaoException{
		String query = null;
		query = " insert into atributo_entidade (nome , tipo , label_tela , editavel , obrigatorio , ordenacao_tela , id_entidade) values ('" + item.getNome() + "' , '" + item.getTipo() + "' , '" + item.getLabelTela() + "' , '" + (item.getEditavel()?'S':'N') + "' , '" + (item.getObrigatorio()?'S':'N') + "' , '" + item.getOrdenacaoTela() + "' , '" + item.getIdEntidade() + "')";
		executaSql(query);
	}
	public  void insereItemCompleto( AtributoEntidade item )  throws  DaoException{
		String query = null;
		query = " insert into atributo_entidade (id_atributo_entidade , nome , tipo , label_tela , editavel , obrigatorio , ordenacao_tela , id_entidade) values ('" + item.getIdAtributoEntidade() + "' , '" + item.getNome() + "' , '" + item.getTipo() + "' , '" + item.getLabelTela() + "' , '" + (item.getEditavel()?'S':'N') + "' , '" + (item.getObrigatorio()?'S':'N') + "' , '" + item.getOrdenacaoTela() + "' , '" + item.getIdEntidade() + "')";
		executaSql(query);
	}
	public  boolean insereSeNaoExiste( AtributoEntidade item )  throws  DaoException{
      AtributoEntidade teste = this.obtemPorChave(item.getIdAtributoEntidade());
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
	public  void insereItemLoad( AtributoEntidade item )  throws  DaoException{
		String query = null;
		query = " insert into atributo_entidade (nome , tipo , label_tela , editavel , obrigatorio , ordenacao_tela , id_entidade) values ('" + item.getNome() + "' , '" + item.getTipo() + "' , '" + item.getLabelTela() + "' , '" + (item.getEditavel()?'S':'N') + "' , '" + (item.getObrigatorio()?'S':'N') + "' , '" + item.getOrdenacaoTela() + "' , '" + item.getIdEntidade() + "')";
		executaSql(query);
     long id;
		//id = getValorLong(" SELECT LAST_INSERT_ID() ");
		id = getValorLong(" SELECT MAX(id_atributo_entidade) from atributo_entidade");
		item.setIdAtributoEntidade(id);
	}
	public  void alteraItem( AtributoEntidade item )  throws  DaoException{
		String query = null;
		query = " update atributo_entidade set nome = '" + item.getNome() + "'  , tipo = '" + item.getTipo() + "'  , label_tela = '" + item.getLabelTela() + "'  , editavel = '" + (item.getEditavel()?'S':'N') + "'  , obrigatorio = '" + (item.getObrigatorio()?'S':'N') + "'  , ordenacao_tela = '" + item.getOrdenacaoTela() + "'  , id_entidade = '" + item.getIdEntidade() + "'   where id_atributo_entidade = " + item.getIdAtributoEntidade();
		executaSql(query);
	}
	public  void excluiItem( AtributoEntidade item )  throws  DaoException{
		String query = null;
		query = " delete from atributo_entidade  where id_atributo_entidade = " + item.getIdAtributoEntidade();
		executaSql(query);
	}
	public  AtributoEntidade obtemPorChave( long chave )  throws  DaoException{
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_atributo_entidade = " + chave;
		return (AtributoEntidade)getObjeto(query);
	}
// Criar depois no Gerenciador-2005 [Melhoria] um ListaCorrente(conexao)
	public  List ListaCorrente()  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderByLista();;
		return getListaSql(sql);
	}

	public  List ListaFiltroSimples( AtributoEntidadeFiltro filtro )  throws  DaoException{
      String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
if (where.length() > 0)
		    sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	protected  String WhereFiltro( AtributoEntidadeFiltro filtro ) {
     String saida = "";
      boolean primeiro;
      primeiro = true;
      if (filtro.getCodigoEntidade () != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_entidade = " + filtro.getCodigoEntidade ();
      }
      return saida;
	}
	public  List ListaFiltro( AtributoEntidadeFiltro filtro )  throws  DaoException{
      String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      String where;
      where = WhereFiltro(filtro) + whereListaConcatenado();
      if (where.length() > 0)
          sql += " where " + where;
      sql += orderByLista();
      this.setMontador( new AtributoEntidadeMontadorAgrupado());
      return getListaSql(sql);
	}

	public  List ListaCorrenteAgrupada()  throws  DaoException{
     String sql;
     String campos;
     String tabelas;
      campos =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados();
      tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = atributo_entidade.id_entidade " ;
      sql = "select " + campos + " from " + tabelas + " " + whereLista() + " " + orderByLista();
      this.setMontador( new AtributoEntidadeMontadorAgrupado());
      return getListaSql(sql);
	}


	public  List ListaPorEntidade ( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where atributo_entidade.id_entidade = " + idItem +
      		" order by id_atributo_entidade";
      return getListaSql(sql);
	}


	public  List ListaNaoRelacionadaEmEntidadeListaIdentificador( long idEntidade )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}
	public  List ListaNaoRelacionadaEmEntidadeListaChave( long idEntidade )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}

	public   static String joinEntidade () {
      return "entidade.id_entidade = atributo_entidade.id_entidade";
	}
	public   static String joinTotal() {
      return "entidade.id_entidade = atributo_entidade.id_entidade";
	}
}
