package mergeSort;

import java.util.Arrays;

public class Question {

  public static void mergeSort(int[] arr, int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(arr, p, q);
      mergeSort(arr, q + 1, r);
      merge(arr, p, q, r);
    }
  }

  public static void merge(int[] arr, int p, int q, int r) {
    int[] left = new int[q - p + 2];
    int[] right = new int[r - q + 1];
    if (left.length - 1 >= 0) {
      System.arraycopy(arr, p + 0, left, 0, left.length - 1);
    }
    for (int i = 0; i < right.length - 1; i++) {
      right[i] = arr[q + i + 1];
    }
    left[left.length - 1] = Integer.MAX_VALUE;
    right[right.length - 1] = Integer.MAX_VALUE;

    int i = 0, j = 0;

    for (int k = p; k <= r; k++) {
      if (left[i] < right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{2, 3, 44, 5, 4, 5, 1, 99, 2};
    int[] arr2 = new int[]{3, 2, 1};
    int[] arr3 = new int[]{5, 2, 3, 1};

    mergeSort(arr1, 0, arr1.length - 1);
    mergeSort(arr2, 0, arr2.length - 1);
    mergeSort(arr3, 0, arr3.length - 1);

    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3));

  }
}
