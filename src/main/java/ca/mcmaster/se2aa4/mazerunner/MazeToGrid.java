package ca.mcmaster.se2aa4.mazerunner;

import com.sun.source.tree.BreakTree;
import org.apache.logging.log4j.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class MazeToGrid {
    private static final Logger logger = LogManager.getLogger();
    private static final String path = Configuration.iFlag();
    public static int rows;
    public static int columns;

    // Dimensions computes the size of the maze, that is how wide and how long it is.
    private static void dimensions() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            boolean first = false;
            while ((line = reader.readLine()) != null) {
                rows++;
                if (!first) {
                    columns = line.length();
                    first = true;
                }
            }
        } catch (Exception efnf1) {
            logger.error("rowDimension File Error: " + efnf1);
            logger.error("Exiting Program.");
            System.exit(1);
        }
    }

    // Maze Array Converts the Maze into a Matrix for Program.
    public static String[][] mazeArray() {
        dimensions();
        String[][] maze = new String[rows][columns];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            int rowIndex = 0;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < columns; idx++) {
                    if (line.charAt(idx) == '#') {
                        maze[rowIndex][idx] = "#";
                        //System.out.print(maze[rowIndex][idx] + " ");
                    } else if (line.charAt(idx) == ' ') {
                        maze[rowIndex][idx] = " ";
                        //System.out.print(maze[rowIndex][idx] + " ");
                    }
                }
                //System.out.print(System.lineSeparator());
                rowIndex++;
            }
        } catch (Exception efnf2) {
            logger.error("Error: " + efnf2);
            logger.error("Exiting Program.");
            System.exit(1);
        }
        return maze;
    }
}
