package checkPermutation;

import java.util.HashMap;

public class Question {

  public static boolean checkPermutation(String s, String a) {
    HashMap<Character, Integer> freq = new HashMap<>();
    for (char letter : s.toCharArray()) {
      if (freq.containsKey(letter)) {
        freq.put(letter, freq.get(letter) + 1);
      } else {
        freq.put(letter, 1);
      }
    }
    for (char letter : a.toCharArray()) {
      if (!freq.containsKey(letter)) {
        return false;
      }
      freq.put(letter, freq.get(letter) - 1);
      if (freq.get(letter) < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean anagram = checkPermutation(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + anagram);
    }
  }
}

// Word 1 : moonlight
// Word 2 : lightmono

// Have a frequency map. If frequencies are 0, return true. Covers the case of empty strings
