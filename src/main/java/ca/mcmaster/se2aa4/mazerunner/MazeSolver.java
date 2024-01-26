package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    private static String solution;

    public boolean recursiveSolution(String[][] mazeInput, int row, int column, int rowEnd) {

        if (row == rowEnd && column == mazeInput[0].length - 1) {

            mazeInput[rowEnd][mazeInput[0].length - 1] = "*";
            return true;
        }

        // Prevents arrays moving out of bounds
        if ((row >= 0 && row < mazeInput.length) && (column >= 0 && column < mazeInput[0].length) && mazeInput[row][column].equals(" ")) {

            mazeInput[row][column] = "T";

            // SOUTH DIRECTION
            if (recursiveSolution(mazeInput, row + 1, column, rowEnd)) {

                solution += "S";
                return true;
            }

            // EAST DIRECTION
            if (recursiveSolution(mazeInput, row, column + 1, rowEnd)) {

                solution += "E";
                return true;
            }

            // WEST DIRECTION
            if (recursiveSolution(mazeInput, row, column - 1, rowEnd)) {

                solution += "W";
                return true;
            }

            // NORTH DIRECTION
            if (recursiveSolution(mazeInput, row - 1, column, rowEnd)) {

                solution += "N";
                return true;
            }
        }

        return false;
    }
    public String finalPath() {

        MazeToGrid mazeToGrid = new MazeToGrid();
        String[][] maze = mazeToGrid.mazeCreator();
        Coordinates coordinates = new Coordinates();

        // Reinitialize to empty when finalPath gets called again.
        solution = "";

        recursiveSolution(maze, coordinates.findLeftCoordinate(maze),0, coordinates.findRightCoordinate(maze));

        return solution;
    }
}
