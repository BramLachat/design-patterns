package processor;

import result.ExecutionResult;
import result.ExecutionResultCalorieCount;

import java.util.List;

public class DataProcessorCalorieCount implements DataProcessor {
    private ExecutionResult calorieCountResult = new ExecutionResultCalorieCount(-1, 0);

    private void calculate(List<List<String>> parsedData) {
        int calorieElf = 0;
        for (List<String> scenarioDataItems: parsedData) {
            int calorieCount = 0;
            for (String dataItem: scenarioDataItems) {
                calorieCount += Integer.parseInt(dataItem);
            }
            ExecutionResultCalorieCount tempCalorieCount = new ExecutionResultCalorieCount(calorieElf, calorieCount);
            if (!calorieCountResult.hasBetterResult(tempCalorieCount)) {
                calorieCountResult = tempCalorieCount;
            }
            calorieElf++;
        }
    }

    @Override
    public ExecutionResult getResult(List<List<String>> parsedData) {
        calculate(parsedData);
        return calorieCountResult;
    }
}
