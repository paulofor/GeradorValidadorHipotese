package app;

import java.util.List;

import loopback.remoting.adapters.RestAdapter;

public class TesteCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Ola Mundo");
		
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21101/api");
		RepositorioBase.CampanhaAdRepository rep = adapter.createRepository(RepositorioBase.CampanhaAdRepository.class);
		
		/*
		rep.findById(1, new ObjectCallback<CampanhaAds>() { 
            @Override 
            public void onSuccess(CampanhaAds model) { 
            	System.out.println("Sucesso: " + model);
            }
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			} 
        });
     	*/
		
		
		rep.listaPendente(new ListCallback<CampanhaAds>() { 
            
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<CampanhaAds> objects) {
				// TODO Auto-generated method stub
				System.out.println("Sucesso" + objects.size());
				//System.out.println("Lista Interna:" + objects.get(0).getAnuncioAds().size());
				IntegracaoMundo integra = new IntegracaoMundo();
				integra.criaCampanha(objects);
				
			} 
        });
               
	}

}