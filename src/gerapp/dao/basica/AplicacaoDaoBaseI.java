package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.*;
import gerapp.regracolecao.filtro.*;

public interface AplicacaoDaoBaseI
 extends DaoI { 
	public void insereItem( Aplicacao item )  throws  DaoException;
	public void insereItemCompleto( Aplicacao item )  throws  DaoException;
	public boolean insereSeNaoExiste( Aplicacao item )  throws  DaoException;
	public void insereItemLoad( Aplicacao item )  throws  DaoException;
	public void alteraItem( Aplicacao item )  throws  DaoException;
	public void excluiItem( Aplicacao item )  throws  DaoException;
	public Aplicacao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( AplicacaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( AplicacaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmEntidadeLista ( long idEntidade )  throws  DaoException;

}
