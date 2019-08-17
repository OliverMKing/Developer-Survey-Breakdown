package com.stack.data.domain;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ExceptionResponse {

    private HttpStatus status;
    private Integer statusCode;
    private String path;
    private String time;

    public ExceptionResponse(int status, Map<String, Object> errorAttributes) {
        this.status = HttpStatus.valueOf(status);
        this.statusCode = status;
        this.path = (String) errorAttributes.get("path");
        this.time = errorAttributes.get("timestamp").toString();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
