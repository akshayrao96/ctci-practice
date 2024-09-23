
import insertionSort.InsertionSort;
import java.util.Arrays;
import radix.RadixSort;
import shellSort.ShellSort;


public class Sort {
  public static void main(String[] args) {

    int[] arr = new int[]{742, 421, 918, 121, 939, 553, 412421, 412, 41, 949, 29192, 2, 921391, 445,
        552};
    int[] radix = RadixSort.sort(arr);
    int[] insertion = InsertionSort.sort(arr);
    int[] shell = ShellSort.sort(arr);


    System.out.println(Arrays.toString(radix) + "\n");
    System.out.println(Arrays.toString(insertion) + "\n");
    System.out.println(Arrays.toString(shell) + "\n");

  }
}
