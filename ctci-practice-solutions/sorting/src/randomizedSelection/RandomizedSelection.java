package randomizedSelection;

public class RandomizedSelection {

  public static int randomizedQuicky(int[] arr, int find) {
    if (arr.length == 0 || find <= 0 || find > arr.length) {
      throw new IllegalArgumentException();
    }
    return randomizedQuicky(arr, 0, arr.length - 1, find);
  }

  public static int randomizedQuicky(int[] arr, int start, int end, int find) {
    int index = partition(arr, start, end);
    if (start >= end) {
      return arr[start];
    }
    if (index == find - 1) {
      return arr[index];
    }
    if (index < find - 1) {
      return randomizedQuicky(arr, index + 1, end, find);
    } else {
      return randomizedQuicky(arr, start, index - 1, find);
    }
  }

  public static int partition(int[] arr, int start, int end) {
    if (start == end) {
      return start;
    }
    int index = (int) Math.floor(Math.random() * (end - start)) + start;
    int pivot = arr[index];
    int i = start - 1;
    arr[index] = arr[end];
    arr[end] = pivot;
    for (int j = start; j < end; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    arr[end] = arr[i + 1];
    arr[i + 1] = pivot;
    return i + 1;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{5, 2, 1, 6, 4, 7};

    for (int i = 0; i < 5; i++) {

      int first = randomizedQuicky(arr, 1);
      System.out.println(first + " = 1");
      System.out.println("-----");

      int fifth = randomizedQuicky(arr, 5);
      System.out.println(fifth + " = 6");
      System.out.println("-----");

      int third = randomizedQuicky(arr, 3);
      System.out.println(third + " = 4");
      System.out.println("-----");

      int second = randomizedQuicky(arr, 2);
      System.out.println(second + " = 2 ");
      System.out.println("-----");

      int sixth = randomizedQuicky(arr, 6);
      System.out.println(sixth + " = 7");

      int fourth = randomizedQuicky(arr, 4);
      System.out.println(fourth + " = 5");
      System.out.println("-----");


    }
  }
}

// get pivot
// Math.Random = Math.Floor(Math.Random() * arr.length);

// partition the pivot
// if pivot position = find, return pivot
// if pivot position > find, recurse left subarray with arr, find
// if pivot position < find, recurse right subarray with arr, find - pivot position