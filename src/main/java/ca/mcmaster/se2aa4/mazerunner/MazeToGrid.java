package ca.mcmaster.se2aa4.mazerunner;

public class MazeToGrid {
    public static String filepath;

    public MazeToGrid(String path) {
        filepath = path;
        // Init for coordinates of point in maze and maze itself
    }
    public static int[][] maze() {
        // Reads file and puts the walls and spaces as 1 and 0 in grid
        // Then save the maze to the maze variable for access outside class
        return new int[][]{{0,1}};
    }
}
