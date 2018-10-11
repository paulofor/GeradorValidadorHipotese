package gerapp.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;


public  class ProcValorMontador   implements MontadorDaoI { 

	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaProcValor();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaProcValor();
		return extraiRegistro(resultadoLista, objeto, pos );
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		ProcValor objeto;
		objeto = (ProcValor)entrada;
		objeto.setIdProcValor(resultadoLista.getInt(pos++));
		objeto.setNome(resultadoLista.getString(pos++));
		objeto.setPossuiTotalizacao(resultadoLista.getLogicoConvertido(pos++));
		objeto.setDescricao(resultadoLista.getString(pos++));
		objeto.setPossuiInt(resultadoLista.getLogicoConvertido(pos++));
		objeto.setPossuiMoeda(resultadoLista.getLogicoConvertido(pos++));
		objeto.setSomaNegativo(resultadoLista.getLogicoConvertido(pos++));
		objeto.setCalculadoDemanda(resultadoLista.getLogicoConvertido(pos++));
		objeto.setTipo(resultadoLista.getString(pos++));
		objeto.setIdEntidadeR(resultadoLista.getInt(pos++));
		return objeto;
	}
	public  int quantidadeCampos() {
		return 10;
	}

}
