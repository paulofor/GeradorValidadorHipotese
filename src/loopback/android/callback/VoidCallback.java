package loopback.android.callback;

public interface VoidCallback {
    public void onSuccess();
    public void onError(Throwable t);
}
