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
        System.out.println("NUMBER OF COLUMNS " + maze[0].length);
        for (int f = 0; f < cardinalPath.length(); f++) {
            System.out.println("BEGIN COLUMN " + column);
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

            System.out.println("ROW " + row);
            System.out.println("COLUMN " + column);
        }
        System.out.println("END");
        System.out.println();
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
        System.out.println("RIGHT TO LEFT " + eastPath);
        System.out.println("LEFT TO RIGHT " + westPath);

        // Left and right wall maze coordinates for start and end.
        Coordinates coordinates = new Coordinates();
        int leftWall = coordinates.findLeftCoordinate(maze);
        int rightWall = coordinates.findRightCoordinate(maze);

        System.out.println("LEFT WALL " + leftWall);
        System.out.println("RIGHT WALL " + rightWall);

        // Results from traversal.
        boolean westToEast = pathValidation(maze, westPath, leftWall, 0, rightWall);
        boolean eastToWest = pathValidation(maze, eastPath, rightWall, maze[0].length - 1, leftWall);

        return westToEast || eastToWest;
    }
}
