package loopback.remoting.adapters.rest;

import com.ning.http.client.AsyncCompletionHandlerBase;
import com.ning.http.client.HttpResponseStatus;
import com.ning.http.client.AsyncHandler.STATE;

public class AsyncCompletionHandlerWithStatusCorrection extends
		AsyncCompletionHandlerBase {

	@Override
	public STATE onStatusReceived(HttpResponseStatus status) throws Exception {
		if (status.getStatusCode() == 500) {
			return STATE.ABORT;
		} else {
			return super.onStatusReceived(status);
		}
	}
}