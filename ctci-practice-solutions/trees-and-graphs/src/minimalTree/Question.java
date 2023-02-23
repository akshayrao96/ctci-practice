package minimalTree;

import CtCILibrary.CtCILibrary.TreeNode;

public class Question {

  public static TreeNode minimalTree(int[] sortedArr) {
    return minimalTree(sortedArr, 0, sortedArr.length - 1);
  }

  public static TreeNode minimalTree(int[] sortedArr, int start, int end) {
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(sortedArr[mid]);
    if (end >= start) {
      root.left = minimalTree(sortedArr, start, mid - 1);
      root.right = minimalTree(sortedArr, mid + 1, end);
      return root;
    }
    return null;
  }

  public static void main(String[] args) {
    int[] sortedArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode tree = minimalTree(sortedArr);
    System.out.println(tree);

  }
}
