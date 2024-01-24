package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver implements Solver {
    private static String solution;

    // COMPUTATION METHODS: findStateCoordinates, findEndCoordinates, recursiveSolution
    public int findStartCoordinates(String[][] maze) {

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

    public int findEndCoordinates(String[][] maze) {

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

    public boolean recursiveSolution(String[][] mazeInput, int row, int column, int rowEnd) {

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
    public String finalPath() {
        MazeToGrid mazeToGrid = new MazeToGrid();
        String[][] maze = mazeToGrid.mazeArray();

        solution = "";

        recursiveSolution(maze, findStartCoordinates(maze),0, findEndCoordinates(maze));

        return solution;
    }
}
