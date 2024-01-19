package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class MazeSolver {

    private static final Logger logger = LogManager.getLogger();
    private static final String path = Configuration.iFlag();
    public static String[][] maze = MazeToGrid.mazeArray();

    public static int findStartCoordinates() {
        // Determine where we begin the search
        return 0;
    }

    public static int findEndCoordinates() {
        // Determine the final coordinate of the search, so we can check if end reached
        return 0;
    }

    public static String recursiveSolution() {
        // I'm not yet sure how to move through maze, but I believe recursion is best bet.
        return "Path";
    }

    public static String finalPath() {
        // Returns the path to be checked/printed depending on condition of program
        return "Walking Skeleton";
    }
}
