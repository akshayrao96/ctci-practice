package bitwise;

public class Question {

  public static void main(String[] args) {
    int num = 20;
    int result = 0;
    while (num >> 1 > 1) {
      result += 1;
      num = num >> 1;
    }
    System.out.println(result);
  }



}
