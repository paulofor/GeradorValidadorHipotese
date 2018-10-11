package jet.wrappers.base;

import gerapp.modelo.ProcValor;

public abstract class ProcValorWrapper implements AtributoTotalI{

	protected ProcValor base;
	public void setProcValor(ProcValor procValor) {
		base = procValor;
	}
	public ProcValorWrapper() {
		
	}
	public ProcValorWrapper(ProcValor proc) {
		base = proc;
	}
	
	public abstract String getTipo();
	public abstract String getTipoSqlite();
		
	public final String getNomePropriedade() {
		String variavel = getNomeVariavel();
		return variavel.substring(0,1).toUpperCase() + variavel.substring(1);
	}
	
	public final boolean ehPercentual() {
		if (base==null) {
			return false;
		}
		else
			return 
			(
			base.getTipo().equals("Percent") 
			);	
	}
	public final boolean ehDecimal() {
		if (base==null) {
			return false;
		}
		else
			return 
			(
				("Decimal".equals(base.getTipo())) || ("Moeda".equals(base.getTipo()))
			);	
	}
	public final boolean ehLogico() {
		if (base==null) {
			return false;
		}
		else
			return 
			(
				("Logic".equals(base.getTipo()))
			);	
	}
	
	public final String getNomeVariavel() {
		String nome = base.getNome();
		String saida = "";
		boolean mudar = false;
		for (int i=0;i<nome.length();i++) {
			if (nome.substring(i, i+1).compareTo("_")==0) {
				mudar = true;
			} else {
				if (mudar) {
					saida += nome.substring(i,i+1).toUpperCase();
					mudar = false;
				} else {
					saida += nome.substring(i,i+1);
				}
			}
		}
		return saida;
	}
	
	

	public boolean ehChave() {
		return false;
	}


	public boolean ehCriptoNome() {
		if (base==null) {
			return false;
		} else {
			return base.getTipo().equals("CriptoTLbl");
		}
	}


	public boolean ehData() {
		if (base==null) {
			return false;
		}
		else
			return 
			(
			base.getTipo().equals("Data") ||
			base.getTipo().equals("DTemp")
			);
	}


	public boolean ehEditavel() {
		return false;
	}


	public boolean ehHora() {
		if (base==null) {
			return false;
		}
		else
			return 
			(
			base.getTipo().equals("Tempo") ||
			base.getTipo().equals("DTemp")
			);	
	}


	public boolean ehMoeda() {
		if (base==null) {
			return false;
		}
		else
			return 
			(
			base.getTipo().equals("Moeda")
			);	
	}


	public String formatoUpdateInsert(String objeto) {
		throw new RuntimeException("Metodo nao implementado");
	}


	public abstract String getCastTipoJson();


	public String getNomeCampoTabela() {
		String saida = "";
		for (int i=0;i < base.getNome().length();i++){
			char letra = base.getNome().charAt(i);
			if (Character.isUpperCase(letra) ) {
				if (i>0) {
					saida += "_" + Character.toLowerCase(letra);
				} else {
					saida += Character.toLowerCase(letra);
				}
			} else {
				saida += letra;
			}
		}
		return saida;
	}


	public String getNomeConstante() {
		String nome = base.getNome();
		return nome.toUpperCase();
	}


	public abstract String getTipoFuncaoMontador();


	public String getTipoOriginal() {
		return base.getTipo();
	}
}
