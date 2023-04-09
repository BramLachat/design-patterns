package reader;

import exception.FactoryException;
import mediator.MediatorComponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static exception.ErrorCode.UNKNOWN_DATA_READER_TYPE;

public class DataReaderFactory implements MediatorComponent {
    private final Map<DataReaderType, DataInputReader> dataReaderMap;

    public DataReaderFactory() {
        dataReaderMap = new HashMap<>();
        dataReaderMap.put(DataReaderType.CONSOLE_READER, new DataInputReaderConsole());
        dataReaderMap.put(DataReaderType.FILE_READER, new DataInputReaderFile());
        dataReaderMap.put(DataReaderType.MOCK_READER, new DataInputReaderMock());
    }

    public DataInputReader getDataReader(String dataReaderType) throws FactoryException {
        try {
            DataReaderType dataReaderEnum = DataReaderType.valueOf(dataReaderType);
            return dataReaderMap.get(dataReaderEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new FactoryException(UNKNOWN_DATA_READER_TYPE, Arrays.asList(DataReaderType.values()).toString(), dataReaderType);

        }
    }

    public enum DataReaderType {
        CONSOLE_READER,
        FILE_READER,
        MOCK_READER;
    }
}
