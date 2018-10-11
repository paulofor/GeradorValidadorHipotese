package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.*;
import gerapp.regracolecao.filtro.*;

public interface AtributoEntidadeDaoBaseI
 extends DaoI { 
	public void insereItem( AtributoEntidade item )  throws  DaoException;
	public void insereItemCompleto( AtributoEntidade item )  throws  DaoException;
	public boolean insereSeNaoExiste( AtributoEntidade item )  throws  DaoException;
	public void insereItemLoad( AtributoEntidade item )  throws  DaoException;
	public void alteraItem( AtributoEntidade item )  throws  DaoException;
	public void excluiItem( AtributoEntidade item )  throws  DaoException;
	public AtributoEntidade obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( AtributoEntidadeFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( AtributoEntidadeFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorEntidade ( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmEntidadeListaIdentificador( long idEntidade )  throws  DaoException;
	public List ListaNaoRelacionadaEmEntidadeListaChave( long idEntidade )  throws  DaoException;

}
