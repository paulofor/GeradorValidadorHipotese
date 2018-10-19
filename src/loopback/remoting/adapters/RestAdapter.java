package loopback.remoting.adapters;

import java.util.Map;

import loopback.android.RestRepository;
import loopback.remoting.adapters.rest.BinaryHandler;
import loopback.remoting.adapters.rest.CallbackHandler;
import loopback.remoting.adapters.rest.HttpClient;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.Response;

public class RestAdapter extends Adapter {

	private static final String TAG = "remoting.RestAdapter";

	private HttpClient client;
	private RestContract contract;

	public enum ParameterEncoding {
		FORM_URL, JSON, FORM_MULTIPART
	}

	public RestAdapter(String url) {
		super(url);
		this.contract = new RestContract();
	}

	@Override	
	public void connect(String url) {
		if (url == null) {
			client = null;
		} else {
			client = new HttpClient(url);
		}
	}

	@Override
	public void invokeInstanceMethod(String method,
			Map<String, ? extends Object> constructorParameters,
			Map<String, ? extends Object> parameters, Callback callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void invokeStaticMethod(String method,
			Map<String, ? extends Object> parameters,
			final BinaryCallback callback) {
		AsyncCompletionHandler<Response> httpHandler = new BinaryHandler(callback);
		invokeStaticMethod(method, parameters, httpHandler);
	}

	
	private void invokeStaticMethod(String method,
			Map<String, ? extends Object> parameters,
			AsyncCompletionHandler<Response> httpHandler) {
			if (contract == null) {
			throw new IllegalStateException("Invalid contract");
		}

		String verb = contract.getVerbForMethod(method);
		String path = contract.getUrlForMethod(method, parameters);
		ParameterEncoding parameterEncoding = contract
				.getParameterEncodingForMethod(method);
		request(path, verb, parameters, parameterEncoding, httpHandler);
	
	}
    

	private void request(String path, String verb,
			Map<String, ? extends Object> parameters,
			ParameterEncoding parameterEncoding,
			AsyncCompletionHandler<Response> responseHandler) {
		
		if (!isConnected()) {
			throw new IllegalStateException("Adapter not connected");
		}
		client.request(verb, path, parameters, parameterEncoding, responseHandler);

	}
	
	
	
	@Override
	public boolean isConnected() {
		
		return client != null;
	}

	public <U extends RestRepository> U createRepository(Class<U> repositoryClass) {
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

	@Override
	public void invokeStaticMethod(String method,
			Map<String, ? extends Object> parameters, final Callback callback) {
		AsyncCompletionHandler<Response> httpHandler = new CallbackHandler(callback);
		invokeStaticMethod(method, parameters, httpHandler);
	}

	

	
}
