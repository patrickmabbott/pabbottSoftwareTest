package com.pma.test.containers.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.pma.test.containers.model.ContainerInfo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interacts with Docker API to provide info on running containers and stop them.
 *
 * @author pabbott
 */
@Service
public class ContainerService {

    /**
     * Holds connection to docker client. Should maintain for lifetime of the API.
     */
    DockerClient dockerClient;

    public ContainerService() {
        DefaultDockerClientConfig.Builder config
                = DefaultDockerClientConfig.createDefaultConfigBuilder();
        this.dockerClient = DockerClientBuilder.getInstance().build();
    }

    public List<ContainerInfo> getRunningContainers() {

        List<Container> containers = dockerClient.listContainersCmd().exec();

        return containers.stream()
                .map(container ->
                    new ContainerInfo(container.getId(), container.getImage())
                ).collect(Collectors.toList());
//        return Arrays.asList(new ContainerInfo("ex1", "e1"),
//                new ContainerInfo("ex2", "e2"));
    }

    public void stop(String contId) {
        dockerClient.stopContainerCmd(contId);
    }
}