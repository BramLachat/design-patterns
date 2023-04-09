package parser;

import java.util.List;

/**
 * Parse the input data into a usable data structure
 */
public interface DataParser {
    // TODO: return abstraction: ParsedData interface
    List<List<String>> getParsedData(String rawData);
}
