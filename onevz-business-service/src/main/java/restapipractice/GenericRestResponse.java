package restapipractice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericRestResponse implements Serializable {
    private int status;
    private List<RestError> errors;

    public GenericRestResponse() {

    }
    public List<RestError> getErrors() {
        if(this.errors ==null) {
            this.errors = new ArrayList();
        }
        return this.errors;
    }
    public int getStatus() {
        return this.getErrors()==null ? -1 :1;
    }

    public void setStatus(int status) {
        this.status = status;
    }

 public void addError(String message) {
        RestError restError = new RestError(message);
        this.getErrors().add(restError);
 }

}
