package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class UserPathResult {
    private static final String userPath = Configuration.pFlag();
    private static final Logger logger = LogManager.getLogger();
    public boolean validInput() {
        // validInput calculates if the users path follows the criteria of F, L, R or numbers
        // Sends the path to factored if factored path, sends to notFactored if not factored,
        // send false to Configuration if the path is not syntactically correct
        try {
            int onlyNumbers = 0;
            int noCorrectCharacters = 0;
            if (userPath != null) {
                for (int i = 0; i < userPath.length(); i++) {
                    if (userPath.charAt(i) != 'F' || userPath.charAt(i) != 'L'
                            || userPath.charAt(i) != 'R' || !Character.isDigit(userPath.charAt(i))) {
                        noCorrectCharacters++;
                    }
                    if ((userPath.charAt(i) != 'F' || userPath.charAt(i) != 'L'
                            || userPath.charAt(i) != 'R') && Character.isDigit(userPath.charAt(i))) {
                        onlyNumbers++;
                    }
                }
                return onlyNumbers != userPath.length() - 1 && noCorrectCharacters != userPath.length() - 1;
            }
        } catch (Exception en) {
            logger.info("Incorrect String Format Entered.");
            logger.info("Exiting Program");
            System.exit(1);
        }
        return false;
    }
}
