package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.montador.*;
import gerapp.regracolecao.filtro.*;


public  class AplicacaoDaoBase  extends DaoAplicacao implements AplicacaoDaoBaseI { 
      public AplicacaoDaoBase()
      {
          super();
	}
      public AplicacaoDaoBase( DataFonte dataSource )
      {
          super( dataSource );
	}

	protected  String ConsultaJoin() {
     String tabelas;
  tabelas =  tabelaSelect() ;
  return tabelas;
	}


	protected  String CamposSelectJoin() {
     String select;
  select =  camposOrdenados() ;
  return select;
	}

	protected  MontadorDaoI criaMontadorPadrao() {
		return new AplicacaoMontador();
	}
	public   static String camposOrdenados() {
		String camposSaida = null;
		camposSaida = "aplicacao.id_aplicacao";
		camposSaida += ", aplicacao.nome";
		camposSaida += ", aplicacao.namespace";
		camposSaida += ", aplicacao.diretorio_java";
		camposSaida += ", aplicacao.diretorio_flex";
		camposSaida += ", aplicacao.diretorio";
		camposSaida += ", aplicacao.banco_dados";
		camposSaida += ", aplicacao.versao_vs";
		camposSaida += ", aplicacao.url";
		camposSaida += ", aplicacao.diretorio_cpp";
		return camposSaida;
	}
	public   static String camposOrdenadosAlias( String nomeTabela ) {
		String camposSaida = null;
		camposSaida = " ";
		camposSaida += nomeTabela;
		camposSaida += ".id_aplicacao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".namespace";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".diretorio_java";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".diretorio_flex";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".diretorio";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".banco_dados";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".versao_vs";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".url";
		return camposSaida;
	}
	public   static String tabelaSelect() {
		return " aplicacao" ;
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
	public  void insereItem( Aplicacao item )  throws  DaoException{
		String query = null;
		query = " insert into aplicacao (nome , namespace , diretorio_java , diretorio_flex , diretorio , banco_dados , versao_vs , url) values ('" + item.getNome() + "' , '" + item.getNamespace() + "' , '" + item.getDiretorioJava() + "' , '" + item.getDiretorioFlex() + "' , '" + item.getDiretorio() + "' , '" + item.getBancoDados() + "' , '" + item.getVersaoVs() + "' , '" + item.getUrl() + "')";
		executaSql(query);
	}
	public  void insereItemCompleto( Aplicacao item )  throws  DaoException{
		String query = null;
		query = " insert into aplicacao (id_aplicacao , nome , namespace , diretorio_java , diretorio_flex , diretorio , banco_dados , versao_vs , url) values ('" + item.getIdAplicacao() + "' , '" + item.getNome() + "' , '" + item.getNamespace() + "' , '" + item.getDiretorioJava() + "' , '" + item.getDiretorioFlex() + "' , '" + item.getDiretorio() + "' , '" + item.getBancoDados() + "' , '" + item.getVersaoVs() + "' , '" + item.getUrl() + "')";
		executaSql(query);
	}
	public  boolean insereSeNaoExiste( Aplicacao item )  throws  DaoException{
      Aplicacao teste = this.obtemPorChave(item.getIdAplicacao());
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
	public  void insereItemLoad( Aplicacao item )  throws  DaoException{
		String query = null;
		query = " insert into aplicacao (nome , namespace , diretorio_java , diretorio_flex , diretorio , banco_dados , versao_vs , url) values ('" + item.getNome() + "' , '" + item.getNamespace() + "' , '" + item.getDiretorioJava() + "' , '" + item.getDiretorioFlex() + "' , '" + item.getDiretorio() + "' , '" + item.getBancoDados() + "' , '" + item.getVersaoVs() + "' , '" + item.getUrl() + "')";
		executaSql(query);
     long id;
		//id = getValorLong(" SELECT LAST_INSERT_ID() ");
		id = getValorLong(" SELECT MAX(id_aplicacao) from aplicacao");
		item.setIdAplicacao(id);
	}
	public  void alteraItem( Aplicacao item )  throws  DaoException{
		String query = null;
		query = " update aplicacao set nome = '" + item.getNome() + "'  , namespace = '" + item.getNamespace() + "'  , diretorio_java = '" + item.getDiretorioJava() + "'  , diretorio_flex = '" + item.getDiretorioFlex() + "'  , diretorio = '" + item.getDiretorio() + "'  , banco_dados = '" + item.getBancoDados() + "'  , versao_vs = '" + item.getVersaoVs() + "'  , url = '" + item.getUrl() + "'   where id_aplicacao = " + item.getIdAplicacao();
		executaSql(query);
	}
	public  void excluiItem( Aplicacao item )  throws  DaoException{
		String query = null;
		query = " delete from aplicacao  where id_aplicacao = " + item.getIdAplicacao();
		executaSql(query);
	}
	public  Aplicacao obtemPorChave( long chave )  throws  DaoException{
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_aplicacao = " + chave;
		return (Aplicacao)getObjeto(query);
	}
// Criar depois no Gerenciador-2005 [Melhoria] um ListaCorrente(conexao)
	public  List ListaCorrente()  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderByLista();;
		return getListaSql(sql);
	}

	public  List ListaFiltroSimples( AplicacaoFiltro filtro )  throws  DaoException{
      String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
if (where.length() > 0)
		    sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	protected  String WhereFiltro( AplicacaoFiltro filtro ) {
     String saida = "";
      boolean primeiro;
      primeiro = true;
      return saida;
	}
	public  List ListaFiltro( AplicacaoFiltro filtro )  throws  DaoException{
      String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      String where;
      where = WhereFiltro(filtro) + whereListaConcatenado();
      if (where.length() > 0)
          sql += " where " + where;
      sql += orderByLista();
      return getListaSql(sql);
	}



	public  List ListaNaoRelacionadaEmEntidadeLista ( long idEntidade )  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();;
		return getListaSql(sql);
	}

	public   static String joinTotal() {
      return "";
	}
}
