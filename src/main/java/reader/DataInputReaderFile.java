package reader;

import client.RunParameter;
import exception.ErrorCode;
import exception.ReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class DataInputReaderFile implements DataInputReader {

    private String inputData;

    private void readDataFromSource(String dataSource) throws ReadException {
        try {
            inputData = new String(Files.readAllBytes(Paths.get(dataSource)));
        } catch (IOException e) {
            throw new ReadException(ErrorCode.FILE_READ_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public String getInputData(Map<RunParameter, String> runParameters) throws ReadException {
        readDataFromSource(runParameters.get(RunParameter.FILE_PATH));
        return inputData;
    }
}
