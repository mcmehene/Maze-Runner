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

            UserPathCompare userPathCompare = new UserPathCompare();
            logger.info(userPathCompare.userAnswer());

        } else {

            MazePrinter mazePrinter = new MazePrinter();
            logger.info("Full Path Solution: " + mazePrinter.pathCalculation());
            logger.info("Factored Path Solution: " + mazePrinter.factored());
        }

        // Le Fin.
        logger.info("********** End of Maze Runner **********");
    }
}
