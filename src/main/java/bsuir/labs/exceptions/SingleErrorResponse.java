package bsuir.labs.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"logref", "message"})
public class SingleErrorResponse {
    @JsonProperty(value = "logref")
    private String logref;
    @JsonProperty("message")
    private String message;

    public SingleErrorResponse(String logref, String message) {
        this.logref = logref;
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public String getMessage() {
        return message;
    }
}
