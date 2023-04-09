package reader;

import client.RunParameter;

import java.util.Map;

public class DataInputReaderMock implements DataInputReader {
    private String inputData;

    private void readDataFromSource(String dataSource) {
        this.inputData = dataSource;
    }

    @Override
    public String getInputData(Map<RunParameter, String> runParameters) {
        readDataFromSource(runParameters.get(RunParameter.FILE_PATH));
        return inputData;
    }
}
