package ca.mcmaster.se2aa4.mazerunner;

public class WestToEastCheck implements SolverWTEGenericMethods<Integer, String[][]> {

    public Integer findWestStartCoordinate(String[][] maze) {

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

    public Integer findWestEndCoordinate(String[][] maze) {

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

    public boolean westPathValidation(String[][] maze, String cardinalPath) {
        int row = findWestStartCoordinate(maze);
        int endRow = findWestEndCoordinate(maze);
        int column = 0;
        for (int f = 0; f < cardinalPath.length(); f++) {
            if ((row < 0 || row >= maze.length) || (column < 0 || column >= maze[0].length) || maze[row][column].equals("#")) {
                return false;
            }
            if (cardinalPath.charAt(f) == 'E') {
                column++;
            } else if (cardinalPath.charAt(f) == 'S') {
                row++;
            } else if (cardinalPath.charAt(f) == 'N') {
                row--;
            } else if (cardinalPath.charAt(f) == 'W') {
                column--;
            }
        }
        return row == endRow && column == maze.length-1;
    }

    public boolean westCheck() {
        MazeToGrid mazeToGrid = new MazeToGrid();
        UserPathToCardinal cardinal = new UserPathToCardinal();
        return westPathValidation(mazeToGrid.mazeCreator(), cardinal.westToEast());
    }
}
