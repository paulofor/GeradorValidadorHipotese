package loopback.android.callback;

/**
 * Created by christopher on 31/01/15.
 */
public interface TypedCallback<T> {
    public void onSuccess(T object);

    public void onError(Throwable t);
}
