package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonArrayParser;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.TelaAppRest;
import loopback.cliente.modelo.TelaWebRest;
import loopback.remoting.adapters.RestContractItem;

public class TelaAppRepositorio extends ModelRepository<TelaAppRest>{

	public TelaAppRepositorio() {
		super("TelaApp", TelaAppRest.class);
	}
	
	public void findByIdAplicacaoGerador(Object id, final ListCallback<TelaAppRest> callback) {
		RestContractItem contrato = new RestContractItem("TelaApps/telasAppPorIdAplicacaoParaGerador","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TelaApp.findByIdAplicacaoGerador");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idAplicacao", id);
		invokeStaticMethod("findByIdAplicacaoGerador", params, new JsonArrayParser<TelaAppRest>(this, callback));
	}
	
	public void findByIdEntidadeGerador(Object id, final ListCallback<TelaAppRest> callback) {
		RestContractItem contrato = new RestContractItem("TelaApps/telasAppPorIdEntidadeParaGerador","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TelaApp.findByIdEntidadeGerador");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEntidade", id);
		invokeStaticMethod("findByIdEntidadeGerador", params, new JsonArrayParser<TelaAppRest>(this, callback));
	}
	
	public void findByIdEntidadeGerador(Object id, final ListCallback<TelaAppRest> callback) {
		RestContractItem contrato = new RestContractItem("TelaApps/telasAppPorIdEntidadeParaGerador","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TelaApp.findByIdEntidadeGerador");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEntidade", id);
		invokeStaticMethod("findByIdEntidadeGerador", params, new JsonArrayParser<TelaAppRest>(this, callback));
	}
}
