package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // Run configuration of flags.
        logger.info("********* Starting Maze Runner *********");

        // Flag Processing
        Configuration config = new Configuration(args);

        // Path Processing/Comparing Results
        if (config.flagStatus()) {
            logger.info("User Input is " + UserPathResult.validInput());
        } else {
            logger.info("Full Path Solution: " + MazePrinter.cardinalToCanonical());
            logger.info("Factored Path Solution: " + MazePrinter.canonicalToFactored());
        }
        //MazeSolver.recursiveSolution(mazeToGrid1.mazeArray(), mazeToGrid1.rows, 0, );
        // 1. Make an instance of MazeToGrid mazeArray 3 times for COMPUTATION METHODS in
        //    MazeSolver so they each have their own separate maze to calculate with. (Clone).
        // 2. Move PRINTER METHODS to MazePrinter Class, then pull paths to print.
        //    So connection between MazeSolver and MazePrinter
        // 3. Read p flag and Compare Computed non-factored path to de-factored path (if factored)
        //    of the user. Then return required output per business specifications.

        // Le Fin.
        logger.info("** End of MazeRunner **");
    }
}
