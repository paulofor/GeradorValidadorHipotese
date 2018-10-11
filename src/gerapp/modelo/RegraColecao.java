package gerapp.modelo;


import br.com.digicom.lib.*;


import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;

public interface RegraColecao
 extends DCIObjetoDominio,RegraColecaoAssembledI,RegraColecaoDerivadaI { 
	public long getIdRegraColecao();
	public void setIdRegraColecao( long dado );
	public String getNome();
	public void setNome( String dado );
	public String getDescricao();
	public void setDescricao( String dado );
	public boolean getRetornaColecao();
	public void setRetornaColecao( boolean dado );
	public boolean getRecebeColecao();
	public void setRecebeColecao( boolean dado );
	public boolean getAtivoJava();
	public void setAtivoJava( boolean dado );
	public boolean getAtivoCpp();
	public void setAtivoCpp( boolean dado );
	public boolean getAtivoFlex();
	public void setAtivoFlex( boolean dado );
	public boolean getAtivoCs();
	public void setAtivoCs( boolean dado );
	public long getIdEntidade();
	public void setIdEntidade( long dado );
	public String getNomeParaConstante();
}
