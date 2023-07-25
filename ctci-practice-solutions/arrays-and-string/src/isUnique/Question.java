package isUnique;

import java.util.Arrays;
import java.util.HashSet;

public class Question {

  public static boolean isUnique(String s) {
    boolean[] found = new boolean[128];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (found[c]) return false;
      found[c] = true;
    }
    return true;
  }

  public static boolean isUniqueChars(String s) {
    boolean[] seenChar = new boolean[128];
    for (int i = 0; i < s.length(); i++) {
      char letter = s.charAt(i);
      if (seenChar[letter]) {
        return false;
      }
      seenChar[letter] = true;
    }
    return true;
  }

  public static boolean isUniqueNoDataStructure(String s) {
    if (s.length() > 128) {
      return false;
    }
    char[] letters = s.toCharArray();
    Arrays.sort(letters);
    for (int i = 1; i < letters.length; i++) {
      if (letters[i] == letters[i - 1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};
    for (String word : words) {
      System.out.println(word + ": " + isUnique(word));
    }
    System.out.println();
    for (String word : words) {
      System.out.println(word + ": " + isUniqueChars(word));
    }
    System.out.println();
    for (String word : words) {
      System.out.println(word + ": " + isUniqueNoDataStructure(word));
    }
  }
}