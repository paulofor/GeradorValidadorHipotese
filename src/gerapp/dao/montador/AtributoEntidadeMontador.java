package gerapp.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;


public  class AtributoEntidadeMontador   implements MontadorDaoI { 

	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaAtributoEntidade();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaAtributoEntidade();
		return extraiRegistro(resultadoLista, objeto, pos );
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		AtributoEntidade objeto;
		objeto = (AtributoEntidade)entrada;
		objeto.setIdAtributoEntidade(resultadoLista.getInt(pos++));
		objeto.setNome(resultadoLista.getString(pos++));
		objeto.setTipo(resultadoLista.getString(pos++));
		objeto.setLabelTela(resultadoLista.getString(pos++));
		objeto.setEditavel(resultadoLista.getLogicoConvertido(pos++));
		objeto.setObrigatorio(resultadoLista.getLogicoConvertido(pos++));
		objeto.setOrdenacaoTela(resultadoLista.getInt(pos++));
		objeto.setIdEntidade(resultadoLista.getInt(pos++));
		return objeto;
	}
	public  int quantidadeCampos() {
		return 8;
	}

}
