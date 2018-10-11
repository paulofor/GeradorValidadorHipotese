package gerapp.modelo;


import br.com.digicom.lib.*;


import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;

public interface AtributoEntidade
 extends DCIObjetoDominio,AtributoEntidadeAssembledI,AtributoEntidadeDerivadaI { 
	public long getIdAtributoEntidade();
	public void setIdAtributoEntidade( long dado );
	public String getNome();
	public void setNome( String dado );
	public String getTipo();
	public void setTipo( String dado );
	public String getLabelTela();
	public void setLabelTela( String dado );
	public boolean getEditavel();
	public void setEditavel( boolean dado );
	public boolean getObrigatorio();
	public void setObrigatorio( boolean dado );
	public long getOrdenacaoTela();
	public void setOrdenacaoTela( long dado );
	public long getIdEntidade();
	public void setIdEntidade( long dado );
}
