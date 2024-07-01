package threeSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question {

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();;
    for (int i = 0; i < nums.length - 2; i++) {
      List<List<Integer>> returnedList = getValidSum(i, nums);

      if (returnedList.size() > 0) {
        for (List<Integer> res: returnedList) {
          List<Integer> subList = new ArrayList<>();
          subList.add(res.get(0));
          subList.add(res.get(1));
          subList.add(nums[i]);
          if (!subListExists(subList, list)) {
            list.add(subList);
          }
        }
      }
    }
    return list;
  }

  private static boolean subListExists(List<Integer> subList, List<List<Integer>> list) {
    for (List<Integer> each : list) {
      if (each.containsAll(list) && list.containsAll(each)) {
        return true;
      }
    }
    return false;
  }

  private static List<List<Integer>> getValidSum(int i, int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int target = nums[i] * -1;
    for (int j = i + 1; j < nums.length; j++) {
      if (set.contains(target - nums[j])) {
        List<Integer> subList = new ArrayList<>();
        subList.add(nums[j]);
        subList.add(target - nums[j]);
        list.add(subList);
      }
      set.add(nums[j]);
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1}));
  }

}
