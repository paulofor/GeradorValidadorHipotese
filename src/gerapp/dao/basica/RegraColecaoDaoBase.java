package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.montador.*;
import gerapp.regracolecao.filtro.*;


public  class RegraColecaoDaoBase  extends DaoAplicacao implements RegraColecaoDaoBaseI { 
      public RegraColecaoDaoBase()
      {
          super();
	}
      public RegraColecaoDaoBase( DataFonte dataSource )
      {
          super( dataSource );
	}

	protected  String ConsultaJoin() {
     String tabelas;
  tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = regra_colecao.id_entidade " ;
  return tabelas;
	}


	protected  String CamposSelectJoin() {
     String select;
  select =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados();
  return select;
	}

	protected  MontadorDaoI criaMontadorPadrao() {
		return new RegraColecaoMontador();
	}
	public   static String camposOrdenados() {
		String camposSaida = null;
		camposSaida = "regra_colecao.id_regra_colecao";
		camposSaida += ", regra_colecao.nome";
		camposSaida += ", regra_colecao.descricao";
		camposSaida += ", regra_colecao.retorna_colecao";
		camposSaida += ", regra_colecao.recebe_colecao";
		camposSaida += ", regra_colecao.ativo_java";
		camposSaida += ", regra_colecao.ativo_cpp";
		camposSaida += ", regra_colecao.ativo_flex";
		camposSaida += ", regra_colecao.ativo_cs";
		camposSaida += ", regra_colecao.id_entidade";
		return camposSaida;
	}
	public   static String camposOrdenadosAlias( String nomeTabela ) {
		String camposSaida = null;
		camposSaida = " ";
		camposSaida += nomeTabela;
		camposSaida += ".id_regra_colecao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".descricao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".retorna_colecao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".recebe_colecao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".ativo_java";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".ativo_cpp";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".ativo_flex";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".ativo_cs";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade";
		return camposSaida;
	}
	public   static String tabelaSelect() {
		return " regra_colecao" ;
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
	public  void insereItem( RegraColecao item )  throws  DaoException{
		String query = null;
		query = " insert into regra_colecao (nome , descricao , retorna_colecao , recebe_colecao , ativo_java , ativo_cpp , ativo_flex , ativo_cs , id_entidade) values ('" + item.getNome() + "' , '" + item.getDescricao() + "' , '" + (item.getRetornaColecao()?'S':'N') + "' , '" + (item.getRecebeColecao()?'S':'N') + "' , '" + (item.getAtivoJava()?'S':'N') + "' , '" + (item.getAtivoCpp()?'S':'N') + "' , '" + (item.getAtivoFlex()?'S':'N') + "' , '" + (item.getAtivoCs()?'S':'N') + "' , '" + item.getIdEntidade() + "')";
		executaSql(query);
	}
	public  void insereItemCompleto( RegraColecao item )  throws  DaoException{
		String query = null;
		query = " insert into regra_colecao (id_regra_colecao , nome , descricao , retorna_colecao , recebe_colecao , ativo_java , ativo_cpp , ativo_flex , ativo_cs , id_entidade) values ('" + item.getIdRegraColecao() + "' , '" + item.getNome() + "' , '" + item.getDescricao() + "' , '" + (item.getRetornaColecao()?'S':'N') + "' , '" + (item.getRecebeColecao()?'S':'N') + "' , '" + (item.getAtivoJava()?'S':'N') + "' , '" + (item.getAtivoCpp()?'S':'N') + "' , '" + (item.getAtivoFlex()?'S':'N') + "' , '" + (item.getAtivoCs()?'S':'N') + "' , '" + item.getIdEntidade() + "')";
		executaSql(query);
	}
	public  boolean insereSeNaoExiste( RegraColecao item )  throws  DaoException{
      RegraColecao teste = this.obtemPorChave(item.getIdRegraColecao());
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
	public  void insereItemLoad( RegraColecao item )  throws  DaoException{
		String query = null;
		query = " insert into regra_colecao (nome , descricao , retorna_colecao , recebe_colecao , ativo_java , ativo_cpp , ativo_flex , ativo_cs , id_entidade) values ('" + item.getNome() + "' , '" + item.getDescricao() + "' , '" + (item.getRetornaColecao()?'S':'N') + "' , '" + (item.getRecebeColecao()?'S':'N') + "' , '" + (item.getAtivoJava()?'S':'N') + "' , '" + (item.getAtivoCpp()?'S':'N') + "' , '" + (item.getAtivoFlex()?'S':'N') + "' , '" + (item.getAtivoCs()?'S':'N') + "' , '" + item.getIdEntidade() + "')";
		executaSql(query);
     long id;
		//id = getValorLong(" SELECT LAST_INSERT_ID() ");
		id = getValorLong(" SELECT MAX(id_regra_colecao) from regra_colecao");
		item.setIdRegraColecao(id);
	}
	public  void alteraItem( RegraColecao item )  throws  DaoException{
		String query = null;
		query = " update regra_colecao set nome = '" + item.getNome() + "'  , descricao = '" + item.getDescricao() + "'  , retorna_colecao = '" + (item.getRetornaColecao()?'S':'N') + "'  , recebe_colecao = '" + (item.getRecebeColecao()?'S':'N') + "'  , ativo_java = '" + (item.getAtivoJava()?'S':'N') + "'  , ativo_cpp = '" + (item.getAtivoCpp()?'S':'N') + "'  , ativo_flex = '" + (item.getAtivoFlex()?'S':'N') + "'  , ativo_cs = '" + (item.getAtivoCs()?'S':'N') + "'  , id_entidade = '" + item.getIdEntidade() + "'   where id_regra_colecao = " + item.getIdRegraColecao();
		executaSql(query);
	}
	public  void excluiItem( RegraColecao item )  throws  DaoException{
		String query = null;
		query = " delete from regra_colecao  where id_regra_colecao = " + item.getIdRegraColecao();
		executaSql(query);
	}
	public  RegraColecao obtemPorChave( long chave )  throws  DaoException{
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_regra_colecao = " + chave;
		return (RegraColecao)getObjeto(query);
	}
// Criar depois no Gerenciador-2005 [Melhoria] um ListaCorrente(conexao)
	public  List ListaCorrente()  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderByLista();;
		return getListaSql(sql);
	}

	public  List ListaFiltroSimples( RegraColecaoFiltro filtro )  throws  DaoException{
      String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
if (where.length() > 0)
		    sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	protected  String WhereFiltro( RegraColecaoFiltro filtro ) {
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
	public  List ListaFiltro( RegraColecaoFiltro filtro )  throws  DaoException{
      String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      String where;
      where = WhereFiltro(filtro) + whereListaConcatenado();
      if (where.length() > 0)
          sql += " where " + where;
      sql += orderByLista();
      this.setMontador( new RegraColecaoMontadorAgrupado());
      return getListaSql(sql);
	}

	public  List ListaCorrenteAgrupada()  throws  DaoException{
     String sql;
     String campos;
     String tabelas;
      campos =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados();
      tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = regra_colecao.id_entidade " ;
      sql = "select " + campos + " from " + tabelas + " " + whereLista() + " " + orderByLista();
      this.setMontador( new RegraColecaoMontadorAgrupado());
      return getListaSql(sql);
	}


	public  List ListaPorEntidade ( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where regra_colecao.id_entidade = " + idItem;
      return getListaSql(sql);
	}



	public   static String joinEntidade () {
      return "entidade.id_entidade = regra_colecao.id_entidade";
	}
	public   static String joinTotal() {
      return "entidade.id_entidade = regra_colecao.id_entidade";
	}
}
