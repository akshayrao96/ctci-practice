package urlify;

/*

  Input : String, true length of string

  Mr John Smith, 13
  Mr%20John%20Smith

  Iterate from last character in string, using input length
  If its not a space, add it to the end of the character array
  If space, insert 02%, decrement iteration to next character in String

*/

public class Question {

  public static char[] urlify(char[] string, int strLength) {
    int counter = 0;
    for (int i = strLength - 1; i >= 0; i--) {
      int current = string.length - strLength + i - counter;
      if (string[i] != ' ') {
        string[current] = string[i];
      } else {
        string[current] = '0';
        string[current - 1] = '2';
        string[current - 2] = '%';
        counter += 2;
      }
    }
    return string;
  }

  public static void main(String[] args) {
    String str = "Mr John Smith    ";
    String str2 = "L o o kingGoo d        ";
    String str3 = "L o o kingGoo d";
    //L%20o%20o%20kingGoo%20d
    char[] arr = str.toCharArray();
    char[] arr2 = str2.toCharArray();

    System.out.println(urlify(arr, 13));
    System.out.println(urlify(arr2, str3.length()));
  }
}


