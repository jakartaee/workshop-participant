package com.eclipse.jsfclient;

import com.eclipse.jsfclient.bean.CompoundBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains the calculations. The Named annotation allows CDI to make
 * this service available on the Faces page.
 *
 * @author Ken Fogel
 */
@Named
@RequestScoped
public class CompoundServiceClient {

    private static final Logger LOG = Logger.getLogger(
            CompoundServiceClient.class.getName());
    /*
     * The curremt instance of the data bean managed by CDI. It will contain 
     * the data enetered into the form
     */
    @Inject
    private CompoundBean compoundBean;

    /**
     * This calls the Compound Interest web service running as a separate
     * process on the server or another server.
     *
     * Faces requires that action methods called from a Faces page must return a
     * String. A return of null is acceptable if whatever is returned is
     * ignored.
     *
     * @param compoundBeanLocal
     * @return Faces actions must return a String, null implies that whatever is
     * returned, even null, is not used.
     */
    public String callCompoundService(CompoundBean compoundBeanLocal) {

        // ToDo
        
        return null;
    }
}
