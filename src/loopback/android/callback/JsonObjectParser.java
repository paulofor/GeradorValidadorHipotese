package loopback.android.callback;



import loopback.android.remoting.JsonUtil;
import loopback.android.remoting.Repository;
import loopback.android.remoting.VirtualObject;
import loopback.remoting.adapters.Adapter;

import org.json.JSONObject;

public class JsonObjectParser<T extends VirtualObject>
        extends Adapter.JsonObjectCallback {

    private final Repository<T> repository;
    private final ObjectCallback<T> callback;

    public JsonObjectParser(Repository<T> repository, ObjectCallback<T> callback) {
        this.repository = repository;
        this.callback = callback;
    }

  

	@Override
    public void onSuccess(JSONObject response) {
		System.out.println("Resposta:" + response.toString());
        if (response == null) {
            // Not found
            callback.onSuccess(null);
            return;
        }

        callback.onSuccess(repository.createObject(JsonUtil.fromJson(response)));
    }

    @Override
    public void onError(Throwable throwable) {
    	throwable.printStackTrace();
        callback.onError(throwable);
    }
}
