package restapipractice;

import java.io.Serializable;

public class RestError implements Serializable {
private String message;
    public RestError(String message) {
        this.message = message;
    }
}
