package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

// COMPARE CORRECTNESS OF USER PATH TO COMPUTED
public class UserPathCompare {
    private static final Logger logger = LogManager.getLogger();
    public String userAnswer() {

        UserPathValidity result = new UserPathValidity();
        UserPathCheck pathCheck = new UserPathCheck();

        if (result.validInput()) {

            if (pathCheck.check()) {

                return "Correct Path";
            } else {

                return "Incorrect Path";
            }

        } else {

            logger.info("Invalid User Path Input");
            logger.info("Exiting Program");
            System.exit(1);

            return null;
        }
    }
}
