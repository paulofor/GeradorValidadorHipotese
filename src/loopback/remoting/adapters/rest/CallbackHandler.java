package loopback.remoting.adapters.rest;



import loopback.remoting.adapters.Adapter.Callback;

import com.ning.http.client.Response;


public class CallbackHandler extends AsyncCompletionHandlerWithStatusCorrection {
	private final Callback callback;

	public CallbackHandler(Callback callback) {
		this.callback = callback;
	}

	@Override
	public Response onCompleted(Response response) throws Exception {
		try {
			String responseBody = response.getResponseBody();
			// Log.getLogger().info("Success (string): " + response);
			callback.onSuccess(responseBody);
		} catch (Throwable t) {
			callback.onError(t);
		}

		return super.onCompleted(response);
	}

	@Override
	public void onThrowable(Throwable t) {
		// Log.getLogger().severe("HTTP request (string) failed: " +
		// t.getMessage());
		callback.onError(t);

		super.onThrowable(t);
	}
}
