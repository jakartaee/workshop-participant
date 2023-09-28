package com.eclipse.servletclient.servlet;

//import com.eclipse.servletclient.bean.CompoundBean;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.EntityPart;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is an example of using a Servlet as a client for a web service running
 * in another process in the application server.
 *
 * @author Ken Fogel
 */
@WebServlet(name = "ServletClient", urlPatterns = {"/ServletClient"})
public class ServletClient extends HttpServlet {
    
    private static final Logger LOG = Logger.getLogger(
            ServletClient.class.getName());

    /**
     * Handles the HTTP GET request using the query parameters to construct an
     * object of type CompounbBean that is sent to the Mod_06_RestServer for the
     * calculation. The result is then displayed in a simple web page.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Response restResponse = callFileUploadService();
        LOG.log(Level.INFO, "\n ]]]restResponse = {0} \n", restResponse.getStatusInfo());
    }

    /**
     * This calls the Compound Interest web service running as a separate
     * process on the server or another server.
     *
     * @return compoundBean contains the result
     * @throws java.io.IOException
     */
    public Response callFileUploadService() throws IllegalStateException, IOException {
        
        // ToDo
        
        return response;
    }
}
