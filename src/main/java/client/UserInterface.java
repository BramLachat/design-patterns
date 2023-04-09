package client;

import boot.Argument;

import java.util.Map;

/**
 * dataSource: file, console, database, rest api
 * dataStructure: json, xml, csv, ...
 * exercise: calorie-count, ...
 *
 */
public interface UserInterface {
    Map<RunParameter, String> getRunParameters(Map<Argument, String> bootArguments);
}
