package gerapp.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.dao.*;
import gerapp.dao.basica.*;


public  class RelacionamentoEntidadeDaoExtendida  extends RelacionamentoEntidadeDaoBase implements RelacionamentoEntidadeDao { 
	
	
	public   static String camposOrdenados2() {
		String camposSaida = null;
		camposSaida = "relacionamento_entidade.id_relacionamento_entidade";
		camposSaida += ", relacionamento_entidade.dependente";
		camposSaida += ", relacionamento_entidade.obrigatorio";
		camposSaida += ", relacionamento_entidade.tipo_apresentacao";
		camposSaida += ", relacionamento_entidade.label_tela";
		camposSaida += ", relacionamento_entidade.editavel";
		camposSaida += ", relacionamento_entidade.nome2";
		camposSaida += ", relacionamento_entidade.nome1";
		camposSaida += ", relacionamento_entidade.qtde_entidade2";
		camposSaida += ", relacionamento_entidade.qtde_entidade1";
		camposSaida += ", relacionamento_entidade.criacao_independente_cpp";
		camposSaida += ", relacionamento_entidade.id_entidade1";
		camposSaida += ", relacionamento_entidade.id_entidade2";
		return camposSaida;
	}
	
	public List ListaPorEntidade1(long idItem) throws DaoException {
		String sql;
		sql = "select "
				+ camposOrdenados2()
				+ " from relacionamento_entidade "
				+ " where relacionamento_entidade.id_entidade1 = " + idItem
				+ " or relacionamento_entidade.id_entidade2 = " + idItem;
		//System.out.println(sql);
		return getListaSql(sql);
	}
}
