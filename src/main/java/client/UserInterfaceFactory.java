package client;

import exception.ErrorCode;
import exception.FactoryException;
import mediator.MediatorComponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.baeldung.com/java-replace-if-statements
 */
public class UserInterfaceFactory implements MediatorComponent {
    private final Map<InterfaceType, UserInterface> userInterfaceMap;

    public UserInterfaceFactory() {
        userInterfaceMap = new HashMap<>();
        userInterfaceMap.put(InterfaceType.CLI, new UserInterfaceCLI());
        userInterfaceMap.put(InterfaceType.API, new UserInterfaceAPI());
        userInterfaceMap.put(InterfaceType.CONSOLE, new UserInterfaceConsole());
    }

    public UserInterface getUserInterface(String interfaceType) throws FactoryException {
        try {
            InterfaceType interfaceEnum = InterfaceType.valueOf(interfaceType.toUpperCase());
            return userInterfaceMap.get(interfaceEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new FactoryException(ErrorCode.UNKNOWN_INTERFACE_TYPE, Arrays.asList(InterfaceType.values()).toString(), interfaceType);
        }
    }

    public enum InterfaceType {
        API,
        CLI,
        CONSOLE;
    }
}
