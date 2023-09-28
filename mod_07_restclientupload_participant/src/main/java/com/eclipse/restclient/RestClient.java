package com.eclipse.restclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;
import java.util.logging.Logger;
import jakarta.ws.rs.core.EntityPart;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;

/**
 * Jakarta web service client
 *
 * @author Ken Fogel
 */
public class RestClient {
    
    private static final Logger LOG = Logger.getLogger(
            RestClient.class.getName());

    /**
     * This calls the FileUpload POST web service running on a server.
     *
     * @param fileName
     * @param path
     * @return A bean that contains the result
     * @throws java.io.IOException
     */
    public Response callFileUploadService(String fileName, String path) throws IllegalStateException, IOException {

        // ToDo
        
        //LOG.log(Level.INFO, "callFileUploadService response = {0}", response.getStatus());
        
        return null; //response;
    }     

    /**
     * This is just an example of how little code is required to consume a web
     * service. Doing work in the main method should be avoided.
     *
     * @param args Ignored
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IllegalStateException, IOException {

        RestClient restClient = new RestClient();
        restClient.callFileUploadService("vwvan1974.jpg", "C:/temp/");
    }
}
