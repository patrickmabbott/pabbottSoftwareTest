package com.pma.test.containers.model;

public class Result {

    public Result(final boolean success, final String message) {
        this.success = success;
        this.message = message;
    }

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
