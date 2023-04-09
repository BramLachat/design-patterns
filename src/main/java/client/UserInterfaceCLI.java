package client;

import boot.Argument;

import java.util.HashMap;
import java.util.Map;

public class UserInterfaceCLI implements UserInterface {
    private final Map<RunParameter, String> runParameters = new HashMap<>();

    @Override
    public Map<RunParameter, String> getRunParameters(Map<Argument, String> bootArguments) {
        runParameters.put(RunParameter.FILE_PATH, bootArguments.get(Argument.SOURCE));
        runParameters.put(RunParameter.FILE_TYPE, bootArguments.get(Argument.DATA_STRUCTURE));
        runParameters.put(RunParameter.EXERCISE, bootArguments.get(Argument.EXERCISE));
        return runParameters;
    }
}
