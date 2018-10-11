package gerapp.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.dao.*;
import gerapp.dao.basica.*;


public  class RegraColecaoDaoExtendida  extends RegraColecaoDaoBase implements RegraColecaoDao {
	
	
	public   static String camposOrdenados2() {
		String camposSaida = null;
		camposSaida = "regra_colecao.id_regra_colecao";
		camposSaida += ", regra_colecao.nome";
		camposSaida += ", regra_colecao.descricao";
		camposSaida += ", regra_colecao.retorna_colecao";
		camposSaida += ", regra_colecao.recebe_colecao";
		camposSaida += ", regra_colecao.ativo_java";
		camposSaida += ", regra_colecao.ativo_cpp";
		camposSaida += ", regra_colecao.ativo_flex";
		camposSaida += ", regra_colecao.ativo_cs";
		camposSaida += ", regra_colecao.id_entidade";
		return camposSaida;
	}
	
	public List ListaPorEntidade(long idItem) throws DaoException {
		String sql;
		sql = "select "
				+ camposOrdenados()
				+ " from regra_colecao where regra_colecao.id_entidade = "
				+ idItem;
		return getListaSql(sql);
	}
}
