package exception;

public class ReadException extends ApplicationException {
    private String reason;

    public ReadException(ErrorCode errorCode, String reason) {
        this.errorCode = errorCode;
        this.reason = reason;
    }

    @Override
    public String getErrorMessage() {
        switch (errorCode) {
            case FILE_READ_EXCEPTION:
                return String.format("Failed to read input data from file. Reason: %s", reason);
        }
        return "Read exception was thrown with unknown error code!";
    }
}
