package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonArrayParser;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.AtributoEntidadeRest;
import loopback.cliente.modelo.EntidadeRest;
import loopback.remoting.adapters.RestContractItem;

public class AtributoEntidadeRepositorio  extends ModelRepository<AtributoEntidadeRest> {
	

	
	public AtributoEntidadeRepositorio() {
		super("AtributoEntidade", AtributoEntidadeRest.class);
	}
	
	public void findByIdEntidade(Object id, final ListCallback<AtributoEntidadeRest> callback) {
		RestContractItem contrato = new RestContractItem("entidades/:id/atributoEntidades","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AtributoEntidade.findByIdEntidade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		invokeStaticMethod("findByIdEntidade", params, new JsonArrayParser<AtributoEntidadeRest>(this, callback));
	}
	

}
