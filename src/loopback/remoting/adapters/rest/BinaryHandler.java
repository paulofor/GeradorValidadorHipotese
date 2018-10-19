package loopback.remoting.adapters.rest;

import java.util.Map;

import loopback.remoting.adapters.Adapter.BinaryCallback;
import loopback.remoting.adapters.Adapter.Callback;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.Response;


public class BinaryHandler extends AsyncCompletionHandlerWithStatusCorrection {
	private final BinaryCallback callback;

	public BinaryHandler(BinaryCallback callback) {
		// super(new String[]{".*"});
		this.callback = callback;
	}

	@Override
	public Response onCompleted(Response response) throws Exception {

		byte[] binaryData = response.getResponseBodyAsBytes();

		// Log.getLogger().info("Success (binary): " + binaryData.length + "
		// bytes");

		try {
			String contentType = response.getContentType();
			callback.onSuccess(binaryData, contentType);
		} catch (Throwable t) {
			callback.onError(t);
		}

		return super.onCompleted(response);
	}

	@Override
	public void onThrowable(Throwable t) {
		// Log.getLogger().severe("HTTP request (binary) failed: " +
		// t.getMessage());
		callback.onError(t);

		super.onThrowable(t);
	}
}





