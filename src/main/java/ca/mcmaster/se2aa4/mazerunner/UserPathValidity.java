package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class UserPathValidity {
    private static final Logger logger = LogManager.getLogger();
    public boolean validInput() {

        Configuration config = new Configuration();
        String userPath = config.userGuess();

        try {

            boolean noLetters = false;

            if (userPath != null) {

                for (int i = 0; i < userPath.length(); i++) {

                    if (userPath.charAt(i) != 'F' && userPath.charAt(i) != 'L'
                            && userPath.charAt(i) != 'R' && userPath.charAt(i) != ' ' && !Character.isDigit(userPath.charAt(i))) {

                        return false;
                    }

                    if (userPath.charAt(i) == 'F' || userPath.charAt(i) == 'L'
                            || userPath.charAt(i) == 'R') {

                        noLetters = true;
                    }

                    if (Character.isDigit(userPath.charAt(userPath.length()-1))) {

                        return false;
                    }
                }

                return noLetters;

            }

        } catch (Exception en) {

            logger.info("Incorrect String Format Entered.");
            logger.info("Exiting Program");
            System.exit(1);
        }

        return false;
    }
}
