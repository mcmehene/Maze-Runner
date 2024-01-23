package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    private static int rowStartCoordinate;
    private static int rowEndCoordinate;
    private static String solution = "";

    // COMPUTATION METHODS: findStateCoordinates, findEndCoordinates, recursiveSolution
    private static void findStartCoordinates(String[][] maze) {
        // Determine where we begin the search
        int start = 0;
        //int rowStartCoordinate = 0;
        boolean coordinateNotFound = true;
        while (coordinateNotFound) {
            if (maze[start][0].equals(" ")) {
                rowStartCoordinate = start;
                coordinateNotFound = false;
            }
            start++;
        }
    }

    private static void findEndCoordinates(String[][] maze) {
        // Determine the final coordinate of the search, so we can check if end reached
        int end = 0;
        //int rowEndCoordinate = 0;
        boolean coordinateNotFound = true;
        while (coordinateNotFound) {
            if (maze[end][maze[0].length - 1].equals(" ")) {
                rowEndCoordinate = end;
                coordinateNotFound = false;
            }
            end++;
        }
    }

    private static boolean recursiveSolution(String[][] mazeInput, int row, int column) {
        // Check if we have reached the end of the maze. If we have, put an east marker to say exit
        // and place a star to complete the path through the printed maze.
        if (row == rowEndCoordinate && column == mazeInput[0].length - 1) {
            solution += "E";
            mazeInput[rowEndCoordinate][mazeInput[0].length - 1] = "*";
            return true;
        }

        // Prevents arrays moving out of bounds
        if ((row >= 0 && row < mazeInput.length) && (column >= 0 && column < mazeInput[0].length) && mazeInput[row][column].equals(" ")) {
            mazeInput[row][column] = "T";
            // SOUTH DIRECTION
            if (recursiveSolution(mazeInput,row + 1, column)) {
                solution += "S";
                //mazeInput[row][column] = "*";
                return true;
            }
            // EAST DIRECTION
            if (recursiveSolution(mazeInput,row,column + 1)) {
                solution += "E";
                //mazeInput[row][column] = "*";
                return true;
            }
            // WEST DIRECTION
            if (recursiveSolution(mazeInput, row,column - 1)) {
                solution += "W";
                //mazeInput[row][column] = "*";
                return true;
            }
            // NORTH DIRECTION
            if (recursiveSolution(mazeInput,row - 1, column)) {
                solution += "N";
                //mazeInput[row][column] = "*";
                return true;
            }
        }
        return false;
    }

    public static String finalPath(String[][] maze) {
        findStartCoordinates(maze);
        findEndCoordinates(maze);
        recursiveSolution(maze, rowStartCoordinate,0);
        return solution;
    }
}
