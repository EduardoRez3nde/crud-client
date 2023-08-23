package com.rezende.CRUDClient.dto;

import java.time.Instant;

public class ExceptionError {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String path;

    public ExceptionError(Instant timeStamp, Integer status, String error, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
