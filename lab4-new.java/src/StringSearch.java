import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class StringSearch {

    public static ArrayList<String> search(String word, File file) {

        ArrayList<String> matches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(checkLine(word, line) != null) {
                    matches.add(line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matches;
    }


    public static String checkLine(String word, String line) {
        if(line.contains(word)) {
            return line;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(search(args[0], new File(args[1])));
    }

}