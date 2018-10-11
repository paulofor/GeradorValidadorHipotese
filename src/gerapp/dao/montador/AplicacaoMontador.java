package gerapp.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;


public  class AplicacaoMontador   implements MontadorDaoI { 

	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaAplicacao();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaAplicacao();
		return extraiRegistro(resultadoLista, objeto, pos );
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		Aplicacao objeto;
		objeto = (Aplicacao)entrada;
		objeto.setIdAplicacao(resultadoLista.getInt(pos++));
		objeto.setNome(resultadoLista.getString(pos++));
		objeto.setNamespace(resultadoLista.getString(pos++));
		objeto.setDiretorioJava(resultadoLista.getString(pos++));
		objeto.setDiretorioFlex(resultadoLista.getString(pos++));
		objeto.setDiretorio(resultadoLista.getString(pos++));
		objeto.setBancoDados(resultadoLista.getString(pos++));
		objeto.setVersaoVs(resultadoLista.getString(pos++));
		objeto.setUrl(resultadoLista.getString(pos++));
		objeto.setDiretorioCpp(resultadoLista.getString(pos++));
		return objeto;
	}
	public  int quantidadeCampos() {
		return 10;
	}

}
