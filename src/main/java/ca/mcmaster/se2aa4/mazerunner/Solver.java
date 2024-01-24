package ca.mcmaster.se2aa4.mazerunner;

public interface Solver {
    public int findStartCoordinates(String[][] maze);

    public int findEndCoordinates(String[][] maze);

    public boolean recursiveSolution(String[][] maze, int row, int column, int endRow);

    public String finalPath();
}
