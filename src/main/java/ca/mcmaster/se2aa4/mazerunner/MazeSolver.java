package ca.mcmaster.se2aa4.mazerunner;

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

    private boolean recursiveSolution(String[][] mazeInput, int row, int column) {

        // Check End Coordinate Status: Yes = Return Path, No = Continue Recursion
        //System.out.print("Current: " + row + " Current: "+column + "\n");
        //System.out.print("END COORDINATE: "+ rowEndCoordinate + " END COLUMN: " + (columns -1));
        //System.out.println();
        if (row == rowEndCoordinate && column == columns - 1) {
            solution += "E";
            maze[rowEndCoordinate][columns-1] = "*";
            return true;
        }

        // Prevents arrays moving out of bounds
        if ((row >= 0 && row < mazeInput.length) && (column >= 0 && column < mazeInput[0].length) && mazeInput[row][column].equals(" ")) {
            maze[row][column] = "T";
            // SOUTH
            if (recursiveSolution(mazeInput,row + 1, column)) {
                solution += "S";
                maze[row][column] = "*";
                return true;
            }
            // EAST
            if (recursiveSolution(mazeInput,row,column + 1)) {
                solution += "E";
                maze[row][column] = "*";
                return true;
            }
            // WEST
            if (recursiveSolution(mazeInput, row,column - 1)) {
                solution += "W";
                maze[row][column] = "*";
                return true;
            }
            // NORTH
            if (recursiveSolution(mazeInput,row - 1, column)) {
                solution += "N";
                maze[row][column] = "*";
                return true;
            }
        }
        return false;
    }

    public String finalPath() {
        findStartCoordinates();
        findEndCoordinates();
        if (recursiveSolution(maze, rowStartCoordinate,0)) {
            return solution;
        }
        return "NO PATH";
    }

    public void printMaze() {
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
    }
}
