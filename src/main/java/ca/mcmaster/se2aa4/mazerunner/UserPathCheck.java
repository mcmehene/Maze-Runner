package ca.mcmaster.se2aa4.mazerunner;

public class UserPathCheck {
    public boolean pathValidation(String[][] maze, String cardinalPath, int row, int column, int endRow) {

        // Determine what column we end. It is the exact opposite of input column.
        int columnEnd;
        if (column == 0) {
            columnEnd = maze[0].length - 1;
        } else {
            columnEnd = 0;
        }

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

        return row == endRow && column == columnEnd;
    }

    public boolean check() {

        // Maze
        MazeToGrid mazeToGrid = new MazeToGrid();
        String[][] maze = mazeToGrid.mazeCreator();

        // User inputted path in both a westToEast and eastToWest context.
        UserPathToCardinal cardinal = new UserPathToCardinal();
        String westPath = cardinal.westToEast();
        String eastPath = cardinal.eastToWest();

        // Left and right wall maze coordinates for start and end.
        Coordinates coordinates = new Coordinates();
        int leftWall = coordinates.findLeftCoordinate(maze);
        int rightWall = coordinates.findRightCoordinate(maze);

        // Results from traversal.
        boolean westToEast = pathValidation(maze, westPath, leftWall, 0, rightWall);
        boolean eastToWest = pathValidation(maze, eastPath, rightWall, maze[0].length - 1, leftWall);

        return westToEast || eastToWest;
    }
}
