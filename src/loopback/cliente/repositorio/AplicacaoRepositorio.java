package loopback.cliente.repositorio;

import loopback.android.ModelRepository;
import loopback.cliente.modelo.AplicacaoRest;

public class AplicacaoRepositorio extends ModelRepository<AplicacaoRest> {
	
	public AplicacaoRepositorio() {
		super("Aplicacao", AplicacaoRest.class);
	}
	

}
