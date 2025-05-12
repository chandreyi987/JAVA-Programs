import java.util.*;
import java.io.*;

public class FileWordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            int wordCount = 0;

            while (fileScanner.hasNext()) {
                fileScanner.next();
                wordCount++;
            }

            fileScanner.close();
            System.out.println("Total words: " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        scanner.close();
    }
}
