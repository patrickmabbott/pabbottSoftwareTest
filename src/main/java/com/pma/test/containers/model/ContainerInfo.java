package com.pma.test.containers.model;

/**
 * Holds information concerning a (running) container. Immutable.
 */
public class ContainerInfo {

    private String containerId;
    private String containerName;

    public ContainerInfo(final String containerId, final String containerName) {
        this.containerId = containerId;
        this.containerName = containerName;
    }

    public String getContainerId() {
        return containerId;
    }

    public String getContainerName() {
        return containerName;
    }
}
