package mediator;

import boot.Argument;
import boot.BootInitializer;
import client.RunParameter;
import client.UserInterface;
import client.UserInterfaceFactory;
import exception.ApplicationException;
import exception.FactoryException;
import parser.DataParser;
import parser.DataParserFactory;
import processor.DataProcessor;
import processor.DataProcessorFactory;
import reader.DataInputReader;
import reader.DataReaderFactory;
import result.ExecutionResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mediator {
    private Map<ComponentTypes, MediatorComponent> mediatorComponentMap = new HashMap<>();
    private Map<Argument, String> bootArguments;
    private Map<RunParameter, String> runParameters;
    private String inputData;
    List<List<String>> parsedData;

    private ExecutionResult executionResult;

    public void registerMediatorComponent(ComponentTypes componentType, MediatorComponent mediatorComponent) {
        mediatorComponentMap.put(componentType, mediatorComponent);
    }

    public void run() throws ApplicationException {
        readBootArguments();
        initializeRunParameters();
        readInputData();
        parseInputData();
        processInputData();
        returnExecutionResult();
    }

    private void readBootArguments() {
        MediatorComponent mediatorComponent = mediatorComponentMap.get(ComponentTypes.BOOT_INITIALIZER);
        BootInitializer bootInitializer = (BootInitializer) mediatorComponent;
        bootArguments = bootInitializer.getBootArguments();
    }

    private void initializeRunParameters() throws FactoryException {
        MediatorComponent mediatorComponent = mediatorComponentMap.get(ComponentTypes.USER_INTERFACE);
        UserInterfaceFactory userInterfaceFactory = (UserInterfaceFactory) mediatorComponent;
        UserInterface userInterface = userInterfaceFactory.getUserInterface(bootArguments.get(Argument.RUN_AS));
        runParameters = userInterface.getRunParameters(bootArguments);
    }

    private void readInputData() throws ApplicationException {
        MediatorComponent mediatorComponent = mediatorComponentMap.get(ComponentTypes.DATA_READER);
        DataReaderFactory dataReaderFactory = (DataReaderFactory) mediatorComponent;
        DataInputReader dataInputReader = dataReaderFactory.getDataReader("FILE_READER");
        inputData = dataInputReader.getInputData(runParameters);
    }

    private void parseInputData() throws FactoryException {
        MediatorComponent mediatorComponent = mediatorComponentMap.get(ComponentTypes.DATA_PARSER);
        DataParserFactory dataParserFactory = (DataParserFactory) mediatorComponent ;
        DataParser dataParser = dataParserFactory.getDataParser(runParameters.get(RunParameter.FILE_TYPE));
        parsedData = dataParser.getParsedData(inputData);
    }

    private void processInputData() throws FactoryException {
        MediatorComponent mediatorComponent = mediatorComponentMap.get(ComponentTypes.DATA_PROCESSOR);
        DataProcessorFactory dataProcessorFactory = (DataProcessorFactory) mediatorComponent ;
        DataProcessor dataProcessor = dataProcessorFactory.getDataProcessor(runParameters.get(RunParameter.EXERCISE));
        executionResult = dataProcessor.getResult(parsedData);
    }

    private void returnExecutionResult() {
        System.out.println(executionResult.getResultString());
    }

    public enum ComponentTypes {
        BOOT_INITIALIZER,
        USER_INTERFACE,
        DATA_PARSER,
        DATA_READER,
        DATA_PROCESSOR,
    }
}
