package ecommerce.api.product.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String statusCode;

    public ExceptionResponse(LocalDateTime timestamp, String message, String statusCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.statusCode = statusCode;
    }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
    
    

}
