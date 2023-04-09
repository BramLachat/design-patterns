package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParserValueSeparated implements DataParser {
    private String valueSeparator;
    private final List<List<String>> parsedData = new ArrayList<>();

    public DataParserValueSeparated(DataParserFactory.DataParserType valueSeparator) {
        this.valueSeparator = valueSeparator.getSeparator();
    }

    private void parse(String rawData) {
        List<String> rawDataList = Arrays.asList(rawData.split(valueSeparator));
        List<String> scenarioDataItems = new ArrayList<>();
        for (String rawDataItem : rawDataList) {
            if (rawDataItem.isBlank()) {
                parsedData.add(scenarioDataItems);
                scenarioDataItems = new ArrayList<>();
            } else {
                scenarioDataItems.add(rawDataItem);
            }
        }
    }

    @Override
    public List<List<String>> getParsedData(String rawData) {
        parse(rawData);
        return parsedData;
    }
}
