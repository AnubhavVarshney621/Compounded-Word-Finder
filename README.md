# Compounded-Word-Finder
The code is organized into a single class named CompoundedWordFinder. It contains several static methods for reading words from files, checking if a word is compounded, finding the longest compounded word, finding the second longest compounded word, and the main method to orchestrate the entire process.

Methods:

readWordsFromFile(String filePath):
      Reads words from a given file path (assumes one word per line) and returns them as a list of strings.

isCompounded(String word, Set<String> wordSet):
      Checks if a word can be constructed by concatenating shorter words found in the same set.

findLongestCompoundedWord(List<String> words):
      Finds and returns the longest compounded word from a list of words.

findSecondLongestCompoundedWord(List<String> words, String longestWord):
      Finds and returns the second longest compounded word from a list of words, excluding the longest word.

main(String[] args):
      The main method where the program execution starts.
      Reads words from two input files (Input_01.txt and Input_02.txt).
      Combines the words into a single list.
      Finds the longest compounded word and the second longest compounded word.
      Measures and prints the time taken to process the input files.
      Algorithm Overview

Reading Words:
      The program reads words from two input files (Input_01.txt and Input_02.txt) using the readWordsFromFile method.

Compounded Word Detection:
      The isCompounded method checks if a given word can be constructed by concatenating shorter words found in the same set.

Finding Longest Compounded Word:
      The findLongestCompoundedWord method finds the longest compounded word by sorting the words in descending order of length and             checking each word.

Finding Second Longest Compounded Word:
      The findSecondLongestCompoundedWord method finds the second longest compounded word by sorting the words and checking each word           (excluding the longest one).

Timing Execution:
      The program measures the time taken to process the input files by recording the start and end times and calculates the elapsed time.

Output
      The program prints the following information to the console:
      Output of Input_01.txt file is:
        Longest Compounded Word : ratcatdogcat
        Second Longest Compounded Word : catsdogcats
        Time taken to process the input files in seconds : 0.1546 seconds
      Output of Input_02.txt file is:
        Longest Compounded Word : ethylenediaminetetraacetates
        Second Longest Compounded Word : electroencephalographically
        Time taken to process the input files in seconds : 0.3960 seconds
        
File Handling
      The code handles file I/O using BufferedReader for reading files.

Exception Handling
      The main method catches IOException to handle potential file reading errors.

Note
      Make sure the input files (Input_01.txt and Input_02.txt) are in the same directory as the Java source file, and you can compile          and run it using a Java compiler and interpreter.








