package gerapp.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;


public  class FiltroColecaoMontador   implements MontadorDaoI { 

	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaFiltroColecao();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaFiltroColecao();
		return extraiRegistro(resultadoLista, objeto, pos );
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		FiltroColecao objeto;
		objeto = (FiltroColecao)entrada;
		objeto.setIdFiltroColecao(resultadoLista.getInt(pos++));
		objeto.setNomeCampoFiltro(resultadoLista.getString(pos++));
		objeto.setTipoCampoFiltro(resultadoLista.getString(pos++));
		objeto.setIdEntidade(resultadoLista.getInt(pos++));
		objeto.setIdEntidadeT(resultadoLista.getInt(pos++));
		return objeto;
	}
	public  int quantidadeCampos() {
		return 5;
	}

}
