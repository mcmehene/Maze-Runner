package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

// COMPARE CORRECTNESS OF USER PATH TO COMPUTED
public class UserPathCompare {
    private static final Logger logger = LogManager.getLogger();
    public static String userAnswer() {

        String userGuess = Configuration.userGuess();

        if (UserPathResult.validInput()) {

            int i = 0;

            while (i < userGuess.length()) {

                if (Character.isDigit(userGuess.charAt(i))) {

                    return factoredCalculation(userGuess);
                }

                i++;
            }

            return canonicalCalculation(userGuess);

        } else {

            logger.info("Invalid User Path Input");
            logger.info("Exiting Program");
            System.exit(1);
            return null;
        }
    }

    private static String factoredCalculation(String userGuess) {

        String factored = removeSpaces(MazePrinter.canonicalToFactored());

        if (factored.equals(userGuess)) {

            return "Correct Path";
        }

        return "Incorrect Path";
    }

    private static String canonicalCalculation(String userGuess) {

        String canonical = removeSpaces(MazePrinter.cardinalToCanonical());

        if (canonical.equals(userGuess)) {

            return "Correct Path";
        }

        return "Incorrect Path";
    }

    private static String removeSpaces(String spaces) {

        return spaces.replaceAll(" ", "");
    }
}
