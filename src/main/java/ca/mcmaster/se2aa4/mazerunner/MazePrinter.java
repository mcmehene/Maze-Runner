package ca.mcmaster.se2aa4.mazerunner;

// CLASS: PRINT PATHS & MAZES
public class MazePrinter implements PrinterBusinessSpec {

    // PRINTING METHODS: cardinalToCanonical, canonicalToFactored

    public String factored() {

        String solution = pathCalculation();
        int amountF = 0;
        StringBuilder factored = new StringBuilder();

        for (int c = 0; c < solution.length(); c++) {

            if (solution.charAt(c) == 'F') {

                amountF++;
            } else if (solution.charAt(c) == 'L') {

                if (amountF != 0 && amountF != 1) {

                    factored.append(amountF).append("F").append(" ");
                } else if (amountF == 1) {

                    factored.append("F").append(" ");
                }

                amountF = 0;
                factored.append("L").append(" ");

            } else if (solution.charAt(c) == 'R') {

                if (amountF != 0 && amountF != 1) {

                    factored.append(amountF).append("F").append(" ");
                } else if (amountF == 1) {

                    factored.append("F").append(" ");
                }

                amountF = 0;
                factored.append("R").append(" ");

            }
        }

        if (amountF != 0 && amountF != 1) {

            factored.append(amountF).append("F").append(" ");
        } else if (amountF == 1) {

            factored.append("F").append(" ");
        }

        return factored.toString();
    }

    public String pathCalculation() {

        MazeSolver mazeSolver = new MazeSolver();
        String pathSolution = mazeSolver.finalPath();

        StringBuilder solFinal = new StringBuilder();

        solFinal.append("F");
        for (int end = pathSolution.length() - 1; end > 0; end--) {

            if (pathSolution.charAt(end) == pathSolution.charAt(end - 1)) {

                solFinal.append("F");
            } else {

                if (pathSolution.charAt(end) == 'E' && pathSolution.charAt(end - 1) == 'S') {

                    solFinal.append(" R F");
                } else if (pathSolution.charAt(end) == 'E' && pathSolution.charAt(end - 1) == 'N') {

                    solFinal.append(" L F");
                } else if (pathSolution.charAt(end) == 'W' && pathSolution.charAt(end - 1) == 'S') {

                    solFinal.append(" L F");
                } else if (pathSolution.charAt(end) == 'W' && pathSolution.charAt(end - 1) == 'N') {

                    solFinal.append(" R F");
                } else if (pathSolution.charAt(end) == 'S' && pathSolution.charAt(end - 1) == 'E') {

                    solFinal.append(" L F");
                } else if (pathSolution.charAt(end) == 'N' && pathSolution.charAt(end - 1) == 'E') {

                    solFinal.append(" R F");
                } else if (pathSolution.charAt(end) == 'S' && pathSolution.charAt(end - 1) == 'W') {

                    solFinal.append(" R F");
                } else if (pathSolution.charAt(end) == 'N' && pathSolution.charAt(end - 1) == 'W') {

                    solFinal.append(" L F");
                }
            }
        }

        return solFinal.toString();
    }
}
