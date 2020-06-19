package com.pma.test.containers.service;

import com.pma.test.containers.model.ContainerInfo;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Interacts with Docker API to provide info on running containers and stop them.
 *
 * @author pabbott
 */
@Service
public class ContainerService {

    private final static Logger LOGGER = Logger.getLogger(ContainerService.class.getName());
    //How long to wait before simply killing a container that is not responding. Hardcoding for now.
    private final int SECONDS_TO_WAIT_BEFORE_KILLING = 5;

    /**
     * Holds connection to docker client. Should maintain for lifetime of the API.
     */
    private DockerClient dockerClient;

    public ContainerService() {
        try {
            this.dockerClient = DefaultDockerClient.fromEnv().build();
        }
        catch(DockerCertificateException e) {
            LOGGER.severe("Could not connect to docker");
            System.exit(1);
        }
    }

    public List<ContainerInfo> getRunningContainers() throws DockerException, InterruptedException {

        List<com.spotify.docker.client.messages.Container> containers = dockerClient.listContainers();

        return containers.stream()
                .map(container ->
                        //todo: Unsure if it's possible for containers to have no name and therefore for this
                        //to produce index error. Test this.
                    new ContainerInfo(container.id(), container.names().get(0))
                ).collect(Collectors.toList());
    }

    public void stop(String contId) throws DockerException, InterruptedException {
        dockerClient.stopContainer(contId, SECONDS_TO_WAIT_BEFORE_KILLING);
    }
}