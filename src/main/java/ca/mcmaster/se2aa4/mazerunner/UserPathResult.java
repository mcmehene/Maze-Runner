package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class UserPathResult {
    private static final Logger logger = LogManager.getLogger();
    public static boolean validInput() {
        // validInput calculates if the users path follows the criteria of F, L, R or numbers
        // Sends the path to factored if factored path, sends to notFactored if not factored,
        // send false to Configuration if the path is not syntactically correct
        String userPath = Configuration.userGuess();
        try {
            int onlyNumbers = 0;
            if (userPath != null) {
                for (int i = 0; i < userPath.length(); i++) {
                    if (userPath.charAt(i) != 'F' && userPath.charAt(i) != 'L'
                            && userPath.charAt(i) != 'R' && !Character.isDigit(userPath.charAt(i))) {
                        return false;
                    }
                    if ((userPath.charAt(i) != 'F' || userPath.charAt(i) != 'L'
                            || userPath.charAt(i) != 'R') && Character.isDigit(userPath.charAt(i))) {
                        onlyNumbers++;
                    }
                    if (Character.isDigit(userPath.charAt(userPath.length()-1))) {
                        return false;
                    }
                }
                return onlyNumbers != userPath.length();
            }
        } catch (Exception en) {
            logger.info("Incorrect String Format Entered.");
            logger.info("Exiting Program");
            System.exit(1);
        }
        return false;
    }
}
