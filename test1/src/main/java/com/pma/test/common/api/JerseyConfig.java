package com.pma.test.common.api;


import com.pma.test.containers.api.resource.ContainerInfoApi;
import com.pma.test.containers.api.resource.ContainerStopApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Jersey configuration class.
 *
 * @author pabbott
 */
@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ContainerInfoApi.class);
        register(ContainerStopApi.class);
    }
}