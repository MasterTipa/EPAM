package Testing.restservice;

import java.util.Date;

public class ApiException {
    private final String message; //user error message
    private final String details; //details containing the place of error
    private final String httpStatus; //error status
    private final Date timestamp; //date and time output

    public ApiException(String message, String details, String httpStatus, Date timestamp){
        this.message = message;
        this.details = details;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
    public String getMessage(){
        return message;
    }

    public String getDetails(){
        return details;
    }

    public String getHttpStatus(){
        return httpStatus;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }
}
