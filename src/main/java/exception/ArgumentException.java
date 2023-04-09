package exception;

public class ArgumentException extends ApplicationException {

    public ArgumentException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ArgumentException(ErrorCode errorCode, String expected, String received) {
        this.errorCode = errorCode;
        this.expected = expected;
        this.received = received;
    }

    @Override
    public String getErrorMessage() {
        switch (errorCode) {
            case MISSING_REQUIRED_ARGUMENTS:
                return String.format("Expected the following required arguments: %s. But received: %s", expected, received);
            case INVALID_ARGUMENT:
                return String.format("Expected one of the following arguments: %s. But received: %s", expected, received);
        }
        return "Argument exception was thrown with unknown error code!";
    }
}
