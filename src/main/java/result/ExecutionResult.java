package result;

public interface ExecutionResult {
    void update(ExecutionResult executionResult);

    String getResultString();

    public boolean hasBetterResult(ExecutionResult executionResult);
}
