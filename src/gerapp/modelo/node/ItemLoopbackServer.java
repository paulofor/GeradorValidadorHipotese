package gerapp.modelo.node;

import java.util.Iterator;

import jet.wrappers.base.AtributoWrapper;

public interface ItemLoopbackServer {

	public String getNomeParaArquivoServer();
	
	public String getNomeModeloServer();
	
	public String getNomeParametroServer();
	
	public Iterator<AtributoWrapper> getIteratorAtributo();

}
