package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonArrayParser;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.AtributoEntidadeRest;
import loopback.cliente.modelo.RelacionamentoEntidadeRest;
import loopback.remoting.adapters.RestContractItem;

public class RelacionamentoEntidadeRepositorio extends ModelRepository<RelacionamentoEntidadeRest> {

	
	public RelacionamentoEntidadeRepositorio() {
		super("RelacionamentoEntidade", RelacionamentoEntidadeRest.class);
	}
	
	public void findByIdEntidade(Object id, final ListCallback<RelacionamentoEntidadeRest> callback) {
		RestContractItem contrato = new RestContractItem("relacionamento_entidades/listaCompletaPorEntidade","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RelacionamentoEntidade.findByIdEntidade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEntidade", id);
		invokeStaticMethod("findByIdEntidade", params, new JsonArrayParser<RelacionamentoEntidadeRest>(this, callback));
	}
}
