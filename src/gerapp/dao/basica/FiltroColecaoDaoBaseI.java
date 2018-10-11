package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.*;
import gerapp.regracolecao.filtro.*;

public interface FiltroColecaoDaoBaseI
 extends DaoI { 
	public void insereItem( FiltroColecao item )  throws  DaoException;
	public void insereItemCompleto( FiltroColecao item )  throws  DaoException;
	public boolean insereSeNaoExiste( FiltroColecao item )  throws  DaoException;
	public void insereItemLoad( FiltroColecao item )  throws  DaoException;
	public void alteraItem( FiltroColecao item )  throws  DaoException;
	public void excluiItem( FiltroColecao item )  throws  DaoException;
	public FiltroColecao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( FiltroColecaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( FiltroColecaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorEntidade ( long idItem )  throws  DaoException;
	public List ListaPorEntidadeTipo( long idItem )  throws  DaoException;



}
