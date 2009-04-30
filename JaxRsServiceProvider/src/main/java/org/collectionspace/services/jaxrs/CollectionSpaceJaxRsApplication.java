package org.collectionspace.services.jaxrs;

import org.collectionspace.services.CollectionObjectResource;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class CollectionSpaceJaxRsApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public CollectionSpaceJaxRsApplication() {
        singletons.add(new CollectionObjectResource());
//        singletons.add(new DomainIdentifierResource());
//        singletons.add(new PingResource());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
