package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;

// COMPARE CORRECTNESS OF USER PATH TO COMPUTED
public class UserPathCompare {
    private static final Logger logger = LogManager.getLogger();
    public String userAnswer() {

        UserPathResult result = new UserPathResult();
        EastToWestCheck eastCheck = new EastToWestCheck();
        WestToEastCheck westCheck = new WestToEastCheck();

        if (result.validInput()) {

            if (westCheck.westCheck() || eastCheck.eastCheck()) {

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
