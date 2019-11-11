package app;

import gerapp.app.GeradorIonic3Back;
import gerapp.modelo.Aplicacao;
import loopback.android.callback.ObjectCallback;
import loopback.cliente.modelo.AplicacaoRest;
import loopback.cliente.repositorio.AplicacaoRepositorio;
import loopback.remoting.adapters.RestAdapter;

public class CriaIonic3DesenBack {
	public static void main(String[] args) {
		CriaIonic3BackObj obj = new CriaIonic3BackObj();
		obj.run(GeradorIonic3Back.AMBIENTE_DESENVOLVIMENTO);
	}
}
