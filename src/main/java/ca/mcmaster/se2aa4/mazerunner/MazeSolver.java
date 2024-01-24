package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    private static String solution;

    // COMPUTATION METHODS: findStateCoordinates, findEndCoordinates, recursiveSolution
    private static int findStartCoordinates(String[][] maze) {
        // Determine where we begin the search
        int start = 0;
        int rowStartCoordinate = 0;
        boolean coordinateNotFound = true;
        while (coordinateNotFound) {
            if (maze[start][0].equals(" ")) {
                rowStartCoordinate = start;
                coordinateNotFound = false;
            }
            start++;
        }
        return rowStartCoordinate;
    }

    private static int findEndCoordinates(String[][] maze) {
        // Determine the final coordinate of the search, so we can check if end reached
        int end = 0;
        int rowEndCoordinate = 0;
        boolean coordinateNotFound = true;
        while (coordinateNotFound) {
            if (maze[end][maze[0].length - 1].equals(" ")) {
                rowEndCoordinate = end;
                coordinateNotFound = false;
            }
            end++;
        }
        return rowEndCoordinate;
    }

    private static boolean recursiveSolution(String[][] mazeInput, int row, int column, int rowEnd) {
        // Check if we have reached the end of the maze. If we have, put an east marker to say exit
        // and place a star to complete the path through the printed maze.
        if (row == rowEnd && column == mazeInput[0].length - 1) {
            solution += "E";
            mazeInput[rowEnd][mazeInput[0].length - 1] = "*";
            return true;
        }

        // Prevents arrays moving out of bounds
        if ((row >= 0 && row < mazeInput.length) && (column >= 0 && column < mazeInput[0].length) && mazeInput[row][column].equals(" ")) {
            mazeInput[row][column] = "T";
            // SOUTH DIRECTION
            if (recursiveSolution(mazeInput,row + 1, column, rowEnd)) {
                solution += "S";
                return true;
            }
            // EAST DIRECTION
            if (recursiveSolution(mazeInput,row,column + 1, rowEnd)) {
                solution += "E";
                return true;
            }
            // WEST DIRECTION
            if (recursiveSolution(mazeInput, row,column - 1, rowEnd)) {
                solution += "W";
                return true;
            }
            // NORTH DIRECTION
            if (recursiveSolution(mazeInput,row - 1, column, rowEnd)) {
                solution += "N";
                return true;
            }
        }
        return false;
    }

    public static String finalPath() {
        MazeToGrid mazeToGrid = new MazeToGrid();
        String[][] maze = mazeToGrid.mazeArray();
        solution = "";
        recursiveSolution(maze, findStartCoordinates(maze),0, findEndCoordinates(maze));
        return solution;
    }
}
