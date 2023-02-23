package stringCompression;

public class Question {

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
    String str = "aaaaabbbbaaaabbddc";
    System.out.println(str);
    System.out.println(stringCompression(str));
  }
}


/*
Given string, compress it
aabccccccaaa
a2b1c6a3

starting char = s.charAt(0)
int counter = 1
for 1 : end
check with starting char
if same : counter ++
if different, concatenate string, counter = 1, starting char = s.charAt(i)

return shorter length of string
 */
