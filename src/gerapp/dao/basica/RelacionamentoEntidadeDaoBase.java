package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.montador.*;
import gerapp.regracolecao.filtro.*;


public  class RelacionamentoEntidadeDaoBase  extends DaoAplicacao implements RelacionamentoEntidadeDaoBaseI { 
      public RelacionamentoEntidadeDaoBase()
      {
          super();
	}
      public RelacionamentoEntidadeDaoBase( DataFonte dataSource )
      {
          super( dataSource );
	}

	protected  String ConsultaJoin() {
     String tabelas;
  tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = relacionamento_entidade.id_entidade_1  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = relacionamento_entidade.id_entidade_2 " ;
  return tabelas;
	}


	protected  String CamposSelectJoin() {
     String select;
  select =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados()+ " , " + EntidadeDaoBase.camposOrdenados();
  return select;
	}

	protected  MontadorDaoI criaMontadorPadrao() {
		return new RelacionamentoEntidadeMontador();
	}
	public   static String camposOrdenados() {
		String camposSaida = null;
		camposSaida = "relacionamento_entidade.id_relacionamento_entidade";
		camposSaida += ", relacionamento_entidade.dependente";
		camposSaida += ", relacionamento_entidade.obrigatorio";
		camposSaida += ", relacionamento_entidade.tipo_apresentacao";
		camposSaida += ", relacionamento_entidade.label_tela";
		camposSaida += ", relacionamento_entidade.editavel";
		camposSaida += ", relacionamento_entidade.nome2";
		camposSaida += ", relacionamento_entidade.nome1";
		camposSaida += ", relacionamento_entidade.qtde_entidade2";
		camposSaida += ", relacionamento_entidade.qtde_entidade1";
		camposSaida += ", relacionamento_entidade.criacao_independente_cpp";
		camposSaida += ", relacionamento_entidade.id_entidade_1";
		camposSaida += ", relacionamento_entidade.id_entidade_2";
		return camposSaida;
	}
	public   static String camposOrdenadosAlias( String nomeTabela ) {
		String camposSaida = null;
		camposSaida = " ";
		camposSaida += nomeTabela;
		camposSaida += ".id_relacionamento_entidade";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".dependente";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".obrigatorio";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".tipo_apresentacao";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".label_tela";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".editavel";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome2";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".nome1";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".qtde_entidade2";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".qtde_entidade1";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".criacao_independente_cpp";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade_1";
		camposSaida += ", ";
		camposSaida += nomeTabela;
		camposSaida += ".id_entidade_2";
		return camposSaida;
	}
	public   static String tabelaSelect() {
		return " relacionamento_entidade" ;
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
	public  void insereItem( RelacionamentoEntidade item )  throws  DaoException{
		String query = null;
		query = " insert into relacionamento_entidade (dependente , obrigatorio , tipo_apresentacao , label_tela , editavel , nome2 , nome1 , qtde_entidade2 , qtde_entidade1 , criacao_independente_cpp , id_entidade_1 , id_entidade_2) values ('" + (item.getDependente()?'S':'N') + "' , '" + (item.getObrigatorio()?'S':'N') + "' , '" + item.getTipoApresentacao() + "' , '" + item.getLabelTela() + "' , '" + (item.getEditavel()?'S':'N') + "' , '" + item.getNome2() + "' , '" + item.getNome1() + "' , '" + item.getQtdeEntidade2() + "' , '" + item.getQtdeEntidade1() + "' , '" + (item.getCriacaoIndependenteCpp()?'S':'N') + "' , '" + item.getIdEntidade1() + "' , '" + item.getIdEntidade2() + "')";
		executaSql(query);
	}
	public  void insereItemCompleto( RelacionamentoEntidade item )  throws  DaoException{
		String query = null;
		query = " insert into relacionamento_entidade (id_relacionamento_entidade , dependente , obrigatorio , tipo_apresentacao , label_tela , editavel , nome2 , nome1 , qtde_entidade2 , qtde_entidade1 , criacao_independente_cpp , id_entidade_1 , id_entidade_2) values ('" + item.getIdRelacionamentoEntidade() + "' , '" + (item.getDependente()?'S':'N') + "' , '" + (item.getObrigatorio()?'S':'N') + "' , '" + item.getTipoApresentacao() + "' , '" + item.getLabelTela() + "' , '" + (item.getEditavel()?'S':'N') + "' , '" + item.getNome2() + "' , '" + item.getNome1() + "' , '" + item.getQtdeEntidade2() + "' , '" + item.getQtdeEntidade1() + "' , '" + (item.getCriacaoIndependenteCpp()?'S':'N') + "' , '" + item.getIdEntidade1() + "' , '" + item.getIdEntidade2() + "')";
		executaSql(query);
	}
	public  boolean insereSeNaoExiste( RelacionamentoEntidade item )  throws  DaoException{
      RelacionamentoEntidade teste = this.obtemPorChave(item.getIdRelacionamentoEntidade());
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
	public  void insereItemLoad( RelacionamentoEntidade item )  throws  DaoException{
		String query = null;
		query = " insert into relacionamento_entidade (dependente , obrigatorio , tipo_apresentacao , label_tela , editavel , nome2 , nome1 , qtde_entidade2 , qtde_entidade1 , criacao_independente_cpp , id_entidade_1 , id_entidade_2) values ('" + (item.getDependente()?'S':'N') + "' , '" + (item.getObrigatorio()?'S':'N') + "' , '" + item.getTipoApresentacao() + "' , '" + item.getLabelTela() + "' , '" + (item.getEditavel()?'S':'N') + "' , '" + item.getNome2() + "' , '" + item.getNome1() + "' , '" + item.getQtdeEntidade2() + "' , '" + item.getQtdeEntidade1() + "' , '" + (item.getCriacaoIndependenteCpp()?'S':'N') + "' , '" + item.getIdEntidade1() + "' , '" + item.getIdEntidade2() + "')";
		executaSql(query);
     long id;
		//id = getValorLong(" SELECT LAST_INSERT_ID() ");
		id = getValorLong(" SELECT MAX(id_relacionamento_entidade) from relacionamento_entidade");
		item.setIdRelacionamentoEntidade(id);
	}
	public  void alteraItem( RelacionamentoEntidade item )  throws  DaoException{
		String query = null;
		query = " update relacionamento_entidade set dependente = '" + (item.getDependente()?'S':'N') + "'  , obrigatorio = '" + (item.getObrigatorio()?'S':'N') + "'  , tipo_apresentacao = '" + item.getTipoApresentacao() + "'  , label_tela = '" + item.getLabelTela() + "'  , editavel = '" + (item.getEditavel()?'S':'N') + "'  , nome2 = '" + item.getNome2() + "'  , nome1 = '" + item.getNome1() + "'  , qtde_entidade2 = '" + item.getQtdeEntidade2() + "'  , qtde_entidade1 = '" + item.getQtdeEntidade1() + "'  , criacao_independente_cpp = '" + (item.getCriacaoIndependenteCpp()?'S':'N') + "'  , id_entidade_1 = '" + item.getIdEntidade1() + "'  , id_entidade_2 = '" + item.getIdEntidade2() + "'   where id_relacionamento_entidade = " + item.getIdRelacionamentoEntidade();
		executaSql(query);
	}
	public  void excluiItem( RelacionamentoEntidade item )  throws  DaoException{
		String query = null;
		query = " delete from relacionamento_entidade  where id_relacionamento_entidade = " + item.getIdRelacionamentoEntidade();
		executaSql(query);
	}
	public  RelacionamentoEntidade obtemPorChave( long chave )  throws  DaoException{
		String query = null;
		query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_relacionamento_entidade = " + chave;
		return (RelacionamentoEntidade)getObjeto(query);
	}
// Criar depois no Gerenciador-2005 [Melhoria] um ListaCorrente(conexao)
	public  List ListaCorrente()  throws  DaoException{
     String sql;
		sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderByLista();;
		return getListaSql(sql);
	}

	public  List ListaFiltroSimples( RelacionamentoEntidadeFiltro filtro )  throws  DaoException{
      String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
if (where.length() > 0)
		    sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	protected  String WhereFiltro( RelacionamentoEntidadeFiltro filtro ) {
     String saida = "";
      boolean primeiro;
      primeiro = true;
      if (filtro.getCodigoEntidade1() != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_entidade_1 = " + filtro.getCodigoEntidade1();
      }
      if (filtro.getCodigoEntidade2() != -1)
      {
          if (!primeiro) saida += " and ";
          else primeiro = false;
          saida += " " + tabelaSelect() + ".id_entidade_2 = " + filtro.getCodigoEntidade2();
      }
      return saida;
	}
	public  List ListaFiltro( RelacionamentoEntidadeFiltro filtro )  throws  DaoException{
      String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      String where;
      where = WhereFiltro(filtro) + whereListaConcatenado();
      if (where.length() > 0)
          sql += " where " + where;
      sql += orderByLista();
      this.setMontador( new RelacionamentoEntidadeMontadorAgrupado());
      return getListaSql(sql);
	}

	public  List ListaCorrenteAgrupada()  throws  DaoException{
     String sql;
     String campos;
     String tabelas;
      campos =  camposOrdenados() + " , " + EntidadeDaoBase.camposOrdenados()+ " , " + EntidadeDaoBase.camposOrdenados();
      tabelas =  tabelaSelect()  + "  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = relacionamento_entidade.id_entidade_1  LEFT OUTER JOIN  " + EntidadeDaoBase.tabelaSelect() + " ON entidade.id_entidade = relacionamento_entidade.id_entidade_2 " ;
      sql = "select " + campos + " from " + tabelas + " " + whereLista() + " " + orderByLista();
      this.setMontador( new RelacionamentoEntidadeMontadorAgrupado());
      return getListaSql(sql);
	}


	public  List ListaPorEntidade1( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where relacionamento_entidade.id_entidade_1 = " + idItem;
      return getListaSql(sql);
	}
	public  List ListaPorEntidade2( long idItem )  throws  DaoException{
     String sql;
      sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + " where relacionamento_entidade.id_entidade_2 = " + idItem;
      return getListaSql(sql);
	}



	public   static String joinEntidade1() {
      return "entidade.id_entidade = relacionamento_entidade.id_entidade_1";
	}
	public   static String joinEntidade2() {
      return "entidade.id_entidade = relacionamento_entidade.id_entidade_2";
	}
	public   static String joinTotal() {
      return "entidade.id_entidade = relacionamento_entidade.id_entidade_1 and entidade.id_entidade = relacionamento_entidade.id_entidade_2";
	}
}
