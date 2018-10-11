package gerapp.modelo.vo;

import br.com.digicom.lib.*;

import gerapp.modelo.*;
import gerapp.modelo.agregados.*;
import gerapp.modelo.derivadas.*;

public class ProcValorVo implements ProcValor {
	private ProcValorAssembled _assembled = new ProcValorAssembled();
	private ProcValorDerivadaI derivada;

	public ProcValorVo() {
		derivada = new ProcValorDerivada(this);
	}

	private long _idProcValor = 0;

	public long getIdProcValor() {
		return _idProcValor;
	}

	public void setIdProcValor(long dado) {
		_idProcValor = dado;
	}

	String _nome;

	public String getNome() {
		return _nome;
	}

	public void setNome(String dado) {
		_nome = dado;
	}

	boolean _possuiTotalizacao;

	public boolean getPossuiTotalizacao() {
		return _possuiTotalizacao;
	}

	public void setPossuiTotalizacao(boolean dado) {
		_possuiTotalizacao = dado;
	}

	String _descricao;

	public String getDescricao() {
		return _descricao;
	}

	public void setDescricao(String dado) {
		_descricao = dado;
	}

	boolean _possuiInt;

	public boolean getPossuiInt() {
		return _possuiInt;
	}

	public void setPossuiInt(boolean dado) {
		_possuiInt = dado;
	}

	boolean _possuiMoeda;

	public boolean getPossuiMoeda() {
		return _possuiMoeda;
	}

	public void setPossuiMoeda(boolean dado) {
		_possuiMoeda = dado;
	}

	boolean _somaNegativo;

	public boolean getSomaNegativo() {
		return _somaNegativo;
	}

	public void setSomaNegativo(boolean dado) {
		_somaNegativo = dado;
	}

	boolean _calculadoDemanda;

	public boolean getCalculadoDemanda() {
		return _calculadoDemanda;
	}

	public void setCalculadoDemanda(boolean dado) {
		_calculadoDemanda = dado;
	}

	String _tipo;

	public String getTipo() {
		return _tipo;
	}

	public void setTipo(String dado) {
		_tipo = dado;
	}

	long _idEntidadeR;

	public long getIdEntidadeR() {
		return _idEntidadeR;
	}

	public void setIdEntidadeR(long dado) {
		_idEntidadeR = dado;
	}

	public Entidade getEntidadeRelacionada() {
		return _assembled.getEntidadeRelacionada();
	}

	public void setEntidadeRelacionada(Entidade dado) {
		_assembled.setEntidadeRelacionada(dado);
	}

	public String getXml() {
		String saidaXml;
		saidaXml = "";
		saidaXml = "<ProcValor ";
		saidaXml = saidaXml + "IdProcValor='" + this.getIdProcValor() + "' ";
		saidaXml = saidaXml + "Nome='" + this.getNome() + "' ";
		saidaXml = saidaXml + "PossuiTotalizacao='"
				+ this.getPossuiTotalizacao() + "' ";
		saidaXml = saidaXml + "Descricao='" + this.getDescricao() + "' ";
		saidaXml = saidaXml + "PossuiInt='" + this.getPossuiInt() + "' ";
		saidaXml = saidaXml + "PossuiMoeda='" + this.getPossuiMoeda() + "' ";
		saidaXml = saidaXml + "SomaNegativo='" + this.getSomaNegativo() + "' ";
		saidaXml = saidaXml + "CalculadoDemanda='" + this.getCalculadoDemanda()
				+ "' ";
		saidaXml = saidaXml + "Tipo='" + this.getTipo() + "' ";
		saidaXml = saidaXml + "IdEntidadeR='" + this.getIdEntidadeR() + "' ";
		saidaXml = saidaXml + "/>";
		return saidaXml;
	}
	
	public boolean ehDecimal() {
		return ("Decimal".equals(getTipo())) || ("Moeda".equals(getTipo()));
	}
	public boolean ehPercentual() {
		return ("Percent".equals(getTipo()));
	}

	
}
