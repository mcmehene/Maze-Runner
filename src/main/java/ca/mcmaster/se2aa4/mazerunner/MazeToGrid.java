package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class MazeToGrid implements MazeCreator<String[][]> {
    private static final Logger logger = LogManager.getLogger();

    private static int[] dimensions() {

        int rows = 0;
        int columns = 0;
        Configuration config = new Configuration();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(config.filepath()));
            String line;

            while ((line = reader.readLine()) != null) {

                rows++;

                if (line.length() > columns) {

                    columns = line.length();
                }
            }

            reader.close();

        } catch (Exception efnf1) {

            logger.error("rowDimension File Error: " + efnf1);
            logger.error("Exiting Program.");
            System.exit(1);
        }

        return new int[]{rows, columns};
    }

    // Maze Array Converts the Maze into a Matrix for Program.
    public String[][] mazeCreator() {

        int[] dimensions = dimensions();
        int rows = dimensions[0];
        int columns = dimensions[1];

        String[][] maze = new String[rows][columns];
        Configuration config = new Configuration();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(config.filepath()));
            String line;

            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {

                // Null Line Checker, Fill String Line with Spaces so Readable
                if (Objects.equals(line = reader.readLine(), "")) {

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
