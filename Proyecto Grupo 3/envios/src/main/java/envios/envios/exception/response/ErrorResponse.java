package envios.envios.exception.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int status;
    private String timestamp;
    private String path;

    public ErrorResponse(String message, int status, String path) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDate.now().toString();
        this.path = path;
    }

}
