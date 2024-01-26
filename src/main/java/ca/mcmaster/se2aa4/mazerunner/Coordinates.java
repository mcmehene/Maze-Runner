package ca.mcmaster.se2aa4.mazerunner;

public class Coordinates implements CoordinateMethods<Integer, String[][]>  {
    public Integer findRightCoordinate(String[][] maze) {

        int start = 0;
        int rowStartCoordinate = 0;
        boolean coordinateNotFound = true;

        while (coordinateNotFound) {

            if (maze[start][maze[0].length - 1].equals(" ")) {

                rowStartCoordinate = start;
                coordinateNotFound = false;
            }

            start++;
        }

        return rowStartCoordinate;
    }

    public Integer findLeftCoordinate(String[][] maze) {

        int end = 0;
        int rowEndCoordinate = 0;
        boolean coordinateNotFound = true;

        while (coordinateNotFound) {

            if (maze[end][0].equals(" ")) {

                rowEndCoordinate = end;
                coordinateNotFound = false;
            }

            end++;
        }

        return rowEndCoordinate;
    }
}
