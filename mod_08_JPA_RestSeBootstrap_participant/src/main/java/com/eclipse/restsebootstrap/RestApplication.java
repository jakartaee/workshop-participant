package com.eclipse.restsebootstrap;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.Set;

/**
 * You must have a class that extends Application. The Application method
 * getClasses must be overridden to list all classes that are web services.
 *
 * @author Ken Fogel
 */
// This is the path of the services. It follows the URL as in http://localhost:8080/services/ 
@ApplicationPath("services")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(CompoundInterestService.class);
    }
}
