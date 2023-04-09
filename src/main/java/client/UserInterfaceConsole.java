package client;

import boot.Argument;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterfaceConsole implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<RunParameter, String> runParameters = new HashMap<>();

    @Override
    public Map<RunParameter, String> getRunParameters(Map<Argument, String> bootArguments) {
        askForDataSource();
        askForDataStructure();
        askForExercise();
        return runParameters;
    }

    private void askForDataSource() {
        System.out.println("Please enter the path to the input file: ");
        runParameters.put(RunParameter.FILE_PATH, scanner.nextLine());
    }

    private void askForDataStructure() {
        System.out.println("Please enter the type of file: ");
        runParameters.put(RunParameter.FILE_TYPE, scanner.nextLine());
    }

    private void askForExercise() {
        System.out.println("Please enter the exercise you want to run: ");
        runParameters.put(RunParameter.EXERCISE, scanner.nextLine());
    }
}
