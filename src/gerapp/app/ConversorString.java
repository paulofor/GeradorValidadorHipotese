package gerapp.app;

public class ConversorString {

	public static String getNomeComEspacoParaNotacaoNomeClasse(String entrada) {
		String saida = "";
		boolean ligaMaiuscula = true;
		for (int i=0;i<entrada.length();i++) {
			if (entrada.substring(i, i+1).equals(" ")) {
				ligaMaiuscula = true;
			} else {
				if (ligaMaiuscula) {
					saida += entrada.substring(i,i+1).toUpperCase();
					ligaMaiuscula = false;
				} else {
					saida += entrada.substring(i,i+1).toLowerCase();
				}
			}
			
		}
		return saida;
	}
}
