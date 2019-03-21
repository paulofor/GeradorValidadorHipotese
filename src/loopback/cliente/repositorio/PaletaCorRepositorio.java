package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonObjectParser;
import loopback.android.callback.ObjectCallback;
import loopback.cliente.modelo.PaletaCorRest;
import loopback.remoting.adapters.RestContractItem;

public class PaletaCorRepositorio extends ModelRepository<PaletaCorRest>{

		public PaletaCorRepositorio() {
			super("PaletaCor", PaletaCorRest.class);
		}

		public void findByIdAplicacao(Object id, final ObjectCallback<PaletaCorRest> callback) {
			RestContractItem contrato = new RestContractItem("PaletaCors/obtemPorIdAplicacao","GET");
			this.getRestAdapter().getContract().addItem(contrato, "PaletaCor.findByIdAplicacao");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("idAplicacao", id);
			invokeStaticMethod("findByIdAplicacao", params, new JsonObjectParser<PaletaCorRest>(this, callback));
		}
	
}
