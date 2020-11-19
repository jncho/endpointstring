package es.gt.endpointstring.model;

import org.springframework.http.HttpStatus;

public class StringRecordError {

    private HttpStatus status;
    private String error;
    private String path;

    public StringRecordError(HttpStatus status, String error, String path) {
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
