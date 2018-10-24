package loopback.android.callback;

import java.util.ArrayList;
import java.util.List;

import loopback.android.remoting.JsonUtil;
import loopback.android.remoting.Repository;
import loopback.android.remoting.VirtualObject;
import loopback.remoting.adapters.Adapter;

import org.json.JSONArray;



public class JsonArrayParser<T extends VirtualObject> extends Adapter.JsonArrayCallback {
    private final Repository<T> repository;
    private final ListCallback<T> callback;

    public JsonArrayParser(Repository<T> repository, ListCallback<T> callback) {
        this.repository = repository;
        this.callback = callback;
    }

    @Override
    public void onSuccess(JSONArray response) {
        List<T> list = new ArrayList<T>();
        if (response != null) {
            for (int i = 0; i < response.length(); i++) {
                list.add(repository.createObject(JsonUtil.fromJson(response.optJSONObject(i))));
            }
        }
        callback.onSuccess(list);
    }

    @Override
    public void onError(Throwable throwable) {
        callback.onError(throwable);
    }
}
