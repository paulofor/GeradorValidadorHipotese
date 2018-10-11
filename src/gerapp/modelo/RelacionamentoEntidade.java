package gerapp.modelo;


import br.com.digicom.lib.*;


import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;

public interface RelacionamentoEntidade
 extends DCIObjetoDominio,RelacionamentoEntidadeAssembledI,RelacionamentoEntidadeDerivadaI { 
	public long getIdRelacionamentoEntidade();
	public void setIdRelacionamentoEntidade( long dado );
	public boolean getDependente();
	public void setDependente( boolean dado );
	public boolean getObrigatorio();
	public void setObrigatorio( boolean dado );
	public String getTipoApresentacao();
	public void setTipoApresentacao( String dado );
	public String getLabelTela();
	public void setLabelTela( String dado );
	public boolean getEditavel();
	public void setEditavel( boolean dado );
	public String getNome2();
	public void setNome2( String dado );
	public String getNome1();
	public void setNome1( String dado );
	public String getQtdeEntidade2();
	public void setQtdeEntidade2( String dado );
	public String getQtdeEntidade1();
	public void setQtdeEntidade1( String dado );
	public boolean getCriacaoIndependenteCpp();
	public void setCriacaoIndependenteCpp( boolean dado );
	public long getIdEntidade1();
	public void setIdEntidade1( long dado );
	public long getIdEntidade2();
	public void setIdEntidade2( long dado );
}
