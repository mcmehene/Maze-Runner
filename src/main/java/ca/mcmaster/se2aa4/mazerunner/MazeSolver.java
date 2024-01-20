package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    public static String[][] maze = MazeToGrid.mazeArray();
    private static final int rows = MazeToGrid.rows;
    private static final int columns = MazeToGrid.columns;

    private static int rowStartCoordinate;
    private static final int columnStartCoordinate = 0;

    private void findStartCoordinates() {
        // Determine where we begin the search
        int start = 0;
        boolean coordinateNotFound = true;
        while (coordinateNotFound) {
            System.out.println(maze[0][start]);
            if (maze[start][0].equals(" ")) {
                rowStartCoordinate = start;
                coordinateNotFound = false;
            }
            start++;
        }
    }

    public int findEndCoordinates() {
        // Determine the final coordinate of the search, so we can check if end reached
        return 0;
    }

    public String recursiveSolution() {
        // I'm not yet sure how to move through maze, but I believe recursion is best bet.
        return "Path";
    }

    public String finalPath() {
        // Returns the path to be checked/printed depending on condition of program
        return "Walking Skeleton";
    }

    public String printMaze() {
        findStartCoordinates();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(rowStartCoordinate);
        return "Printed";
    }

}
