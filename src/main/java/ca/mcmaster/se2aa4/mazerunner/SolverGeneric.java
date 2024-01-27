package ca.mcmaster.se2aa4.mazerunner;

public interface SolverGeneric <T, K, Q> {

    // The algorithm can return type whatever as long as it's a solution.
    // The maze input will be whatever type designed in MazeCreator.
    // I think the coordinates for startRow, startColumn, and endRow should be
    // the same type as they are in within the same maze, and should share a type
    // for simple representation and processing.
    T solution(K mazeInput, Q startRow, Q startColumn, Q endRow);

    // No matter the solution, I think since we are printing the path to the user,
    // a String is the best way to represent the solution path, so the return value
    // should be String.
    String finalPath();
}
