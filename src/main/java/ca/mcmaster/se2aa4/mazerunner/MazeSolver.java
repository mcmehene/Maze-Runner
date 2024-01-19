package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class MazeSolver {
    public static String[][] maze = MazeToGrid.mazeArray();
    private static final int rows = MazeToGrid.rows;
    private static final int columns = MazeToGrid.columns;

    public int findStartCoordinates() {
        // Determine where we begin the search
        return 0;
    }

    public int findEndCoordinates() {
        // Determine the final coordinate of the search, so we can check if end reached
        return 0;
    }

    public String recursiveSolution() {
        // I'm not yet sure how to move through maze, but I believe recursion is best bet.
        return "Path";
    }

    public String finalPath() {
        // Returns the path to be checked/printed depending on condition of program
        return "Walking Skeleton";
    }

    public String printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        return "Printed";
    }

}
