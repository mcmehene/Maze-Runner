package ca.mcmaster.se2aa4.mazerunner;

// CLASS: PRINT PATHS & MAZES
public class MazePrinter {
    private static final StringBuilder solFinal = new StringBuilder();
    // PRINTING METHODS: cardinalToCanonical, canonicalToFactored, printMaze
    public static String cardinalToCanonical(String[][] maze) {
        String pathSolution = MazeSolver.finalPath(maze);
        solFinal.append("F");
        for (int end = pathSolution.length()-1; end > 0; end--) {
            if (pathSolution.charAt(end) == pathSolution.charAt(end-1)) {
                solFinal.append("F");
            } else {
                if (pathSolution.charAt(end) == 'E' && pathSolution.charAt(end-1) == 'S') {
                    solFinal.append(" ");
                    solFinal.append("R");
                    solFinal.append(" ");
                    solFinal.append("F");
                } else if (pathSolution.charAt(end) == 'E' && pathSolution.charAt(end-1) == 'N') {
                    solFinal.append(" ");
                    solFinal.append("L");
                    solFinal.append(" ");
                    solFinal.append("F");
                } else if (pathSolution.charAt(end) == 'W' && pathSolution.charAt(end-1) == 'S') {
                    solFinal.append(" ");
                    solFinal.append("L");
                    solFinal.append(" ");
                    solFinal.append("F");
                } else if (pathSolution.charAt(end) == 'W' && pathSolution.charAt(end-1) == 'N') {
                    solFinal.append(" ");
                    solFinal.append("R");
                    solFinal.append(" ");
                    solFinal.append("F");
                } else if (pathSolution.charAt(end) == 'S' && pathSolution.charAt(end-1) == 'E') {
                    solFinal.append(" ");
                    solFinal.append("L");
                    solFinal.append(" ");
                    solFinal.append("F");
                } else if (pathSolution.charAt(end) == 'N' && pathSolution.charAt(end-1) == 'E') {
                    solFinal.append(" ");
                    solFinal.append("R");
                    solFinal.append(" ");
                    solFinal.append("F");
                } else if (pathSolution.charAt(end) == 'S' && pathSolution.charAt(end-1) == 'W') {
                    solFinal.append(" ");
                    solFinal.append("R");
                    solFinal.append(" ");
                    solFinal.append("F");
                } else if (pathSolution.charAt(end) == 'N' && pathSolution.charAt(end-1) == 'W') {
                    solFinal.append(" ");
                    solFinal.append("L");
                    solFinal.append(" ");
                    solFinal.append("F");
                }
            }
        }
        return solFinal.toString();
    }

    public static String canonicalToFactored() {
        int amountF = 0;
        StringBuilder factored = new StringBuilder();
        for (int c = 0; c < solFinal.length(); c++) {
            if (solFinal.charAt(c) == 'F') {
                amountF++;
            } else if (solFinal.charAt(c) == 'L') {
                if (amountF != 0) {
                    factored.append(amountF).append("F").append(" ");
                }
                amountF = 0;
                factored.append("L").append(" ");
            } else if (solFinal.charAt(c) == 'R') {
                if (amountF != 0) {
                    factored.append(amountF).append("F").append(" ");
                }
                amountF = 0;
                factored.append("R").append(" ");
            }
        }
        // Calculate the final F's after the last turn.
        if (amountF != 0) {
            factored.append(amountF).append("F").append(" ");
        }
        return factored.toString();
    }

    /*public static void printMaze(String[][] maze) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }*/
}
