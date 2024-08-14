package medianOfSortedArrays;

import java.util.Arrays;

public class Question {

  public static final int MAX_SIZE = 10000000;

  public static double medianSort(int[] a, int[] b) {
    int[] total = new int[a.length + b.length];
    int i = 0;
    for (int k : a) {
      total[i] = k;
      i++;
    }
    for (int k : b) {
      total[i] = k;
      i++;
    }

    Arrays.sort(total);

    return total.length % 2 == 1 ? (double) total[total.length / 2]
        : (double) ((total[total.length / 2] + total[(total.length / 2) - 1]) / 2);

  }

  public static double medianNaive(int[] a, int[] b) {
    int[] total = new int[a.length + b.length];
    int i = 0;
    int j = 0;

    int idx = 0;

    while (i < a.length && j < b.length) {
      if (a[i] <= b[j]) {
        total[idx++] = a[i++];
      } else {
        total[idx++] = b[j++];
      }
    }

    while (i < a.length) {
      total[idx++] = a[i++];
    }

    while (j < b.length) {
      total[idx++] = b[j++];
    }

    return total.length % 2 == 1 ? (double) total[total.length / 2]
        : (double) ((total[total.length / 2] + total[(total.length / 2) - 1]) / 2);
  }

  public static double median(int[] a, int[] b) {
    int len = a.length + b.length;
    int[] smaller = a.length < b.length ? a : b;
    int[] larger = a.length < b.length ? b : a;

    int left = 0;
    int right = smaller.length - 1;

    double res = 0.0;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int largeMid = ((len + 1) / 2) - mid;

      int smallerNum = mid <= 0 ? Integer.MIN_VALUE
          : mid >= smaller.length ? smaller[right - 1] : smaller[mid - 1];

      int largerNum = largeMid <= 0 ? Integer.MIN_VALUE
          : largeMid >= larger.length ? larger[larger.length - 1] : larger[largeMid - 1];

      int smallerNext =
          mid >= smaller.length ? Integer.MAX_VALUE : mid <= 0 ? smaller[left] : smaller[mid];

      int largerNext = largeMid >= larger.length ? Integer.MAX_VALUE
          : largeMid <= 0 ? larger[0] : larger[largeMid];

      if (smallerNum <= largerNext && largerNum <= smallerNext) {
        if (len % 2 == 1) {
          res = (double) Math.max(smallerNum, largerNum);
        } else {
          int first = Math.max(smallerNum, largerNum);
          int second = Math.min(smallerNext, largerNext);
          res = (double) (first + second) / 2;
        }
        break;
      } else if (smallerNum > largerNext) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] a = new int[MAX_SIZE];
    int[] b = new int[MAX_SIZE];
    int[] c = new int[MAX_SIZE];

    for (int i = 0; i < MAX_SIZE; i++) {
      a[i] = i;
      b[i] = i * 4 - 4 * 2 / 5;
      c[i] = 300;
    }

    System.out.println("MEDIAN FROM SORTING: ");
    long startTime1 = System.nanoTime();
    System.out.println(medianSort(a, b));
    System.out.println(medianSort(b, c));
    System.out.println(medianSort(a, c));
    long endTime1 = System.nanoTime();
    long executionTime
        = (endTime1 - startTime1);
    System.out.println("Timer : " + executionTime / 10000);
    System.out.println("\n");

    System.out.println("MEDIAN FROM MERGING: ");
    long startTime2 = System.nanoTime();
    System.out.println(medianNaive(a, b));
    System.out.println(medianNaive(b, c));
    System.out.println(medianNaive(a, c));
    long endTime2 = System.nanoTime();
    long executionTime2
        = (endTime2 - startTime2);
    System.out.println("Timer : " + executionTime2 / 10000);
    System.out.println("\n");

    System.out.println("MEDIAN FROM BINARY SEARCH: ");
    long startTime3 = System.nanoTime();
    System.out.println(median(a, b));
    System.out.println(median(b, c));
    System.out.println(median(a, c));
    long endTime3 = System.nanoTime();
    long executionTime3
        = (endTime3 - startTime3);
    System.out.println("Timer : " + executionTime3 / 10000);
    System.out.println("\n");
  }
}

/*
MEDIAN FROM SORTING:
7999999.0
300.0
300.0
Timer : 38564


MEDIAN FROM MERGING:
7999999.0
300.0
300.0
Timer : 11187


MEDIAN FROM BINARY SEARCH:
7999999.0
300.0
300.0
Timer : 15
 */
