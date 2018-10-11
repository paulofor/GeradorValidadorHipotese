package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.*;
import gerapp.regracolecao.filtro.*;

public interface EntidadeDaoBaseI
 extends DaoI { 
	public void insereItem( Entidade item )  throws  DaoException;
	public void insereItemCompleto( Entidade item )  throws  DaoException;
	public boolean insereSeNaoExiste( Entidade item )  throws  DaoException;
	public void insereItemLoad( Entidade item )  throws  DaoException;
	public void alteraItem( Entidade item )  throws  DaoException;
	public void excluiItem( Entidade item )  throws  DaoException;
	public Entidade obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( EntidadeFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( EntidadeFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorAplicacao ( long idItem )  throws  DaoException;
	public List ListaPorAtributoEntidadeIdentificador( long idItem )  throws  DaoException;
	public List ListaPorAtributoEntidadeChave( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmAtributoEntidadeLista ( long idAtributoEntidade )  throws  DaoException;
	public List ListaNaoRelacionadaEmFiltroColecaoLista ( long idFiltroColecao )  throws  DaoException;
	public List ListaNaoRelacionadaEmFiltroColecaoListaTipo( long idFiltroColecao )  throws  DaoException;
	public List ListaNaoRelacionadaEmRegraColecaoLista ( long idRegraColecao )  throws  DaoException;
	public List ListaNaoRelacionadaEmRelacionamentoEntidadeLista1( long idRelacionamentoEntidade )  throws  DaoException;
	public List ListaNaoRelacionadaEmRelacionamentoEntidadeLista2( long idRelacionamentoEntidade )  throws  DaoException;
	public List ListaNaoRelacionadaEmProcValorListaRelacionada( long idProcValor )  throws  DaoException;

}
