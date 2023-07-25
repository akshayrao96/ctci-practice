package oneAway;

/*
Input : String s, String a
Can do following : insert, remove, replace

if difference in length is > 2, return false

pale, pal -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false

int edits = 1

if different, check the lengths and update tracking index accordingly

if length = 1 = removed, i += 1, edit --
if length = 0 = replaced,        edit --
if length = -1 = insert, i -= 1, edit --

if edit is less than 0, return false, otherwise return true

int i, int j

while i < s.length || j < s.length

 */
public class Question {

  public static boolean oneAway(String s, String a) {
    if (s.length() - a.length() > 1 || s.length() - a.length() < -1) {
      return false;
    }
    int i = 0, j = 0;
    s = s.toLowerCase();
    a = a.toLowerCase();
    int edit = 1;

    while (i < s.length() || j < a.length()) {
      boolean b = i == s.length() || j == a.length();

      if (edit == 1 && b)
        return true;
      if (edit < 1 && b)
        return false;

      if (s.charAt(i) != a.charAt(j)) {
        edit--;
        if (edit < 0) {
          return false;
        }
        if (s.length() - a.length() == 1) {
          j--;
        } else if (s.length() - a.length() == -1) {
          i--;
        }
      }
      i++;
      j++;
    }
    return true;
  }

    public static boolean oneAway2(String s, String a){
      if (s.equals(a)) {
        return true;
      }
      int longest = Math.max(s.length(), a.length());
      if (longest - s.length() > 1 || longest - a.length() > 1) {
        return false;
      }

      int[][] arr = new int[s.length() + 1][a.length() + 1];
      for (int i = 0; i < s.length() + 1; i++) {
        arr[i][0] = i;
      }
      for (int i = 0; i < a.length() + 1; i++) {
        arr[0][i] = i;
      }

      for (int i = 1; i < s.length() + 1; i++) {
        for (int j = 1; j < a.length() + 1; j++) {
          int edits = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]);
          if (s.charAt(i - 1) == a.charAt(j - 1)) {
            arr[i][j] = edits;
          } else {
            arr[i][j] = edits + 1;
          }
        }
      }
      return arr[s.length()][a.length()] <= 1;
    }

    public static void main (String[]args){
      String[][] tests = {
          {"adfdf", "bdfdg", "false"},
          {"a", "b", "true"},
          //{"", "d", "true"},
          {"d", "de", "true"},
          {"pale", "pse", "false"},
          {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
          {"acdsfdsfadsf", "acdsfdfadsf", "true"},
          {"acdsfdsfadsf", "acdsfdsfads", "true"},
          {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
          {"adfdsfadsf", "acdfdsfdsf", "false"},
          {"adfdsfadsf", "bdfdsfadsg", "false"},
          {"adfdsfadsf", "affdsfads", "false"},
          {"pale", "pkle", "true"},
          {"pkle", "pable", "false"}};
      for (String[] test : tests) {
        System.out.println("result: " + oneAway(test[0], test[1]) + "; should be : " + test[2]);
      }
    }
  }

//  ""    a   d   f    d    f
/*     0  1   2   3    4    5
    b  1  1   2   3    4    5
    d  2  2   1   2    3    4
    f  3  3   2   1
    d  4
    g  5

 */