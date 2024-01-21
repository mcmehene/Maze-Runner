package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // Run configuration of flags.
        logger.info("********* Starting Maze Runner *********");
        Configuration.arguments = args;
        // ################################### NOTE ########################################
        // Make Maze Solver the class to be objectified. Main does not need to know how or
        // enact the maze creation and delegate it to mazeSolver. Fix Achieved
        // Now the only thing main needs to retrieve from MazeSolver is the solution path
        // itself.
        // ################################### NOTE #########################################

        // Compute the maze path.
        logger.info("**** Maze Paths ****");
        logger.info("Full Path Solution: " + MazeSolver.cardinalToCanonical());
        logger.info("Factored Path Solution: " + MazeSolver.canonicalToFactored());
        // Printing the maze.
        MazeSolver.printMaze();
        // Le Fin.
        logger.info("** End of MazeRunner **");
    }
}
