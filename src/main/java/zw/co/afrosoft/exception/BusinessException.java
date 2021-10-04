package zw.co.afrosoft.exception;

public class BusinessException extends RuntimeException{
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
