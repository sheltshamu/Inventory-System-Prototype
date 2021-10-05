package zw.co.afrosoft.exception;

public class MissingFieldException extends BusinessException{
   private String fieldName;

    public MissingFieldException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
