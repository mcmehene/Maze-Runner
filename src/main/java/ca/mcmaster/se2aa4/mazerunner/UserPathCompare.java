package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// COMPARE CORRECTNESS OF USER PATH TO COMPUTED
public class UserPathCompare {
    private static final Logger logger = LogManager.getLogger();
    private static boolean determinePathType() {
        if (UserPathResult.validInput()) {

        } else {
            logger.info("Invalid User Path Input");
            logger.info("Exiting Program");
            System.exit(1);
        }
        return true;
    }

    public static String factoredCheck() {
        return "";
    }

    public static String canonicalCheck() {
        return "";
    }
}
