package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

public class UserPathResult {
    private static final Logger logger = LogManager.getLogger();
    public boolean validInput() {
        Configuration config = new Configuration();
        String userPath = config.userGuess();

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
