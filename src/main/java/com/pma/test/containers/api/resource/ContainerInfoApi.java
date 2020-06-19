package com.pma.test.containers.api.resource;

import com.pma.test.containers.model.ContainerInfo;
import com.pma.test.containers.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Component that exposes REST endpoints for greetings.
 *
 * @author pabbott
 */
@Component
@Path("runningconts")
public class ContainerInfoApi {

    @Autowired
    private ContainerService infoService;

    /**
     * Get a list of running containers.
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRunningContainers() {
        try {
            List<ContainerInfo> containers = infoService.getRunningContainers();
            return Response.ok(containers).build();
        }
        catch(Exception e) {
            return Response.serverError().build();
        }
    }
}