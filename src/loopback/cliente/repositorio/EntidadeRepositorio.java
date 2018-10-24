package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonArrayParser;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.EntidadeRest;
import loopback.remoting.adapters.RestContractItem;

public class EntidadeRepositorio  extends ModelRepository<EntidadeRest> {

	public EntidadeRepositorio() {
		super("Entidade", EntidadeRest.class);
	}

	public void findByIdAplicacao(Object id, final ListCallback<EntidadeRest> callback) {
		RestContractItem contrato = new RestContractItem("aplicacaos/:id/entidades","GET");
		this.getRestAdapter().getContract().addItem(contrato, "Entidade.findByIdAplicacao");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		invokeStaticMethod("findByIdAplicacao", params, new JsonArrayParser<EntidadeRest>(this, callback));
	}
}
