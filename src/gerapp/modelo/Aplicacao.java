package gerapp.modelo;


import br.com.digicom.lib.*;


import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;

public interface Aplicacao
 extends DCIObjetoDominio,AplicacaoAssembledI,AplicacaoDerivadaI { 
	public long getIdAplicacao();
	public void setIdAplicacao( long dado );
	public String getNome();
	public void setNome( String dado );
	public String getNamespace();
	public void setNamespace( String dado );
	public String getDiretorioJava();
	public void setDiretorioJava( String dado );
	public String getDiretorioFlex();
	public void setDiretorioFlex( String dado );
	public String getDiretorio();
	public void setDiretorio( String dado );
	public String getBancoDados();
	public void setBancoDados( String dado );
	public String getVersaoVs();
	public void setVersaoVs( String dado );
	public String getUrl();
	public void setUrl( String dado );
	public String getDiretorioCpp();
	public void setDiretorioCpp( String dado );
}
