package client;

import boot.Argument;

import java.util.Map;

public class UserInterfaceAPI implements UserInterface {
    @Override
    public Map<RunParameter, String> getRunParameters(Map<Argument, String> bootArguments) {
        System.out.println("TODO: UserInterfaceAPI - getRunParameters");
        return null;
    }
}
