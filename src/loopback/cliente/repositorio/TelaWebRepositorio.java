package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonArrayParser;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.EntidadeRest;
import loopback.cliente.modelo.RelacionamentoEntidadeRest;
import loopback.cliente.modelo.TelaWebRest;
import loopback.remoting.adapters.RestContractItem;

public class TelaWebRepositorio extends ModelRepository<TelaWebRest>{

	public TelaWebRepositorio() {
		super("TelaWeb", TelaWebRest.class);
	}
	
	public void findByIdAplicacao(Object id, final ListCallback<TelaWebRest> callback) {
		RestContractItem contrato = new RestContractItem("aplicacaos/:id/telaWebs","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TelaWeb.findByIdAplicacao");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		invokeStaticMethod("findByIdAplicacao", params, new JsonArrayParser<TelaWebRest>(this, callback));
	}
	
	public void findByIdAplicacaoGerador(Object id, final ListCallback<TelaWebRest> callback) {
		RestContractItem contrato = new RestContractItem("TelaWebs/telasWebPorIdAplicacaoParaGerador","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TelaWeb.findByIdAplicacaoGerador");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idAplicacao", id);
		invokeStaticMethod("findByIdAplicacaoGerador", params, new JsonArrayParser<TelaWebRest>(this, callback));
	}

}
