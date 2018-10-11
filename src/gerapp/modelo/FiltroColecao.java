package gerapp.modelo;


import br.com.digicom.lib.*;


import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;

public interface FiltroColecao
 extends DCIObjetoDominio,FiltroColecaoAssembledI,FiltroColecaoDerivadaI { 
	public long getIdFiltroColecao();
	public void setIdFiltroColecao( long dado );
	public String getNomeCampoFiltro();
	public void setNomeCampoFiltro( String dado );
	public String getTipoCampoFiltro();
	public void setTipoCampoFiltro( String dado );
	public long getIdEntidade();
	public void setIdEntidade( long dado );
	public long getIdEntidadeT();
	public void setIdEntidadeT( long dado );
}
