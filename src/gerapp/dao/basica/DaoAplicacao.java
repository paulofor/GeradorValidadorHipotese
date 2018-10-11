package gerapp.dao.basica;

import br.com.digicom.lib.dao.DaoBase;
import br.com.digicom.lib.dao.DataFonte;

public abstract class DaoAplicacao extends DaoBase {

	public DaoAplicacao() {
		super(new DataSourceAplicacao()); 
	}

	public DaoAplicacao(DataFonte ds){
		super(ds);
	}

}
