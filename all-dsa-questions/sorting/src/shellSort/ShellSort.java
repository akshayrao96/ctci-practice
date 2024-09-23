package shellSort;

public class ShellSort {

  public static int[] sort(int[] arr) {
    int[] res = new int[arr.length];
    System.arraycopy(arr, 0, res, 0, arr.length);

    int h = 1;

    while (h < arr.length / 3) {
      h = (h * 3) + 1;
    }

    while (h != 0) {
      for (int i = h; i < arr.length; i++) {
        int j = i;
        while (j - h >= 0) {
          if (res[j] < res[j - h]) {
            swap(res, j, j - h);
            j -= h;
          } else {
            break;
          }
        }
      }

      h /= 3;
    }
    return res;
  }


  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
