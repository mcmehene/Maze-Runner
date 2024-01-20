package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public class Configuration {
    public static String[] arguments;
    private static final Logger logger = LogManager.getLogger();
    private static String filepath;
    public static String iFlag() {
        // Read i flag and return its path if valid
        // Read p and return status of p to determine if we should evaluate maze
        // and print path or compute the users inputted path

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
}
