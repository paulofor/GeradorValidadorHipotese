package gerapp.dao;

import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;

import gerapp.dao.*;
import gerapp.dao.basica.*;

public class EntidadeDaoExtendida extends EntidadeDaoBase implements
		EntidadeDao {

	
	public   static String camposOrdenados2() {
		String camposSaida = null;
		camposSaida = "entidade.id_entidade";
		camposSaida += ", entidade.nome";
		camposSaida += ", entidade.associativa";
		camposSaida += ", entidade.id_aplicacao";
		camposSaida += ", entidade.id_atributo_identificador";
		camposSaida += ", entidade.id_chave";
		return camposSaida;
	}
	public List ListaPorAplicacao(long idItem) throws DaoException {
		String sql;
		sql = "select " + camposOrdenados2()
				+ " from entidade where entidade.id_aplicacao = " + idItem;
		return getListaSql(sql);
	}
}
