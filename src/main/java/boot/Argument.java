package boot;

import exception.ArgumentException;

import java.util.Arrays;
import java.util.stream.Stream;

import static exception.ErrorCode.INVALID_ARGUMENT;

public enum Argument {
    RUN_AS("--runAs"),
    SOURCE("--source"),
    DATA_STRUCTURE("--structure"),
    EXERCISE("--exercise");

    private String argString;

    Argument(String argString) {
        this.argString = argString;
    }

    @Override
    public String toString() {
        return argString;
    }

    public static Argument fromString(String argString) throws ArgumentException {
        return Stream.of(values())
                .filter(argument -> argument.argString.equals(argString))
                .findFirst()
                .orElseThrow(() -> new ArgumentException(INVALID_ARGUMENT, Arrays.asList(values()).toString(), argString));
    }
}
