package client;

import boot.Argument;

import java.util.Map;

public interface UserInterface {
    Map<RunParameter, String> getRunParameters(Map<Argument, String> bootArguments);
}
