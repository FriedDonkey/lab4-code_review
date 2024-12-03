import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class StringSearch {

    public static ArrayList<String> search(String word, File file, Boolean ignoreCase) {

        ArrayList<String> matches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(checkLine(word, line, ignoreCase) != null) {
                    matches.add(line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matches;
    }


    public static String checkLine(String word, String line, Boolean ignoreCase) {
        if(ignoreCase && line.toLowerCase().contains(word.toLowerCase())) {
            return line;
        } else if(line.contains(word)) {
            return line;
        }
        return null;
    }

    public static void main(String[] args) {
        Boolean ignoreCase = false;
        if(args.length == 3 && args[2].equals("-i")) {
            ignoreCase = true;
        }
        System.out.println(search(args[0], new File(args[1]), ignoreCase));  
    }

}