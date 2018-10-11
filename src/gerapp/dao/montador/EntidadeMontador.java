package gerapp.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;


public  class EntidadeMontador   implements MontadorDaoI { 

	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaEntidade();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaEntidade();
		return extraiRegistro(resultadoLista, objeto, pos );
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		Entidade objeto;
		objeto = (Entidade)entrada;
		objeto.setIdEntidade(resultadoLista.getInt(pos++));
		objeto.setNome(resultadoLista.getString(pos++));
		objeto.setAssociativa(resultadoLista.getLogicoConvertido(pos++));
		objeto.setIdAplicacao(resultadoLista.getInt(pos++));
		objeto.setIdAtributoEntidadeI(resultadoLista.getInt(pos++));
		objeto.setIdAtributoEntidadeC(resultadoLista.getInt(pos++));
		return objeto;
	}
	public  int quantidadeCampos() {
		return 6;
	}

}
