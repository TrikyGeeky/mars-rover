package mars.rover.main;

import mars.rover.services.DataExtractor;

public class Rover {

    public static void main(String[] args) {
        if (args.length == 0 || args.length > 1) {
            throw new IllegalArgumentException("The number of arguments must be one and it defines the path of the input file !!");
        }
        DataExtractor.extractDataFromFile(args[0]);
    }
}
