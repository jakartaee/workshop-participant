package com.eclipse.servletclient.servlet;

import com.eclipse.servletclient.bean.CompoundBean;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is an example of using a Servlet as a client for a web service running
 * in another application on the server.
 *
 * @author Ken Fogel
 */
@WebServlet(name = "ServletClient", urlPatterns = {"/ServletClient"})
public class ServletClient extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ServletClient.class.
            getName());

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

        CompoundBean compoundBean = new CompoundBean(
                Double.parseDouble(request.getParameter("principal")),
                Double.parseDouble(request.getParameter("annualInterestRate")),
                Double.parseDouble(request.getParameter("compoundPerTimeUnit")),
                Double.parseDouble(request.getParameter("time")));

        var resultBean = callCompoundService(compoundBean);

        LOG.log(Level.INFO, "\n ]]]doGet compoundBean = {0} \n", compoundBean.toString());

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // Using the new TextBlock and formatted String
            out.println("""
            <!DOCTYPE html>
            <html>
                <head>
                    <title>Mod 06 ServletJSFClient</title>
                    <link rel='stylesheet' href='styles/main.css' type='text/css'/>
                </head>
                <body>
                    <h2>Principal: %s</h2>
                    <h2>Annual Interest Rate: %s</h2>
                    <h2>Compound Per Time Unit: %s</h2>
                    <h2>Time: %s</h2>
                    <h2>Result: %s</h2>
                </body>
            </html>"""
            .formatted(resultBean.getPrincipal(), 
                       resultBean.getAnnualInterestRate(), 
                       resultBean.getCompoundPerTimeUnit(),
                       resultBean.getTime(),
                       resultBean.getResult()));
        }
    }

    /**
     * This calls the Compound Interest web service running as a separate
     * process on the server or another server.
     *
     * @param compoundBeanLocal is the bean passed from the client
     * @return compoundBean contains the result
     */
    public CompoundBean callCompoundService(CompoundBean compoundBeanLocal) {

        // Todo
        
        return compoundBean;
    }
}
