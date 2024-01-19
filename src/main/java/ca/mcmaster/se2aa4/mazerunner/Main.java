package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        // Run configuration of flags
        Configuration.arguments = args;
        MazeSolver mazeSolver = new MazeSolver();
        String test = mazeSolver.printMaze();

        // ################################### NOTE ########################################
        // Make Maze Solver the class to be objectified. Main does not need to know how or
        // enact the maze creation and delegate it to mazeSolver. Fix Achieved
        // Now the only thing main needs to retrieve from MazeSolver is the solution path
        // itself.
        // ################################### NOTE #########################################

        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
