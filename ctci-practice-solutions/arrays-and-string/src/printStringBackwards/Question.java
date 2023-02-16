package printStringBackwards;

public class Question {

    public static void printStringInReverse(String s) {
        if (s.length() != 1) {
            printStringInReverse(s.substring(1));
        }
        System.out.print(s.charAt(0));
    }

    public static void main(String[] args) {

        printStringInReverse("hello");

    }
}
