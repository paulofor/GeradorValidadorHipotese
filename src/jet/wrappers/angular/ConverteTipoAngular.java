package jet.wrappers.angular;

import gerapp.modelo.AtributoEntidade;
import gerapp.modelo.ProcValor;
import jet.wrappers.base.ConverteTipo;

public class ConverteTipoAngular extends ConverteTipo{

	
	public String getTipo(ProcValor proc) {
		return getTipoPorOriginal(proc.getTipo());
	}
	public String getTipo(AtributoEntidade atributo) {
		if (atributo.getTipo()==null) {
			throw new RuntimeException("Atributo: " + atributo.getEntidade().getNome() + "." + atributo.getNome() + " sem tipo");
		}
		return getTipoPorOriginal(atributo.getTipo());
	}
	
	public static String getTipoFiltro(String tipo) {
		if (tipo.compareTo("NInt")==0)
			return "Long";
		if (tipo.compareTo("TLbl")==0 || 
			tipo.compareTo("TLblLg")==0)
			return "String";
		if (tipo.compareTo("Moeda")==0)
			return "Float";
		if (tipo.compareTo("Data")==0)
			return "String";
		if (tipo.compareTo("Tempo")==0)
			return "String";
		if (tipo.compareTo("Logic")==0)
			return "Boolean";
		if (tipo.compareTo("Decimal")==0 ||
			tipo.compareTo("Percent")==0)
			return "Float";
		if (tipo.compareTo("Itens")==0)
			return "List";
		if (tipo.compareTo("Data")==0 ||
			tipo.compareTo("Tempo")==0 ||
			tipo.compareTo("DTemp")==0)
			return "Timestamp";
		return tipo;
	}
	
	public String getTipoPorOriginal(String tipoOriginal) {

		if (tipoOriginal.compareTo("TNota10")==0	)
			return "number";
		if (tipoOriginal.compareTo("TLbl")==0 || 
			tipoOriginal.compareTo("TLblLg")==0 || 
			tipoOriginal.compareTo("CriptoTLbl")==0 ||
			tipoOriginal.compareTo("TDesc")==0)
			return "string";
		if (tipoOriginal.compareTo("Moeda")==0 || 
			tipoOriginal.compareTo("Percent")==0 || 
			tipoOriginal.compareTo("CriptoMoeda")==0 || 
			tipoOriginal.compareTo("Decimal")==0)
			return "number";
		if (tipoOriginal.compareTo("Data")==0 ||
			tipoOriginal.compareTo("DTemp")==0)
			return "Date";
		if (tipoOriginal.compareTo("Logic")==0)
			return "number";
		if (tipoOriginal.compareTo("NInt")==0)
			return "number";
		if (tipoOriginal.compareTo("Itens")==0)
			return "string";
		if (tipoOriginal.compareTo("Tempo") == 0)
			return "Date";
		return tipoOriginal;
	}
	
	// Metodo que vai extrair o dado do banco para um determinado formato.
	public String getMetodoObtemSqlite(AtributoEntidade atributo) {
		return getMetodoObtemSqlite(atributo.getTipo());
	}
	public String getMetodoObtemSqlite(ProcValor atributo) {
		return getMetodoObtemSqlite(atributo.getTipo());
	}
	
	private String getMetodoObtemSqlite(String tipo) {
		if (tipo.compareTo("NInt")==0 ||
				tipo.compareTo("TNota10")==0	)
				return "Int";
			if (tipo.compareTo("TLbl")==0 || 
					tipo.compareTo("TLblLg")==0 || 
					tipo.compareTo("CriptoTLbl")==0 ||
					tipo.compareTo("TDesc")==0)
				return "String";
			if (tipo.compareTo("Moeda")==0 ||
					tipo.compareTo("Percent")==0 ||
					tipo.compareTo("CriptoMoeda")==0 ||
					tipo.compareTo("Decimal")==0)
				return "Float";
			if (tipo.compareTo("Tempo")==0)
				return "Timestamp";
			if (tipo.compareTo("Data")==0)
				return "TimestampData";
			if (tipo.compareTo("DTemp")==0 )
				return "TimestampDataHora";
			if (tipo.compareTo("Itens")==0 )
				return "List";
			return tipo;
	}
	
	public String getTipoJson(AtributoEntidade atributo) {
		return getTipoJson(atributo.getTipo());
	}
	
	public String getTipoJson(ProcValor proc) {
		return getTipoJson(proc.getTipo());
	}
	// Função na ConversorJson o que vem pelo WebService
	public String getTipoJson(String tipo) {
		if (tipo.compareTo("NInt")==0 ||
				tipo.compareTo("TNota10")==0	)
			return "Integer";
		if (tipo.compareTo("TLbl")==0 || 
				tipo.compareTo("TLblLg")==0 || 
				tipo.compareTo("CriptoTLbl")==0 ||
				tipo.compareTo("TDesc")==0)
			return "String";
		if (tipo.compareTo("Moeda")==0 ||
				tipo.compareTo("Percent")==0 ||
				tipo.compareTo("CriptoMoeda")==0 ||
				tipo.compareTo("Decimal")==0)
			return "Float";
		if (tipo.compareTo("Data")==0)
			return "TimestampData";
		if (tipo.compareTo("Tempo")==0)
			return "TimestampHora";
		if (tipo.compareTo("DTemp")==0)
			return "TimestampDataHora";
		return tipo;
	}
	
	
	public String getTipoSqliteSinc(AtributoEntidade atributo) {
		return getTipoSqliteSinc(atributo.getTipo());
	}
	public String getTipoSqliteSinc(ProcValor proc) {
		return getTipoSqliteSinc(proc.getTipo());
	}
	
	
	public String getTipoSqliteSinc(String tipo) {
		String saida = tipo;
		if (tipo.compareTo("NInt")==0 ||
				tipo.compareTo("TNota10")==0	)
			saida = "INTEGER";
		if (tipo.compareTo("TLbl")==0 || 
				tipo.compareTo("TLblLg")==0 || 
				tipo.compareTo("CriptoTLbl")==0 ||
				tipo.compareTo("TDesc")==0)
			saida = "TEXT";
		if (tipo.compareTo("Moeda")==0 ||
				tipo.compareTo("Percent")==0 ||
				tipo.compareTo("CriptoMoeda")==0 ||
				tipo.compareTo("Decimal")==0	)
			saida = "REAL";
		if (tipo.compareTo("Data")==0 ||
				tipo.compareTo("Tempo")==0 ||
				tipo.compareTo("DTemp")==0) 
			saida = "INTEGER";
		if (tipo.compareTo("Logic")==0)
			saida = "NUMERIC";
		return saida;
	}
	
	// Tipo da coluna no banco.
	public String getTipoSqlite(AtributoEntidade atributo) {
		String saida = getTipoSqliteSinc(atributo);
		if (atributo.getChave()) {
			saida += " PRIMARY KEY";
		}
		return saida;
	}
	public String getTipoSqlite(ProcValor proc) {
		String saida = getTipoSqliteSinc(proc);
		return saida;
	}
}

