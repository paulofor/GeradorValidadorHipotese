package loopback.remoting.adapters;

import java.util.Map;

import loopback.android.RestRepository;

public class RestAdapter extends Adapter {

	private static final String TAG = "remoting.RestAdapter";

	// private HttpClient client;
	private RestContract contract;

	enum ParameterEncoding {
		FORM_URL, JSON, FORM_MULTIPART
	}

	public RestAdapter(String url) {
		super(url);
		this.contract = new RestContract();
	}

	@Override
	public void connect(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void invokeInstanceMethod(String method,
			Map<String, ? extends Object> constructorParameters,
			Map<String, ? extends Object> parameters, Callback callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void invokeStaticMethod(String method,
			Map<String, ? extends Object> parameters, Callback callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	public <U extends RestRepository> U createRepository(
			Class<U> repositoryClass) {
		U repository = null;
		try {
			repository = repositoryClass.newInstance();
			repository.setAdapter(this);
		} catch (Exception e) {
			IllegalArgumentException ex = new IllegalArgumentException();
			ex.initCause(e);
			throw ex;
		}
		attachModelRepository(repository);
		return repository;
	}

	private void attachModelRepository(RestRepository repository) {
		getContract().addItemsFromContract(repository.createContract());
		repository.setAdapter(this);
	}

	public RestContract getContract() {
		return contract;
	}
}
