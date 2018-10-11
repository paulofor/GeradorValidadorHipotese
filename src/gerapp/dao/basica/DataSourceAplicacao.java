package gerapp.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceAplicacao extends MySqlDataSource{
	public DataSourceAplicacao() {
		super("jdbc:mysql://mysql.lojadigicom.com.br/lojadigicom30", "lojadigicom30","aspnet007");
	}
	
}
