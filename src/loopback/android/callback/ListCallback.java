package loopback.android.callback;



import java.util.List;

import loopback.android.remoting.VirtualObject;

public interface ListCallback<T extends VirtualObject> {
    public void onSuccess(List<T> objects);
    public void onError(Throwable t);
}
