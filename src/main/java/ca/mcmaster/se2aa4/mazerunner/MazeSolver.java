package ca.mcmaster.se2aa4.mazerunner;

import java.util.Objects;

public class MazeSolver implements SolverGeneric<Boolean, String[][], Integer> {
    private static String solution;

    public Boolean solution(String[][] mazeInput, Integer row, Integer column, Integer rowEnd) {

        if (Objects.equals(row, rowEnd) && column == mazeInput[0].length - 1) {

            mazeInput[rowEnd][mazeInput[0].length - 1] = "*";
            return true;
        }

        // Prevents arrays moving out of bounds
        if ((row >= 0 && row < mazeInput.length) && (column >= 0 && column < mazeInput[0].length) && mazeInput[row][column].equals(" ")) {

            mazeInput[row][column] = "T";

            // SOUTH DIRECTION
            if (solution(mazeInput, row + 1, column, rowEnd)) {

                solution += "S";
                mazeInput[row][column] = "*";
                return true;
            }

            // EAST DIRECTION
            if (solution(mazeInput, row, column + 1, rowEnd)) {

                solution += "E";
                mazeInput[row][column] = "*";
                return true;
            }

            // NORTH DIRECTION
            if (solution(mazeInput, row - 1, column, rowEnd)) {

                solution += "N";
                mazeInput[row][column] = "*";
                return true;
            }

            // WEST DIRECTION
            if (solution(mazeInput, row, column - 1, rowEnd)) {

                solution += "W";
                mazeInput[row][column] = "*";
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

        solution(maze, coordinates.findLeftCoordinate(maze),0, coordinates.findRightCoordinate(maze));

        return solution;
    }

}
