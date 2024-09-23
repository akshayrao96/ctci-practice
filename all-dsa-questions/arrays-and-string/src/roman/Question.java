package roman;

public class Question {

  public static int romanToInt(String s) {
    int num = 0;
    char last = s.charAt(0);
    for (int i = 0; i < s.length(); i++) {
      if (i != s.length() - 1 && getValue(s.charAt(i + 1)) > getValue(s.charAt(i))) {
        num += getValue(s.charAt(i + 1)) - getValue(s.charAt(i));
        i++;
      } else {
        num += getValue(s.charAt(i));
      }

    }
    return num;
  }

  private static boolean edge(char c, char last) {
    return (last == 'I' && c == 'V' || c == 'X') || (last == 'X' && c == 'L' || c == 'C') || (last == 'C' && c == 'D' || c == 'M');
  }


  private static int getValue(char c) {
    return switch (c) {
      case 'I' -> 1;
      case 'V' -> 5;
      case 'X' -> 10;
      case 'L' -> 50;
      case 'C' -> 100;
      case 'D' -> 500;
      case 'M' -> 1000;
      case default -> -1;
    };
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("VII"));
    System.out.println(romanToInt("IX"));
    System.out.println(romanToInt("MCMXCIV"));
    System.out.println(romanToInt("LVIII"));


  }

}

/*
Given a Roman Numeral, convert it to the actual number

VII -> 7
IX -> 10
LII -> 52

edge:
I can be before V and X
X before L and C
C before D and M
 */
