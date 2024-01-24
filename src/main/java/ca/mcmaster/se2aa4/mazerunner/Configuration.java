package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public class Configuration {
    private static String filepath;
    private static String userGuess;
    private static final Logger logger = LogManager.getLogger();

    public static boolean flagStatus(String[] arguments) {

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

            logger.error("Flag Error: " + pe);
            logger.error("Exiting Program.");
            System.exit(1);

        }

        return false;
    }

    public static String filepath() {
        return filepath;
    }

    public static String userGuess() {
        return userGuess;
    }
}
