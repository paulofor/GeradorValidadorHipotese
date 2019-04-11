package jet.wrappers.base;

import gerapp.modelo.AtributoEntidade;

public abstract class AtributoWrapper implements AtributoTotalI {

	protected AtributoEntidade base;

	// protected AtributoTotalI baseTotal;

	public boolean ehEditavel() {
		return base.getEditavel();
	}

	public boolean ehObrigatorio() {
		return base.getObrigatorio();
	}

	public AtributoWrapper(AtributoEntidade atributo) {
		base = atributo;
	}

	public AtributoWrapper() {

	}

	public String getTipoOriginal() {
		return base.getTipo();
	}

	/*
	 * public String formatoUpdate(String objeto) { String saida = null; if
	 * (this.ehLogico()) { return "'\" + (" + objeto + "." +
	 * this.getNomePropriedade() + "?\"S\":\"N\") + \"' "; } if (this.ehData() ||
	 * this.ehHora()) { return "\" + (" + objeto + "." +
	 * this.getNomePropriedade() + "==null?\"null\":\"'\" + " + objeto + "." +
	 * this.getNomePropriedade() + " + \"'\") + \" "; } return "'\" + " + objeto +
	 * "." + this.getNomePropriedade() + " + \"' "; }
	 */

	public void setBase(AtributoEntidade atributo) {
		base = atributo;
	}

	/*
	 * public void setBase(AtributoTotalI atributo) { if (atributo instanceof
	 * AtributoEntidade) { base = (AtributoEntidade) atributo; } else { base =
	 * null; } }
	 */
	public abstract String getMetodoObtemSqlite();

	public abstract String getTipoSqlite();

	public abstract String getTipoSqliteSinc();

	public abstract String getTipo();

	public abstract String getTipoFuncaoMontador();

	public abstract String getCastTipoJson();

	public final String getNomeMetodo() {
		return base.getNome().substring(0, 1).toUpperCase()
				+ base.getNome().substring(1);
	}

	public final boolean ehLogico() {
		if (base == null) {
			return false;
		} else {
			return base.getTipo().equals("Logic");
		}
	}

	public final boolean ehCriptoNome() {
		if (base == null) {
			return false;
		} else {
			return base.getTipo().equals("CriptoTLbl");
		}
	}

	public final boolean ehDecimal() {
		if (base == null) {
			return false;
		} else
			return (base.getTipo().equals("Moeda")
					|| base.getTipo().equals("Percent") || base.getTipo()
					.equals("Decimal"));
	}

	public final boolean ehMoeda() {
		if (base == null) {
			return false;
		} else
			return (base.getTipo().equals("Moeda"));
	}

	public final boolean ehPercentual() {
		if (base == null) {
			return false;
		} else
			return (base.getTipo().equals("Percent"));
	}

	public boolean ehChave() {
		return base.getChave();
	}

	public final boolean ehData() {
		if (base == null) {
			return false;
		} else
			return (base.getTipo().equals("Data") || base.getTipo().equals(
					"DTemp"));
	}

	public final boolean ehHora() {
		if (base == null) {
			return false;
		} else
			return (base.getTipo().equals("Tempo") || base.getTipo().equals(
					"DTemp"));
	}

	public final boolean ehInteiro() {
		if (base == null) {
			return false;
		} else
			return (base.getTipo().equals("NInt") || base.getTipo().equals(
					"NInt"));
	}

	// public String getTipoJava() {
	// return ConversorTipo.getTipoJava(base.getTipo());
	// }
	// public String getTipoParametroSql() {
	// return ConversorTipo.getTipoParametroSql(base.getTipo());
	// }

	public final String getNomePropriedade() {
		String variavel = getNomeVariavel();
		return variavel.substring(0, 1).toUpperCase() + variavel.substring(1);
	}

	public final String getNomeConstante() {
		String nome = base.getNome();
		return nome.toUpperCase();
	}

	public final String getNomeVariavel() {
		String nome = base.getNome();
		String saida = "";
		boolean mudar = false;
		for (int i = 0; i < nome.length(); i++) {
			if (nome.substring(i, i + 1).compareTo("_") == 0) {
				mudar = true;
			} else {
				if (mudar) {
					saida += nome.substring(i, i + 1).toUpperCase();
					mudar = false;
				} else {
					saida += nome.substring(i, i + 1);
				}
			}
		}
		return saida;
	}

	public final String getNomeCampoTabela() {
		String nome = base.getNome();
		return nome;
	}

	public final String getNomeCampoTabelaAndroid2() {
		if (this.ehChave())
			return "_id";
		else
			return getNomeCampoTabela();
	}

	public final String getTipoNode() {
		if (base.getTipo().equals("NInt") || base.getTipo().equals("Decimal")
				|| base.getTipo().equals("Logic") || base.getTipo().equals("")
				|| base.getTipo().equals("")) {
			return "number";
		}
		if (base.getTipo().equals("TLbl") || base.getTipo().equals("TLblLg")
				|| base.getTipo().equals("") || base.getTipo().equals("")
				|| base.getTipo().equals("")) {
			return "string";
		}
		if (base.getTipo().equals("Data") || base.getTipo().equals("DTemp")
				|| base.getTipo().equals("") || base.getTipo().equals("")
				|| base.getTipo().equals("")) {
			return "date";
		}
		return base.getTipo();
	}

	public final String getTipoSql() {
		if (base.getTipo().equals("NInt") || base.getTipo().equals("")
				|| base.getTipo().equals("") || base.getTipo().equals("")
				|| base.getTipo().equals("")) {
			return "INTEGER";
		}
		if (base.getTipo().equals("Logic") || base.getTipo().equals("")
				|| base.getTipo().equals("") || base.getTipo().equals("")
				|| base.getTipo().equals("")) {
			return "TINYINT";
		}
		if (base.getTipo().equals("Decimal") || base.getTipo().equals("")
				|| base.getTipo().equals("") || base.getTipo().equals("")
				|| base.getTipo().equals("")) {
			return "DECIMAL";
		}
		if (base.getTipo().equals("TLbl")) {
			return "VARCHAR(50)";
		}
		if (base.getTipo().equals("TLblLg")) {
			return "VARCHAR(255)";
		}
		if (base.getTipo().equals("Data") || base.getTipo().equals("DTemp")
				|| base.getTipo().equals("") || base.getTipo().equals("")
				|| base.getTipo().equals("")) {
			return "DATETIME";
		}
		return base.getTipo();
	}

}
