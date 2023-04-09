package processor;

import exception.ErrorCode;
import exception.FactoryException;
import mediator.MediatorComponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataProcessorFactory implements MediatorComponent {
    private final Map<ProcessorType, DataProcessor> dataProcessorMap;

    public DataProcessorFactory() {
        dataProcessorMap = new HashMap<>();
        dataProcessorMap.put(ProcessorType.CALORIE_COUNT, new DataProcessorCalorieCount());
    }

    public DataProcessor getDataProcessor(String processorType) throws FactoryException {
        try {
            ProcessorType processorEnum = ProcessorType.valueOf(processorType.toUpperCase());
            return dataProcessorMap.get(processorEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new FactoryException(ErrorCode.UNKNOWN_DATA_PROCESSOR, Arrays.asList(ProcessorType.values()).toString(), processorType);
        }
    }

    public enum ProcessorType {
        CALORIE_COUNT;
    }
}
