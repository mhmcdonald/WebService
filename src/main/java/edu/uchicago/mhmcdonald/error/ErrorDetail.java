package edu.uchicago.mhmcdonald.error;

/**
 * Created by markmcdonald on 8/23/16.
 * ErrorDetail for validation class
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorDetail {

    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;
    private Map<String, List<ValidationError>> errors = new HashMap<String, List<ValidationError>>();

    public Map<String, List<ValidationError>> getErrors() {
        return errors;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
