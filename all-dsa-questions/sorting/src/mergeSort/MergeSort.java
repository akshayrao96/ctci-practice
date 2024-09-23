package mergeSort;

public class MergeSort {

  public static int[] sort(int[] arr) {
    int[] res = new int[arr.length];
    System.arraycopy(arr, 0, res, 0, arr.length);
    mergeSort(res);
    return res;
  }

  public static int[] bottomUpSort(int[] arr) {
    int[] res = new int[arr.length];
    System.arraycopy(arr, 0, res, 0, arr.length);
    bottomUp(res);
    return res;
  }


  private static void mergeSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
  }

  private static void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      int mid = l + (r - l) / 2;
      mergeSort(arr, l, mid);
      mergeSort(arr, mid + 1, r);
      merge(arr, l, mid, r);
    }
  }

  private static void merge(int[] arr, int l, int mid, int r) {
    int[] aux = new int[r - l + 1];
    int i = l;
    int j = mid + 1;
    if (arr[mid] < arr[j]) return;

    for (int k = 0; k < aux.length; k++) {
      if (i > mid) {
        aux[k] = arr[j++];
      } else if (j > r) {
        aux[k] = arr[i++];
      } else if (arr[i] <= arr[j]) {
        aux[k] = arr[i++];
      } else {
        aux[k] = arr[j++];
      }
    }

    int k = 0;

    for (int idx = l; idx <= r; idx++) {
      arr[idx] = aux[k++];
    }
  }

  private static void bottomUp(int[] res) {
    int n = res.length;
    for (int sz = 1; sz < n; sz = sz + sz) {
      for (int i = 0; i <  n - sz; i += sz + sz) {
        merge(res, i, i + sz - 1, Math.min(n - 1, i + sz + sz - 1));
      }
    }
  }
}
