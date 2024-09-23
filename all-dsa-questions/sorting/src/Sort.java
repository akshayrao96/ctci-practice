
import insertionSort.InsertionSort;
import java.util.Arrays;
import mergeSort.MergeSort;
import radix.RadixSort;
import shellSort.ShellSort;


public class Sort {
  public static void main(String[] args) {

    int[] arr = new int[]{742, 421, 918, 121, 939, 553, 412421, 412, 41, 949, 29192, 2, 921391, 445,
        552};
    int[] radix = RadixSort.sort(arr);
    int[] insertion = InsertionSort.sort(arr);
    int[] shell = ShellSort.sort(arr);
    int[] merge = MergeSort.sort(arr);
    int[] mergeBottomUp = MergeSort.bottomUpSort(arr);

    int[] res = new int[]{2, 41, 121, 412, 421, 445, 552, 553, 742, 918, 939, 949, 29192, 412421, 921391};


    System.out.println(Arrays.toString(radix) + "\n" + " : " + Arrays.equals(radix, res));
    System.out.println(Arrays.toString(insertion) + "\n" + " : " + Arrays.equals(insertion, res));
    System.out.println(Arrays.toString(shell) + "\n" + " : " + Arrays.equals(shell, res));
    System.out.println(Arrays.toString(merge) + "\n" + " : " + Arrays.equals(merge, res));
    System.out.println(Arrays.toString(mergeBottomUp) + "\n" + " : " + Arrays.equals(mergeBottomUp, res));



  }
}
