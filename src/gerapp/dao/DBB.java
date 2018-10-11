package gerapp.dao;


import gerapp.dao.*;


public  class DBB   { 
      public DBB()
      {
		_aplicacaoDao = null;
		_atributoEntidadeDao = null;
		_entidadeDao = null;
		_filtroColecaoDao = null;
		_procValorDao = null;
		_regraColecaoDao = null;
		_relacionamentoEntidadeDao = null;
	}
	private static DBB _instancia =  null;
	public static DBB getInstancia() {
		if (_instancia==null) _instancia = new DBB();
		return _instancia;
	}
	private  AplicacaoDao _aplicacaoDao;
	public  AplicacaoDao getAplicacaoDao() {
		if (_aplicacaoDao==null) _aplicacaoDao = new AplicacaoDaoExtendida();
		return _aplicacaoDao;
	}
	private  AtributoEntidadeDao _atributoEntidadeDao;
	public  AtributoEntidadeDao getAtributoEntidadeDao() {
		if (_atributoEntidadeDao==null) _atributoEntidadeDao = new AtributoEntidadeDaoExtendida();
		return _atributoEntidadeDao;
	}
	private  EntidadeDao _entidadeDao;
	public  EntidadeDao getEntidadeDao() {
		if (_entidadeDao==null) _entidadeDao = new EntidadeDaoExtendida();
		return _entidadeDao;
	}
	private  FiltroColecaoDao _filtroColecaoDao;
	public  FiltroColecaoDao getFiltroColecaoDao() {
		if (_filtroColecaoDao==null) _filtroColecaoDao = new FiltroColecaoDaoExtendida();
		return _filtroColecaoDao;
	}
	private  ProcValorDao _procValorDao;
	public  ProcValorDao getProcValorDao() {
		if (_procValorDao==null) _procValorDao = new ProcValorDaoExtendida();
		return _procValorDao;
	}
	private  RegraColecaoDao _regraColecaoDao;
	public  RegraColecaoDao getRegraColecaoDao() {
		if (_regraColecaoDao==null) _regraColecaoDao = new RegraColecaoDaoExtendida();
		return _regraColecaoDao;
	}
	private  RelacionamentoEntidadeDao _relacionamentoEntidadeDao;
	public  RelacionamentoEntidadeDao getRelacionamentoEntidadeDao() {
		if (_relacionamentoEntidadeDao==null) _relacionamentoEntidadeDao = new RelacionamentoEntidadeDaoExtendida();
		return _relacionamentoEntidadeDao;
	}
}
