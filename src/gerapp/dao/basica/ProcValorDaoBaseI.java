package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.*;
import gerapp.regracolecao.filtro.*;

public interface ProcValorDaoBaseI
 extends DaoI { 
	public void insereItem( ProcValor item )  throws  DaoException;
	public void insereItemCompleto( ProcValor item )  throws  DaoException;
	public boolean insereSeNaoExiste( ProcValor item )  throws  DaoException;
	public void insereItemLoad( ProcValor item )  throws  DaoException;
	public void alteraItem( ProcValor item )  throws  DaoException;
	public void excluiItem( ProcValor item )  throws  DaoException;
	public ProcValor obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ProcValorFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ProcValorFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorEntidadeRelacionada( long idItem )  throws  DaoException;



}
