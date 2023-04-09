package parser;

import exception.FactoryException;
import mediator.MediatorComponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static exception.ErrorCode.UNKNOWN_DATA_PARSER_TYPE;

public class DataParserFactory implements MediatorComponent {
    private final Map<DataParserType, DataParser> dataParserMap;

    public DataParserFactory() {
        dataParserMap = new HashMap<>();
        dataParserMap.put(DataParserType.XML, new DataParserXML());
        dataParserMap.put(DataParserType.JSON, new DataParserJSON());
        dataParserMap.put(DataParserType.COMMA, new DataParserValueSeparated(DataParserType.COMMA));
        dataParserMap.put(DataParserType.NEW_LINE, new DataParserValueSeparated(DataParserType.NEW_LINE));
        dataParserMap.put(DataParserType.CRNL, new DataParserValueSeparated(DataParserType.CRNL));
    }

    public DataParser getDataParser(String dataParserType) throws FactoryException {
        try {
            DataParserType dataParserEnum = DataParserType.valueOf(dataParserType.toUpperCase());
            DataParser dataParser = dataParserMap.get(dataParserEnum);
            return dataParser;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new FactoryException(UNKNOWN_DATA_PARSER_TYPE, Arrays.asList(DataParserType.values()).toString(), dataParserType);
        }
    }

    public enum DataParserType {
        JSON {
            public String getSeparator() {
                return null;
            }
        },
        XML {
            public String getSeparator() {
                return null;
            }
        },
        COMMA {
            public String getSeparator() {
                return ",";
            }
        },
        NEW_LINE {
            public String getSeparator() {
                return "\n";
            }
        },
        CRNL {
            public String getSeparator() {
                return "\r\n";
            }
        };

        public abstract String getSeparator();
    }
}
