package checkPermutation;

public class Question {

  public static boolean checkPermutation(String s, String a) {
    if (s.length() != a.length()) {
      return false;
    }
    int[] count = new int[128];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      count[c]++;
    }
    for (int j = 0; j < a.length(); j++) {
      char c = a.charAt(j);
      count[c]--;
    }
    for (int freq : count) {
      if (freq != 0) {
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
