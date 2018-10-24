package loopback.cliente.repositorio;

import java.util.HashMap;
import java.util.Map;

import loopback.android.ModelRepository;
import loopback.android.callback.JsonArrayParser;
import loopback.android.callback.ListCallback;
import loopback.cliente.modelo.AplicacaoRest;
import loopback.cliente.modelo.EntidadeRest;

public class AplicacaoRepositorio extends ModelRepository<AplicacaoRest> {
	
	public AplicacaoRepositorio() {
		super("Aplicacao", AplicacaoRest.class);
	}
	
	

}
