package exception;

public class FactoryException extends ApplicationException {

    public FactoryException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public FactoryException(ErrorCode errorCode, String expected, String received) {
        this.errorCode = errorCode;
        this.expected = expected;
        this.received = received;
    }

    @Override
    public String getErrorMessage() {
        switch (errorCode) {
            case UNKNOWN_INTERFACE_TYPE:
                return String.format("Expected one of the following interface types: %s. But received: %s", expected, received);
            case UNKNOWN_DATA_PARSER_TYPE:
                return String.format("Expected one of the following data parser types: %s. But received: %s", expected, received);
            case UNKNOWN_DATA_READER_TYPE:
                return String.format("Expected one of the following data reader types: %s. But received: %s", expected, received);
            case UNKNOWN_DATA_PROCESSOR:
                return String.format("Expected one of the following data processor types: %s. But received: %s", expected, received);
            case NOT_IMPLEMENTED:
                return "This interface method has no implementation for factory instance";
        }
        return "Factory exception was thrown with unknown error code!";
    }
}
