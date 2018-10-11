package gerapp.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;
import gerapp.dao.*;
import gerapp.regracolecao.filtro.*;

public interface RelacionamentoEntidadeDaoBaseI
 extends DaoI { 
	public void insereItem( RelacionamentoEntidade item )  throws  DaoException;
	public void insereItemCompleto( RelacionamentoEntidade item )  throws  DaoException;
	public boolean insereSeNaoExiste( RelacionamentoEntidade item )  throws  DaoException;
	public void insereItemLoad( RelacionamentoEntidade item )  throws  DaoException;
	public void alteraItem( RelacionamentoEntidade item )  throws  DaoException;
	public void excluiItem( RelacionamentoEntidade item )  throws  DaoException;
	public RelacionamentoEntidade obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( RelacionamentoEntidadeFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( RelacionamentoEntidadeFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorEntidade1( long idItem )  throws  DaoException;
	public List ListaPorEntidade2( long idItem )  throws  DaoException;



}
