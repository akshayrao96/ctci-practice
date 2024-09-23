package slidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Question {

  public static int[] slidingWindowMaximum(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();
    int left = 0;

    for (int i = 0; i < nums.length; i++) {
      while (!dq.isEmpty() && nums[i] > dq.getLast()) {
        dq.removeLast();
      }
      dq.addLast(nums[i]);
      if (i < k - 1)
        continue;

      res[left] = dq.getFirst();
      if (dq.getFirst() == nums[left]) {
        dq.removeFirst();
      }
      left++;
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr1 = slidingWindowMaximum(new int[]{-1, 4, 3, 7, 2, -4, -6, -8}, 2);
    int[] arr2 = slidingWindowMaximum(new int[]{-1, 4, 3, 7, 2, -4, -6, -8}, 3);
    int[] arr3 = slidingWindowMaximum(new int[]{-1, 4, 3, 7, 2, -4, -6, -8}, 5);
    int[] arr4 = slidingWindowMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3 ));
    System.out.println(Arrays.toString(arr4));


  }

}
