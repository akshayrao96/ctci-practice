package insertionSort;

public class InsertionSort {

  public static int[] sort(int[] arr) {
    int[] res = new int[arr.length];
    System.arraycopy(arr, 0, res, 0, arr.length);
    for (int i = 0; i < res.length; i++) {
      int j = i;
      while (j - 1 >= 0) {
        if (res[j] < res[j - 1]) {
          swap(res, j - 1, j--);
        } else {
          break;
        }
      }
    }
    return res;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}


/*
Insertion sort

Always assume the left is already sorted
increment i

check i with everything behind. Moment it's larger we are done. If smaller, keep checking value
make swap accordingly

[5,1,23,66,4]

 */
