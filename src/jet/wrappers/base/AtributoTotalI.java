package jet.wrappers.base;

public interface AtributoTotalI {
	public String getNomeVariavel();
	public String getCastTipoJson();
	public String getNomeCampoTabela();
	public String getTipo();
	public String getTipoFuncaoMontador();
	public String getTipoOriginal();
	public String getNomePropriedade();
	public boolean ehData();
	public boolean ehMoeda();
	public boolean ehHora();
	public String formatoUpdateInsert(String objeto);
	public boolean ehEditavel();
	public boolean ehPercentual();
	public boolean ehChave();
	public boolean ehDecimal();
	public boolean ehCriptoNome();
	public boolean ehLogico();
	
	public String getNomeConstante();
}
