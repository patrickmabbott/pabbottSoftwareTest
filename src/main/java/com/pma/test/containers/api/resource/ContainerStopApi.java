package com.pma.test.containers.api.resource;

import com.pma.test.containers.model.Result;
import com.pma.test.containers.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Component that allows stopping running containers.
 *
 * @author pabbott
 */
@Component
@Path("stop")
public class ContainerStopApi {

    @Autowired
    private ContainerService infoService;

    /**
     * Stops a running container.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response stop(@FormParam("contid") final String contId) {
        try {
            infoService.stop(contId);
            return Response.ok(new Result(true,
                    String.format("Successfully stopped container %s", contId))).build();
        } //Unsure what exception docker client API throws on unable to find so just going generic here.
        catch(Exception e) {
            return Response.serverError().build();
        }
    }
}