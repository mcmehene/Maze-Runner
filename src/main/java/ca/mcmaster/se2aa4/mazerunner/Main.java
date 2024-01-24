package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        // Welcome Message
        logger.info("********* Starting Maze Runner *********");

        // Path Processing/Comparing Results
        if (Configuration.flagStatus(args)) {

            logger.info(UserPathCompare.userAnswer());
        } else {

            MazePrinter mazePrinter = new MazePrinter();
            logger.info("Full Path Solution: " + mazePrinter.cardinalToCanonical());
            logger.info("Factored Path Solution: " + mazePrinter.canonicalToFactored());
        }

        // Le Fin.
        logger.info("********** End of Maze Runner **********");
    }
}
