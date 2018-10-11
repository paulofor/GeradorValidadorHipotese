package gerapp.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.dao.*;
import gerapp.dao.basica.*;


public  class ProcValorDaoExtendida  extends ProcValorDaoBase implements ProcValorDao {
	
	
	public   static String camposOrdenados2() {
		String camposSaida = null;
		camposSaida = "proc_valor.id_proc_valor";
		camposSaida += ", proc_valor.nome";
		camposSaida += ", proc_valor.possui_totalizacao";
		camposSaida += ", proc_valor.descricao";
		camposSaida += ", proc_valor.possui_int";
		camposSaida += ", proc_valor.possui_moeda";
		camposSaida += ", proc_valor.soma_negativo";
		camposSaida += ", proc_valor.calculado_demanda";
		camposSaida += ", proc_valor.tipo";
		camposSaida += ", proc_valor.id_entidade";
		return camposSaida;
	}
	
	public List ListaPorEntidadeRelacionada(long idItem) throws DaoException {
		String sql;
		sql = "select "
				+ camposOrdenados2()
				+ " from proc_valor where proc_valor.id_entidade = "
				+ idItem;
		return getListaSql(sql);
	}
}
