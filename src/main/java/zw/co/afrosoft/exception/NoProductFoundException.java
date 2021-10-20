package zw.co.afrosoft.exception;

public class NoProductFoundException extends BusinessException{
    private Object identifierValue;

    public NoProductFoundException(String message, Object identifierValue) {
        super(message);
        System.out.format("Product {0} not found",identifierValue);
        this.identifierValue=identifierValue;
    }

    public Object getIdentifierValue(){
        return identifierValue;
    }
}
