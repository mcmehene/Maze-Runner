package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public record Configuration(String path, boolean pFlag) {
    private static final Logger logger = LogManager.getLogger();
    private static String filepath;
    public static Configuration load(String[] args) {
        // Read i flag and return its path if valid
        // Read p and return status of p to determine if we should evaluate maze
        // and print path or compute the users inputted path
        Options options = new Options();
        options.addOption("i",true, "Inputting the Maze Using i Flag");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            filepath = cmd.getOptionValue("i");
        } catch (Exception pe) {
            logger.error("Error" + pe);
        }
        // Obtain the path of the supposed text file from the i flag

        return new Configuration(filepath,false);
    }
}
