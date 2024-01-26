package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

// COMPARE CORRECTNESS OF USER PATH TO COMPUTED
public class UserPathCompare {
    private static final Logger logger = LogManager.getLogger();
    public String userAnswer() {
        //Configuration config = new Configuration();
        UserPathResult result = new UserPathResult();
        EastToWestCheck eastCheck = new EastToWestCheck();
        WestToEastCheck westCheck = new WestToEastCheck();
        //String userGuess = config.userGuess();

        if (result.validInput()) {

            if (westCheck.westCheck() || eastCheck.eastCheck()) {
                return "Correct Path";
            } else {
                return "Incorrect Path";
            }
            /*int i = 0;

            while (i < userGuess.length()) {

                if (Character.isDigit(userGuess.charAt(i))) {

                    return factoredCalculation(userGuess);
                }

                i++;
            }

            return canonicalCalculation(userGuess);*/

        } else {

            logger.info("Invalid User Path Input");
            logger.info("Exiting Program");
            System.exit(1);
            return null;
        }
    }

    private String factoredCalculation(String userGuess) {
        MazePrinter mazePrinter = new MazePrinter();
        String factored = removeSpaces(mazePrinter.factored());

        if (factored.equals(userGuess)) {

            return "Correct Path";
        }

        return "Incorrect Path";
    }

    private String canonicalCalculation(String userGuess) {
        MazePrinter mazePrinter = new MazePrinter();
        String canonical = removeSpaces(mazePrinter.fullPath());

        if (canonical.equals(userGuess)) {

            return "Correct Path";
        }

        return "Incorrect Path";
    }

    private String removeSpaces(String spaces) {

        return spaces.replaceAll(" ", "");
    }
}
