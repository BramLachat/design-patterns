package processor;

import result.ExecutionResult;

import java.util.List;

public interface DataProcessor {
    ExecutionResult getResult(List<List<String>> parsedData);
}
