package ca.mcmaster.se2aa4.mazerunner;

public interface PrinterBusinessSpecGeneric {

    // fullPath is designed to return the full written path of
    // the solution to the maze as per business specifications.
    // As such, the type should be String to make the printing easier.
    String fullPath();

    // factored is designed to return the factored path of the
    // solution to the maze as per business specifications.
    // As such, the type should be String to make the printing easier.
    String factored();
}
