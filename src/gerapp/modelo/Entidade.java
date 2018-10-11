package gerapp.modelo;


import br.com.digicom.lib.*;


import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;

public interface Entidade
 extends DCIObjetoDominio,EntidadeAssembledI,EntidadeDerivadaI { 
	public long getIdEntidade();
	public void setIdEntidade( long dado );
	public String getNome();
	public void setNome( String dado );
	public boolean getAssociativa();
	public void setAssociativa( boolean dado );
	public long getIdAplicacao();
	public void setIdAplicacao( long dado );
	public long getIdAtributoEntidadeI();
	public void setIdAtributoEntidadeI( long dado );
	public long getIdAtributoEntidadeC();
	public void setIdAtributoEntidadeC( long dado );
}
