package checkBalanced;

import CtCILibrary.CtCILibrary.TreeNode;

public class Question {

  public static boolean checkBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (checkBalanced(root.left) && checkBalanced(root.right)) {
      return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    } else {
      return false;
    }
  }

  private static int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(10);
    root.right.left.left = new TreeNode(15);
    root.right.left.left.left = new TreeNode(20);

    System.out.println(checkBalanced(root));
  }
}

/*
If left tree height is 3, right tree height is 1, not balanced

null = 0 height
leaf node = 0 left, 0 right, always balanced

if left tree balanced, right tree balanced, check the heights of both trees. If satisfies, then balanced
If left tree not balanced OR/AND right tree not balanced, return false;

need height

How to check if balanced : Math.abs(left height - right height)
3, 1 = 2 FALSE
1, 2 = 1 TRUE
3, 3 = 0 TRUE
4, 6 = 2 FALSE

if (checkBalanced(root.left) && checkBalanced(root.right))) return Math.abs(maxHeight(root.left) - maxHeight(root.right))

Issue: Want to check boolean through recursion, how to get height


 */
