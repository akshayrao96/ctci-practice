package smallerThanNeighbours;

public class Question {

  public static int binarySearchLowestNeighbor(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left != right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= arr[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left == arr.length - 1 && arr[left] >= arr[left - 1] ? -1 : left;
  }

  public static void main(String[] args) {
    int idx1 = binarySearchLowestNeighbor(new int[]{5, 3, 6, 8, 3, 5, 3, 1, 10, 15, 8, 19});
    int idx2 = binarySearchLowestNeighbor(new int[]{7, 5, 4, 7, 9});
    int idx3 = binarySearchLowestNeighbor(new int[]{1, 2, 3, 4, 5, 7});
    int idx4 = binarySearchLowestNeighbor(new int[]{8, 8, 8});
    int idx5 = binarySearchLowestNeighbor(new int[]{8, 8, 8, 7, 7});

    System.out.println(idx1);
    System.out.println(idx2);
    System.out.println(idx3);
    System.out.println(idx4);
    System.out.println(idx5);

  }
}
