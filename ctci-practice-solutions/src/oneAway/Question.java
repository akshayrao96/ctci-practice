package oneAway;

/*
Input : String s, String a
Can do following : insert, remove, replace


 */
public class Question {

  public static boolean oneAway(String s, String a) {
    if (s.equals(a))
      return true;
    int longest = Math.max(s.length(), a.length());
    if (longest - s.length() > 1 || longest - a.length() > 1)
      return false;

    int[][] arr = new int[s.length()][a.length()];
    for (int i = 0; i < s.length(); i++) {
      arr[i][0] = i;
    }
    for (int i = 0; i < a.length(); i++) {
      arr[0][i] = i;
    }

    for (int i = 1; i < s.length(); i++) {
      for (int j = 1; j < a.length(); j++) {
        int edits = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]);
        if (s.charAt(i - 1) == a.charAt(j - 1)) {
          arr[i][j] = edits;
        } else {
          arr[i][j] = edits + 1;
        }
      }
    }
    return arr[s.length() - 1][a.length() - 1] <= 1;
  }

  public static void main(String[] args) {
    String[][] tests = {
        {"adfdf", "bdfdg", "false"}/*,
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
        {"pkle", "pable", "false"}}*/};
    for (String[] test : tests) {
      System.out.println("result: " + oneAway(test[0], test[1]) + "; should be : " + test[2]);
    }
  }
}
