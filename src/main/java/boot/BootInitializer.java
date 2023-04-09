package boot;

import exception.ArgumentException;
import mediator.MediatorComponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static boot.Argument.*;
import static exception.ErrorCode.MISSING_REQUIRED_ARGUMENTS;

public class BootInitializer implements MediatorComponent {
    private final Map<Argument, String> parsedArgumentsMap = new HashMap<>();
    private final Set<Argument> requiredArgs = Set.of(
            RUN_AS
    );

    public BootInitializer(String[] arguments) throws ArgumentException {
        parseStringArguments(arguments);
        if (!parsedArgumentsMap.keySet().containsAll(requiredArgs)) {
            throw new ArgumentException(MISSING_REQUIRED_ARGUMENTS, requiredArgs.toString(), parsedArgumentsMap.keySet().toString());
        }
    }

    private void parseStringArguments(String[] arguments) throws ArgumentException {
        List<String> argumentList = Arrays.asList(arguments);
        Iterator argumentIterator = argumentList.iterator();
        while (argumentIterator.hasNext()) {
            String argKey = (String) argumentIterator.next();
            String argValue = (String) argumentIterator.next();
            Argument argEnum = Argument.fromString(argKey);
            parsedArgumentsMap.put(argEnum, argValue);
        }
    }

    public Map<Argument, String> getBootArguments() {
        return parsedArgumentsMap;
    }
}
