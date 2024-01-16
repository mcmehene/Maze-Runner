package ca.mcmaster.se2aa4.mazerunner;

public class UserPathResult {

    public boolean validInput(String mazePath) {
        // validInput calculates if the users path follows the criteria of F, L, R or numbers
        // Sends the path to factored if factored path, sends to notFactored if not factored,
        // send false to Configuration if the path is not syntactically correct
        return false;
    }

    public boolean factorized(String mazePath) {
        // Simplify to non-factored for easier reading.
        // Call MazeSolver to Check Computed path
        // Returns true if the path is correct, false otherwise
        return false;
    }

    public boolean notFactorized(String mazePath) {
        // Call MazeSolver to Check Computed path
        // Returns true if the path is correct, false otherwise
        return false;
    }
}
