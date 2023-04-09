package result;

public class ExecutionResultCalorieCount implements ExecutionResult {
    private int maxCalorieElf;
    private int maxCalorieCount;

    public ExecutionResultCalorieCount(int maxCalorieElf, int maxCalorieCount) {
        this.maxCalorieElf = maxCalorieElf;
        this.maxCalorieCount = maxCalorieCount;
    }

    @Override
    public void update(ExecutionResult executionResult) {
        ExecutionResultCalorieCount calorieCountResult = (ExecutionResultCalorieCount) executionResult;
        this.maxCalorieElf = calorieCountResult.maxCalorieElf;
        this.maxCalorieCount = calorieCountResult.maxCalorieCount;
    }

    @Override
    public String getResultString() {
        return String.format("maxCalorieElf: %s %nmaxCalorieCount: %s", maxCalorieElf, maxCalorieCount);
    }

    @Override
    public boolean hasBetterResult(ExecutionResult executionResult) {
        ExecutionResultCalorieCount calorieCountResult = (ExecutionResultCalorieCount) executionResult;
        return this.maxCalorieCount > calorieCountResult.maxCalorieCount;
    }
}
