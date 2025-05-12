import java.util.*;

public class StringFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        String[] words = input.toLowerCase().split("\\s+");
        Map freqMap = new HashMap();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (freqMap.containsKey(word)) {
                int count = (int) freqMap.get(word);
                freqMap.put(word, count + 1);
            } else {
                freqMap.put(word, 1);
            }
        }

        System.out.println("Word frequencies:");
        Set keys = freqMap.keySet();
        for (Object key : keys) {
            System.out.println(key + ": " + freqMap.get(key));
        }

        scanner.close();
    }
}
