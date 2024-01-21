package ca.mcmaster.se2aa4.mazerunner;

import java.util.Objects;

public class MazeSolver {
    public static String[][] maze = MazeToGrid.mazeArray();
    private static final int rows = MazeToGrid.rows;
    private static final int columns = MazeToGrid.columns;
    private static int rowStartCoordinate;
    private static int rowEndCoordinate;
    private static String solution = "";

    private void findStartCoordinates() {
        // Determine where we begin the search
        int start = 0;
        boolean coordinateNotFound = true;
        while (coordinateNotFound) {
            if (maze[start][0].equals(" ")) {
                rowStartCoordinate = start;
                coordinateNotFound = false;
            }
            start++;
        }
    }

    private void findEndCoordinates() {
        // Determine the final coordinate of the search, so we can check if end reached
        int end = 0;
        boolean coordinateNotFound = true;
        while (coordinateNotFound) {
            if (maze[end][columns-1].equals(" ")) {
                rowEndCoordinate = end;
                coordinateNotFound = false;
            }
            end++;
        }
    }

    private void recursiveSolution(int row, int column) {

        // Check End Coordinate Status: Yes = Return Path, No = Continue Recursion
        if (row != rowEndCoordinate || column != columns - 1) {

            // Mark previous traversal. This will allow us to compute the path
            // and ensure we keep proceeding to exit.

            // Try to move forward: Wall = Turn Right & Record, Space = Record Movement

            // Prevents arrays moving out of bounds
            if ((row >= 1 && row < maze.length) && (column >= 1 && column < maze[0].length)) {

                // Step logic
                if (maze[row][column + 1].equals(" ")) {
                    // East
                    solution += "E";
                    recursiveSolution(row, column + 1);
                }
                if (maze[row + 1][column].equals(" ")) {
                    // South
                    solution += "S";
                    recursiveSolution(row + 1, column);
                }
                if (maze[row][column - 1].equals(" ")) {
                    // West
                    solution += "W";
                    recursiveSolution(row, column - 1);
                }
                if (maze[row - 1][column].equals(" ")) {
                    // North
                    solution += "N";
                    recursiveSolution(row - 1, column);
                }
            }
        }
    }

    public String finalPath() {
        findStartCoordinates();
        findEndCoordinates();
        recursiveSolution(rowStartCoordinate,0);
        return solution;
    }

    public String printMaze() {
        //findStartCoordinates();
        //findEndCoordinates();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        //System.out.println(rowStartCoordinate);
        //System.out.println(rowEndCoordinate);
        return "Printed";
    }
}
