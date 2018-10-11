package gerapp.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;


public  class RelacionamentoEntidadeMontadorAgrupado   implements MontadorDaoI { 

	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaRelacionamentoEntidade();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaRelacionamentoEntidade();
		return extraiRegistro(resultadoLista, objeto, pos );
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		RelacionamentoEntidade objeto;
		objeto = (RelacionamentoEntidade)entrada;
		objeto.setIdRelacionamentoEntidade(resultadoLista.getInt(pos++));
		objeto.setDependente(resultadoLista.getLogicoConvertido(pos++));
		objeto.setObrigatorio(resultadoLista.getLogicoConvertido(pos++));
		objeto.setTipoApresentacao(resultadoLista.getString(pos++));
		objeto.setLabelTela(resultadoLista.getString(pos++));
		objeto.setEditavel(resultadoLista.getLogicoConvertido(pos++));
		objeto.setNome2(resultadoLista.getString(pos++));
		objeto.setNome1(resultadoLista.getString(pos++));
		objeto.setQtdeEntidade2(resultadoLista.getString(pos++));
		objeto.setQtdeEntidade1(resultadoLista.getString(pos++));
		objeto.setCriacaoIndependenteCpp(resultadoLista.getLogicoConvertido(pos++));
		objeto.setIdEntidade1(resultadoLista.getInt(pos++));
		objeto.setIdEntidade2(resultadoLista.getInt(pos++));
     MontadorDaoI montadorAgrupamento;
		montadorAgrupamento =  new EntidadeMontador();
		objeto.setEntidade1((Entidade)montadorAgrupamento.extraiRegistro(resultadoLista,pos));
		pos += montadorAgrupamento.quantidadeCampos();
		montadorAgrupamento =  new EntidadeMontador();
		objeto.setEntidade2((Entidade)montadorAgrupamento.extraiRegistro(resultadoLista,pos));
		pos += montadorAgrupamento.quantidadeCampos();
		return objeto;
	}
	public  int quantidadeCampos() {
     int conta;
		conta = 13;
     MontadorDaoI montadorAgrupamento;
		montadorAgrupamento =  new EntidadeMontador();
		conta += montadorAgrupamento.quantidadeCampos();
		montadorAgrupamento =  new EntidadeMontador();
		conta += montadorAgrupamento.quantidadeCampos();
		return conta;
	}

}
