package com.eclipse.restserver;

/**
 * There are a few different methods in this class, some commented out, as I
 * searched for a solution. None worked.
 */
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.EntityPart;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//import org.glassfish.jersey.media.multipart.FormDataParam;
/**
 * This class hosts a file upload service using the MultiPart API. The client
 * file in C:/temp/XXXX.jpg is uploaded and written to C:/temp2/XXXX.jpg on the
 * server. To run this on your own system just select two folders, place a file
 * in one, and it will be uploaded to the server and the service will write it
 * to the server side folder. Change the folder notation to match your OS.
 *
 * curl -X POST -F name=XXXX.jpg -F part=@C:/temp/XXXX.jpg
 * http://localhost:8080/Mod_07_MultiPart_Server_presenter/services/multiparts/
 *
 * @author Ken Fogel
 */
@Path("multiparts")
@RequestScoped
public class FileUploadService {

    /**
     * This method responds to a POST with a String and an EntityPart
     * (InputStream). It then saves the stream to a folder on the server
     * machine.
     *
     * Change the path to the location that you wish the uploaded file to be
     * stored in.
     *
     * @param part1 The name of the file when stored on the server
     * @param part2 This is the file that is being uploaded.
     * @return Response indicating success or failure.
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormParam("name") String part1,
            @FormParam("part") EntityPart part2) {

        // ToDo
        return Response.ok("File successfully uploaded!").build();
    }
    

    @GET
    public String sayHello() {
        return "Hello from FileUploadService";
    }
}
