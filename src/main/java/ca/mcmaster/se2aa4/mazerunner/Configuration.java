package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public class Configuration {
    public Configuration(String[] args) {
        arguments = args;
    }
    private static String[] arguments;
    private static final Logger logger = LogManager.getLogger();

    public static String iFlag() {
        // Read i flag and return its path if valid
        // Read p and return status of p to determine if we should evaluate maze
        // and print path or compute the users inputted path
        String filepath = "";
        Options options = new Options();
        options.addOption("i", true, "Inputting the Maze Using i Flag");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, arguments);
            filepath = cmd.getOptionValue("i");
            logger.info("The filepath is: " + filepath);
        } catch (Exception pe) {
            logger.error("Error: " + pe);
            logger.error("Exiting Program.");
            System.exit(1);
        }
        return filepath;
    }

    public static String pFlag() {
        Options options = new Options();
        options.addOption("p", true, "User Inputted Path for Comparing");
        CommandLineParser parser = new DefaultParser();
        String userPath;
        try {
            CommandLine cmd = parser.parse(options, arguments);
            userPath = cmd.getOptionValue("p");
            logger.info("User Guess Path: " + userPath);
        } catch (Exception pe) {
            logger.info("P Flag does not Exist.");
            return null;
        }
        return userPath;
    }

    public boolean processFlags() {
        return pFlag() != null;
    }
}
