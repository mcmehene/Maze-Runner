package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class MazeToGrid {
    private static final Logger logger = LogManager.getLogger();
    public static int[][] maze;
    public int column;
    public int row;
    public static int[][] maze(String path) {
        // Reads file and puts the walls and spaces as 1 and 0 in grid
        // Then save the maze to the maze variable for access outside class
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            int rowIndex = -1;
            while ((line = reader.readLine()) != null) {
                rowIndex++;
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        maze[rowIndex][idx] = 1;
                        System.out.println(1);
                    } else if (line.charAt(idx) == ' ') {
                        maze[rowIndex][idx] = 0;
                        System.out.println(1);
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch (Exception efnf) {
            logger.error("Error: " + efnf);
            logger.error("Exiting Program.");
            System.exit(1);
        }
        return new int[][]{{0,1}};
    }
}
