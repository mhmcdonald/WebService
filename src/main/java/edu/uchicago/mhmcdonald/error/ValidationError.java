package edu.uchicago.mhmcdonald.error;

/**
 * Created by markmcdonald on 8/23/16.
 */

public class ValidationError {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

