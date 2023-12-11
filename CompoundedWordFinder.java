import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompoundedWordFinder {

    public static List<String> readWordsFromFile(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        }
        return words;
    }

    public static boolean isCompounded(String word, Set<String> wordSet) {
        if (word.isEmpty()) {
            return true;
        }
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (wordSet.contains(prefix) && isCompounded(suffix, wordSet)) {
                return true;
            }
        }
        return false;
    }

    public static String findLongestCompoundedWord(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        words.sort((w1, w2) -> Integer.compare(w2.length(), w1.length()));
        for (String word : words) {
            if (isCompounded(word, wordSet)) {
                return word;
            }
        }
        return null;
    }

    public static String findSecondLongestCompoundedWord(List<String> words, String longestWord) {
        Set<String> wordSet = new HashSet<>(words);
        words.sort((w1, w2) -> Integer.compare(w2.length(), w1.length()));
        for (String word : words) {
            if (!word.equals(longestWord) && isCompounded(word, wordSet)) {
                return word;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try {
            // Read words from input files
            List<String> wordsInput01 = readWordsFromFile("Input_01.txt");
            List<String> wordsInput02 = readWordsFromFile("Input_02.txt");

            // Combine words from both files
            List<String> allWords = new ArrayList<>(wordsInput01);
            allWords.addAll(wordsInput02);

            // Find the longest compounded word
            String longestCompoundedWord = findLongestCompoundedWord(allWords);
            System.out.println("Longest Compounded Word: " + longestCompoundedWord);

            // Find the second longest compounded word
            String secondLongestCompoundedWord = findSecondLongestCompoundedWord(allWords, longestCompoundedWord);
            System.out.println("Second Longest Compounded Word: " + secondLongestCompoundedWord);

            // Calculate and display the time taken to process the input files
            long endTime = System.currentTimeMillis();
            double elapsedTime = (endTime - startTime) / 1000.0;
            System.out.printf("Time taken to process input files: %.4f seconds%n", elapsedTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}