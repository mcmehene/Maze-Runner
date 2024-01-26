package ca.mcmaster.se2aa4.mazerunner;

public class UserPathToCardinal {

    // Three Steps:
    // 1. Convert any path the user gives to a factored path.
    // 2. Use the factored path to calculate the true movement. For example, if the user
    //    types in LLL, this is the same as turning left 3 times, or turning right once.
    //    By changing to R, this makes conversion to cardinal directions so much easier.
    // 3. Convert to Cardinal directions. The cardinal directions string path will be
    //    actually used to move through the maze.

    private static String factored(String userPath) {

        //Configuration config = new Configuration();
        String noSpacesString = removeSpaces(userPath);
        //System.out.println(noSpacesString);

        StringBuilder factoredFinal = new StringBuilder();
        int numberF = 0;
        int numberL = 0;
        int numberR = 0;

        for (int i = 0; i < noSpacesString.length(); i++) {
            if (noSpacesString.charAt(i) == 'F') {

                numberF++;

                if (numberL != 0) {

                    factoredFinal.append(numberL).append("L");
                    numberL=0;

                }
                if (numberR != 0) {

                    factoredFinal.append(numberR).append("R");
                    numberR=0;

                }

            } else if (noSpacesString.charAt(i) == 'L') {

                numberL++;

                if (numberF != 0) {

                    factoredFinal.append(numberF).append("F");
                    numberF=0;

                }

                if (numberR != 0) {

                    factoredFinal.append(numberR).append("R");
                    numberR=0;

                }

            } else if (noSpacesString.charAt(i) == 'R') {

                numberR++;

                if (numberF != 0) {

                    factoredFinal.append(numberF).append("F");
                    numberF=0;

                }

                if (numberL != 0) {

                    factoredFinal.append(numberL).append("L");
                    numberL=0;

                }
            } else {
                if (Character.isDigit(noSpacesString.charAt(i+1))) {
                    factoredFinal.append(noSpacesString.charAt(i));
                } else {

                    // Has to be a digit due to validity, so already factored, so we move onto next character.
                    if (numberR == 0 && numberL == 0 && numberF == 0) {

                        factoredFinal.append(noSpacesString.charAt(i)).append(noSpacesString.charAt(i + 1));
                        i++;

                    } else {

                        if (numberR != 0) {
                            factoredFinal.append(numberR).append("R");
                            numberR = 0;
                        }
                        if (numberF != 0) {
                            factoredFinal.append(numberF).append("F");
                            numberF = 0;
                        }
                        if (numberL != 0) {
                            factoredFinal.append(numberL).append("L");
                            numberL = 0;
                        }

                        factoredFinal.append(noSpacesString.charAt(i)).append(noSpacesString.charAt(i + 1));
                        i++;
                    }
                }
            }

            // For Debugging:
            //System.out.println("CHAR AT I " + noSpacesString.charAt(i));
            //System.out.println("I " + i);
        }

        if (numberR != 0) {
             factoredFinal.append(numberR).append("R");
        }

        if (numberF != 0) {
            factoredFinal.append(numberF).append("F");
        }

        if (numberL != 0) {
            factoredFinal.append(numberL).append("L");
        }

        return factoredFinal.toString();
    }

    private static String simplified(String factored) {
        StringBuilder simplified = new StringBuilder();
        StringBuilder saveNumber = new StringBuilder();
        for (int i = 0; i < factored.length(); i++) {
            if (Character.isDigit(factored.charAt(i))) {
                saveNumber.append(factored.charAt(i));
            } else {
                if (factored.charAt(i) == 'R') {
                    int num;
                    num = Integer.parseInt(saveNumber.toString());
                    if (num % 4 == 1) {
                        simplified.append("R");
                    } else if (num % 4 == 2) {
                        simplified.append("O");
                    } else if (num % 4 == 3) {
                        simplified.append("L");
                    }
                    saveNumber.setLength(0);
                } else if (factored.charAt(i) == 'L') {
                    int num2;
                    num2 = Integer.parseInt(saveNumber.toString());
                    if (num2 % 4 == 1) {
                        simplified.append("L");
                    } else if (num2 % 4 == 2) {
                        simplified.append("O");
                    } else if (num2 % 4 == 3) {
                        simplified.append("R");
                    }
                    saveNumber.setLength(0);
                } else {
                    int num3;
                    num3 = Integer.parseInt(saveNumber.toString());
                    if (Integer.parseInt(saveNumber.toString()) != 1) {
                        int j = 0;
                        while (num3-j != 0) {
                            simplified.append("F");
                            j++;
                        }
                    } else {
                        simplified.append("F");
                    }
                    saveNumber.setLength(0);
                }
            }
        }
        return simplified.toString();
    }

    public static String eastToWest() {
        Configuration config = new Configuration();
        String noSpacesString = removeSpaces(config.userGuess());
        String factored = factored(noSpacesString);
        String simplified = simplified(factored);

        String eastToWest = "";

        for (int k = 0; k < simplified.length(); k++) {

        }
        // Convert the path into an east to west implementation. For EastToWestCheck.
        return "";
    }

    public String westToEast() {
        // Convert the path into a west to east implementation. For WestToEastCheck.
        return "";
    }

    private static String removeSpaces(String userPath) {

        return userPath.replaceAll(" ", "");
    }
}
