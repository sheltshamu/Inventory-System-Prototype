package zw.co.afrosoft.exception;

public class NoRecordExistException extends BusinessException {

    private final String recordName;
    private final String identifierName;
    private final Object identifierValue;

    public NoRecordExistException(String message, String recordName, String identifierName, Object identifierValue) {
        super(message);
        this.recordName = recordName;
        this.identifierName = identifierName;
        this.identifierValue = identifierValue;
    }

    public String getRecordName() {
        return recordName;

    }

    public String getIdentifierName() {
        return identifierName;
    }

    public Object getIdentifierValue() {
        return identifierValue;
    }
}
