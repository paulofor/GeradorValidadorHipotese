package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonArrayParser;
import loopback.android.callback.JsonObjectParser;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.EntidadeRest;

public class EntidadeRepositorio  extends ModelRepository<EntidadeRest> {

	public EntidadeRepositorio(String className) {
		super("Entidade", EntidadeRest.class);
	}

	public void findByIdAplicacao(Object id, final ListCallback<EntidadeRest> callback) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		invokeStaticMethod("all", null, new JsonArrayParser<EntidadeRest>(this, callback));
	}
}
