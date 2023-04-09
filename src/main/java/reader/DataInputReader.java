package reader;

import client.RunParameter;
import exception.ReadException;

import java.util.Map;

/**
 * Read the input data into memory
 */
public interface DataInputReader {
    // TODO: return abstraction: RawData interface
    String getInputData(Map<RunParameter, String> runParameters) throws ReadException;
}
