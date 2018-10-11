package gerapp.dao;

import gerapp.dao.basica.AtributoEntidadeDaoBase;
import gerapp.modelo.AtributoEntidade;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;

public class AtributoEntidadeDaoExtendida extends AtributoEntidadeDaoBase
		implements AtributoEntidadeDao {

	public static String camposOrdenados2() {
		String camposSaida = null;
		camposSaida = "atributo_entidade.id_atributo_entidade";
		camposSaida += ", atributo_entidade.nome";
		camposSaida += ", atributo_entidade.tipo";
		camposSaida += ", atributo_entidade.label_tela";
		camposSaida += ", atributo_entidade.editavel";
		camposSaida += ", atributo_entidade.obrigatorio";
		camposSaida += ", atributo_entidade.ordenacao_tela";
		camposSaida += ", atributo_entidade.id_entidade";
		return camposSaida;
	}

	public List ListaPorEntidade(long idItem) throws DaoException {
		String sql;
		sql = "select "
				+ camposOrdenados2()
				+ " from atributo_entidade where atributo_entidade.id_entidade = "
				+ idItem + " order by id_atributo_entidade";
		return getListaSql(sql);
	}

	public AtributoEntidade obtemPorChave(long chave) throws DaoException {
		String query = null;
		query = " select " + camposOrdenados2()
				+ " from atributo_entidade  where id_atributo_entidade = "
				+ chave;
		return (AtributoEntidade) getObjeto(query);
	}
}
