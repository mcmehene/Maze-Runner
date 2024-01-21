package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    public static String[][] maze = MazeToGrid.mazeArray();
    private static final int rows = MazeToGrid.rows;
    private static final int columns = MazeToGrid.columns;
    private static int rowStartCoordinate;
    private static int rowEndCoordinate;
    private static String solution = "";
    private static final StringBuilder solFinal = new StringBuilder();

    // COMPUTATION METHODS: findStateCoordinates, findEndCoordinates, recursiveSolution
    private static void findStartCoordinates() {
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

    private static void findEndCoordinates() {
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

    private static boolean recursiveSolution(String[][] mazeInput, int row, int column) {
        // Check if we have reached the end of the maze. If we have, put a east marker to say exit
        // and place a star to complete the path through the printed maze.
        if (row == rowEndCoordinate && column == columns - 1) {
            solution += "E";
            mazeInput[rowEndCoordinate][columns-1] = "*";
            return true;
        }

        // Prevents arrays moving out of bounds
        if ((row >= 0 && row < mazeInput.length) && (column >= 0 && column < mazeInput[0].length) && mazeInput[row][column].equals(" ")) {
            mazeInput[row][column] = "T";

            // SOUTH DIRECTION
            if (recursiveSolution(mazeInput,row + 1, column)) {
                solution += "S";
                mazeInput[row][column] = "*";
                return true;
            }
            // EAST DIRECTION
            if (recursiveSolution(mazeInput,row,column + 1)) {
                solution += "E";
                mazeInput[row][column] = "*";
                return true;
            }
            // WEST DIRECTION
            if (recursiveSolution(mazeInput, row,column - 1)) {
                solution += "W";
                mazeInput[row][column] = "*";
                return true;
            }
            // NORTH DIRECTION
            if (recursiveSolution(mazeInput,row - 1, column)) {
                solution += "N";
                mazeInput[row][column] = "*";
                return true;
            }
        }
        return false;
    }

    // Won't exist when called in main
    private static void finalPath() {
        findStartCoordinates();
        findEndCoordinates();
        recursiveSolution(maze, rowStartCoordinate,0);
    }

    // PRINTING METHODS: cardinalToCanonical, canonicalToFactored, printMaze
    public static String cardinalToCanonical() {
        finalPath();
        //StringBuilder solFinal = new StringBuilder();
        solFinal.append("F");
        for (int end = solution.length()-1; end > 0; end--) {
            if (solution.charAt(end) == solution.charAt(end-1)) {
                solFinal.append("F");
            } else {
                if (solution.charAt(end) == 'E' && solution.charAt(end-1) == 'S') {
                    solFinal.append("R");
                    solFinal.append("F");
                } else if (solution.charAt(end) == 'E' && solution.charAt(end-1) == 'N') {
                    solFinal.append("L");
                    solFinal.append("F");
                } else if (solution.charAt(end) == 'W' && solution.charAt(end-1) == 'S') {
                    solFinal.append("L");
                    solFinal.append("F");
                } else if (solution.charAt(end) == 'W' && solution.charAt(end-1) == 'N') {
                    solFinal.append("R");
                    solFinal.append("F");
                } else if (solution.charAt(end) == 'S' && solution.charAt(end-1) == 'E') {
                    solFinal.append("L");
                    solFinal.append("F");
                } else if (solution.charAt(end) == 'N' && solution.charAt(end-1) == 'E') {
                    solFinal.append("R");
                    solFinal.append("F");
                } else if (solution.charAt(end) == 'S' && solution.charAt(end-1) == 'W') {
                    solFinal.append("L");
                    solFinal.append("F");
                } else if (solution.charAt(end) == 'N' && solution.charAt(end-1) == 'W') {
                    solFinal.append("L");
                    solFinal.append("F");
                }
            }
        }
        return solFinal.toString();
    }

    public static String canonicalToFactored() {
        int amountF = 0;
        StringBuilder factored = new StringBuilder();
        for (int c = 0; c < solFinal.length(); c++) {
            if (solFinal.charAt(c) == 'F') {
                amountF++;
            } else if (solFinal.charAt(c) == 'L') {
                if (amountF != 0) {
                    factored.append(amountF).append("F").append(" ");
                }
                amountF = 0;
                factored.append("L").append(" ");
            } else if (solFinal.charAt(c) == 'R') {
                if (amountF != 0) {
                    factored.append(amountF).append("F").append(" ");
                }
                amountF = 0;
                factored.append("R").append(" ");
            }
        }
        // Calculate the final F's after the last turn.
        if (amountF != 0) {
            factored.append(amountF).append("F").append(" ");
        }
        return factored.toString();
    }

    public static void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
