package gerapp.padrao.node;

public class ConversorNome {

	public static String getNomeControle(String nomeComponente) {
		String saida = "app";
		for (int i=0;i<nomeComponente.length();i++) {
			if (Character.isUpperCase(nomeComponente.charAt(i))) {
				saida += "-" + Character.toLowerCase(nomeComponente.charAt(i));
			} else {
				saida += nomeComponente.charAt(i);
			}
		}
		return saida;
	}
}
