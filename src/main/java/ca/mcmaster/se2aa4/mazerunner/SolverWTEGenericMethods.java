package ca.mcmaster.se2aa4.mazerunner;


public interface SolverWTEGenericMethods<T, K> {

    // 1. rowStartCoordinates is meant to return the start coordinate of the row.
    // 2. No matter the maze inputted, none of our files contains dimensions or information
    //    on starting coordinates, so I have made this type generic so the developer can implement
    //    the starting coordinate data in whatever type they prefer.
    // 3. As designed in the MazeCreator interface, the type of how the maze is saved is
    //    also personalized to the developer, and so I have reflected that here for the maze input.
    T findWestStartCoordinate(K mazeInput);

    // 1. rowEndCoordinate is meant to return the start coordinate of the row.
    // 2. No matter the maze inputted, none of our files contains dimensions or information
    //    on starting coordinates, so I have made this type generic so the developer can implement
    //    the ending coordinate data in whatever type they prefer.
    // 3. As designed in the MazeCreator interface, the type of how the maze is saved is
    //    also personalized to the developer, and so I have reflected that here for the maze input.
    T findWestEndCoordinate(K mazeInput);
}
