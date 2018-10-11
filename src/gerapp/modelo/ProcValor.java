package gerapp.modelo;


import gerapp.modelo.agregados.ProcValorAssembledI;
import gerapp.modelo.derivadas.ProcValorDerivadaI;
import jet.wrappers.base.AtributoTotalI;
import br.com.digicom.lib.DCIObjetoDominio;

public interface ProcValor
 extends DCIObjetoDominio,ProcValorAssembledI,ProcValorDerivadaI { 
	public long getIdProcValor();
	public void setIdProcValor( long dado );
	public String getNome();
	public void setNome( String dado );
	public boolean getPossuiTotalizacao();
	public void setPossuiTotalizacao( boolean dado );
	public String getDescricao();
	public void setDescricao( String dado );
	public boolean getPossuiInt();
	public void setPossuiInt( boolean dado );
	public boolean getPossuiMoeda();
	public void setPossuiMoeda( boolean dado );
	public boolean getSomaNegativo();
	public void setSomaNegativo( boolean dado );
	public boolean getCalculadoDemanda();
	public void setCalculadoDemanda( boolean dado );
	public String getTipo();
	public void setTipo( String dado );
	public long getIdEntidadeR();
	public void setIdEntidadeR( long dado );
	
	public boolean ehPercentual();
	public boolean ehDecimal();
}
