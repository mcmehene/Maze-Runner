package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        // Welcome Message
        logger.info("********* Starting Maze Runner *********");

        // Path Processing/Comparing Results
        Configuration config = new Configuration();
        if (config.flagStatus(args)) {
            logger.info(UserPathCompare.userAnswer());
        } else {

            MazePrinter mazePrinter = new MazePrinter();
            logger.info("Full Path Solution: " + mazePrinter.fullPath());
            logger.info("Factored Path Solution: " + mazePrinter.factored());
        }

        logger.info("West To East " + UserPathToCardinal.westToEast());
        logger.info("East To West " + UserPathToCardinal.eastToWest());
        // Le Fin.
        logger.info("********** End of Maze Runner **********");
    }
}
