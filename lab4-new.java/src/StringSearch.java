import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StringSearch {

    /**
     * Call method in order to find all lines with matching patterns in a file.
     * 
     * @param pattern
     * @param file
     * @param ignoreCase
     * @return ArrayList<String>
     */
    public static ArrayList<String> search(String pattern, File file, Boolean ignoreCase) {

        ArrayList<String> matches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (checkLine(pattern, line, ignoreCase) != null) {
                    matches.add(line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file" + e);
        }

        return matches;
    }

    /**
     * Call in order to return one matching line from the file.
     * 
     * @param pattern
     * @param line
     * @param ignoreCase
     * @return String
     */
    public static String checkLine(String pattern, String line, Boolean ignoreCase) {
        String lowerCaseLine = line.toLowerCase();
        String lowerCasePattern = pattern.toLowerCase();
        if (ignoreCase && lowerCaseLine.contains(lowerCasePattern)) {
            return line;
        } else if (line.contains(pattern)) {
            return line;
        }
        return null;
    }

    /**
     * Used to check if the program is run with mimimum arguments required.
     * 
     * @param args
     */
    public static void correctNbrArgument(String[] args) {
        if (args.length < 2) {
            System.out.println("Wrong number of arguments. Should be called with <pattern> <File> <-i (optional)> ");
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        correctNbrArgument(args);
        Boolean ignoreCase = false;
        if (args.length == 3 && args[2].equals("-i")) {
            ignoreCase = true;
        }
        System.out.println(search(args[0], new File(args[1]), ignoreCase));
    }

}