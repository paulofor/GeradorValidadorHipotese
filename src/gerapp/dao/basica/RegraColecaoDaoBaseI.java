package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.*;
import gerapp.regracolecao.filtro.*;

public interface RegraColecaoDaoBaseI
 extends DaoI { 
	public void insereItem( RegraColecao item )  throws  DaoException;
	public void insereItemCompleto( RegraColecao item )  throws  DaoException;
	public boolean insereSeNaoExiste( RegraColecao item )  throws  DaoException;
	public void insereItemLoad( RegraColecao item )  throws  DaoException;
	public void alteraItem( RegraColecao item )  throws  DaoException;
	public void excluiItem( RegraColecao item )  throws  DaoException;
	public RegraColecao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( RegraColecaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( RegraColecaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorEntidade ( long idItem )  throws  DaoException;



}
