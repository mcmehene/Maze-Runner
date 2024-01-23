package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class MazeToGrid {
    private static final Logger logger = LogManager.getLogger();
    private static final String path = Configuration.filepath;

    // Dimensions computes the size of the maze, that is how wide and how long it is.
    private static int[] dimensions() {
        int rows = 0;
        int columns = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                rows++;
                if (line.length() > columns) {
                    columns = line.length();
                }
            }
        } catch (Exception efnf1) {
            logger.error("rowDimension File Error: " + efnf1);
            logger.error("Exiting Program.");
            System.exit(1);
        }
        return new int[]{rows, columns};
    }

    // Maze Array Converts the Maze into a Matrix for Program.
    public String[][] mazeArray() {
        int[] dimensions = dimensions();
        int rows = dimensions[0];
        int columns = dimensions[1];
        String[][] maze = new String[rows][columns];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {

                // Null Line Checker, Fill String Line with Spaces so Readable
                if (Objects.equals(line = reader.readLine(), "")) {
                    logger.info("Null Line");
                    line = " ".repeat(columns);
                }

                // If the lines have the same length as columns then regular process...
                if (line.length() == columns) {
                    for (int idx = 0; idx < columns; idx++) {
                        if (line.charAt(idx) == '#') {
                            maze[rowIndex][idx] = "#";
                        } else if (line.charAt(idx) == ' ') {
                            maze[rowIndex][idx] = " ";
                        }
                    }
                // ...otherwise we must add the missing spaces, so we respect matrix bounds.
                } else {
                    int difference = columns - line.length();
                    String missingChars = " ".repeat(Math.max(0,difference));
                    line += missingChars;
                    for (int idx = 0; idx < columns; idx++) {
                        if (line.charAt(idx) == '#') {
                            maze[rowIndex][idx] = "#";
                        } else if (line.charAt(idx) == ' ') {
                            maze[rowIndex][idx] = " ";
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception efnf2) {
            logger.error("makeArray Error: " + efnf2);
            logger.error("Exiting Program.");
            System.exit(1);
        }
        return maze;
    }
}
