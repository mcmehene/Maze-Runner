package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        // Run configuration of flags.
        logger.info("********* Starting Maze Runner *********");

        // Path Processing/Comparing Results
        if (Configuration.flagStatus(args)) {
            logger.info("User Input is " + UserPathResult.validInput());
        } else {
            logger.info("Full Path Solution: " + MazePrinter.cardinalToCanonical());
            logger.info("Factored Path Solution: " + MazePrinter.canonicalToFactored());
        }

        // 1. Read p flag and compare computed non-factored path to non-factored path
        //    or computed factored path to user factored path of the user.
        //    Then return required to be output per business specifications.

        // Le Fin.
        logger.info("** End of MazeRunner **");
    }
}
