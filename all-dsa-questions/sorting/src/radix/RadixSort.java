package radix;

import java.util.Arrays;

public class RadixSort {

  public static void radixSort(int[] arr) {
    if (arr.length == 0) {
      return;
    }
    int digits = helperFindDigits(findMax(arr));
    int[] tempBuffer = new int[arr.length];
    System.arraycopy(arr, 0, tempBuffer, 0, arr.length);
    int divide = 1;

    for (int i = 0; i < digits; i++) {
      int[] partition = new int[10];
      for (int num : arr) {
        num = num / divide;
        partition[num % 10] += 1;
      }
      for (int j = 1; j < partition.length; j++) {
        partition[j] += partition[j - 1];
      }
      for (int j = arr.length - 1; j >= 0; j--) {
        int num = arr[j];
        int index = partition[(num / divide) % 10];
        tempBuffer[index - 1] = num;
        partition[(num / divide) % 10] -= 1;
      }
      System.arraycopy(tempBuffer, 0, arr, 0, tempBuffer.length);
      divide *= 10;
    }
  }

  private static int helperFindDigits(int max) {
    int digits = 0;
    while (max != 0) {
      max /= 10;
      digits += 1;
    }
    return digits;
  }

  private static int findMax(int[] arr) {
    int max = arr[0];
    for (int num : arr) {
      max = Math.max(max, num);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{742, 421, 918, 121, 939, 553, 412421, 412, 41, 949, 29192, 2, 921391, 445,
        552};
    radixSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}