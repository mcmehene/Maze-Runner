package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public class Configuration {
    private static String[] arguments;
    public static String filepath;
    public static String userGuess;
    public Configuration(String[] args) {
        arguments = args;
    }
    private static final Logger logger = LogManager.getLogger();

    public boolean flagStatus() {
        // Read i flag and return its path if valid
        // Read p and return status of p to determine if we should evaluate maze
        // and print path or compute the users inputted path
        Options options = new Options();
        options.addOption("i", true, "Inputting the Maze Using i Flag");
        options.addOption("p", true, "User Inputted Path for Comparing");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, arguments);
            if (cmd.hasOption("i") && !cmd.hasOption("p")) {
                filepath = cmd.getOptionValue("i");
                return false;
            } else if (cmd.hasOption("p") && cmd.hasOption("i")) {
                filepath = cmd.getOptionValue("i");
                userGuess = cmd.getOptionValue("p");
                return true;
            } else {
                return false;
            }
        } catch (Exception pe) {
            logger.error("iFlag Error: " + pe);
            logger.error("Exiting Program.");
            System.exit(1);
        }
        return false;
    }
}
