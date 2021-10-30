package zw.co.afrosoft.dto;

public class ApiResponse<T> {
    private T payload;
    private String message;
    private ResponseCode code;

    public ApiResponse(T payload, String message, ResponseCode code) {
        this.payload = payload;
        this.message = message;
        this.code = code;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }
}
