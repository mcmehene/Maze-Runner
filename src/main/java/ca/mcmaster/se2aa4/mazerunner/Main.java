package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        // Run configuration of flags
        Configuration config = Configuration.load(args);
        // Convert the file into a readable maze for the code
        MazeToGrid mazeToGrid = new MazeToGrid();
        // Put the grid in a variable for reading to solver classes
        int[][] grid = MazeToGrid.maze(config.path());

        Options options = new Options();
        options.addOption("i",true, "Inputting the Maze Using i Flag");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            // Obtain the path of the supposed text file from the i flag
            String path = cmd.getOptionValue("i");
            logger.info("**** Reading the maze from file " + path);
            // Find the file with the inputted filepath, return error if filepath no legit
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
