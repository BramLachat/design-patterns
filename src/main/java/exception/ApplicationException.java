package exception;

public abstract class ApplicationException extends Exception {
    protected ErrorCode errorCode;
    protected String expected;
    protected String received;

    public abstract String getErrorMessage();
}
