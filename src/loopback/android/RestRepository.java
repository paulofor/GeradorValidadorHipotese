package loopback.android;

import loopback.android.remoting.Repository;
import loopback.android.remoting.VirtualObject;
import loopback.remoting.adapters.RestAdapter;
import loopback.remoting.adapters.RestContract;



public class RestRepository<T extends VirtualObject> extends Repository<T> {
    public RestRepository(String className) {
        super(className);
    }

    public RestRepository(String className, Class<T> objectClass) {
        super(className, objectClass);
    }

    public RestContract createContract() {
        return new RestContract();
    }

    public RestAdapter getRestAdapter() {
        return (RestAdapter) getAdapter();
    }
}
