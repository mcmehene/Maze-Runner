package ca.mcmaster.se2aa4.mazerunner;

public interface MazeCreator <T> {

    // Generic Interface MazeCreator Enables new mazes to be
    // processed and saved via different data structures.
    // For the Right Hand Algorithm I chose to save my mazes in a String 2D Array.
    T mazeCreator();
}
