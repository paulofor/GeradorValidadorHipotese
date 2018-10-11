package gerapp.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.dao.*;
import gerapp.dao.basica.*;


public  class FiltroColecaoDaoExtendida  extends FiltroColecaoDaoBase implements FiltroColecaoDao {
	
	
	
	public static String camposOrdenados2() {
		String camposSaida = null;
		camposSaida = "filtro_colecao.id_filtro_colecao";
		camposSaida += ", filtro_colecao.nome_campo_filtro";
		camposSaida += ", filtro_colecao.tipo_campo_filtro";
		camposSaida += ", filtro_colecao.id_entidade";
		camposSaida += ", filtro_colecao.id_entidade_tipo";
		return camposSaida;
	}
	
	public List ListaPorEntidade(long idItem) throws DaoException {
		String sql;
		sql = "select "
				+ camposOrdenados2()
				+ " from filtro_colecao where filtro_colecao.id_entidade = "
				+ idItem;
		return getListaSql(sql);
	}
}
