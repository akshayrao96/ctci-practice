package stringCompression;

public class Question {

  /*
  aabccccaaa -> a2b1c4a3

  bbccc -> b2c3

  abcde -> a1b1c1d1e1 (return original)

  if string is empty or has 1 char, return original

  start with 1st character and make it placeholder
  have int = 1

  check 2nd character, compare with placeholder
  if same, int++, go to 3rd character

  else different, store character with int in string
  make that char new placeholder
  make int = 1

  use stringbuilder to append result


   */
  public static String stringCompression2(String s) {
    if (s.length() <= 1)
      return s;

    StringBuilder result = new StringBuilder();
    char placeholder = s.charAt(0);
    int freq = 1;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == placeholder) {
        freq++;
      } else {
        result.append(placeholder);
        result.append(freq);
        placeholder = s.charAt(i);
        freq = 1;
      }
    }
    result.append(placeholder);
    result.append(freq);
    return result.toString().length() < s.length() ? result.toString() : s;
  }

  public static String stringCompression(String s) {
    char current = s.charAt(0);
    int count = 1;
    StringBuilder result = new StringBuilder();
    result.append(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == current) {
        count++;
      } else {
        result.append(count);
        current = s.charAt(i);
        result.append(current);
        count = 1;
      }
    }
    return result.length() < s.length() ? result.toString() : s;
  }

  public static void main(String[] args) {
    String[] strings = new String[5];
    strings[0] = "aabccccaaa";
    strings[1] = "abcd"; // original
    strings[2] = "a"; // original
    strings[3] = "aabbccccdd";
    strings[4] = "ababcdde"; // original

    for (String s : strings) {
      System.out.println(s);
      System.out.println(stringCompression2(s));
      System.out.println();
    }
  }
}


