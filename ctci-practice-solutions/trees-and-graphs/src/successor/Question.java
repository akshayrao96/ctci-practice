package successor;

import CtCILibrary.CtCILibrary.TreeNode;
import node.BinaryTreeNode;

public class Question {

  public static TreeNode findSuccessor(TreeNode root) {
    if (root.right != null) {
      return findMin(root.right);
    }
    TreeNode parent = root.parent;
    while (parent != null && root != parent.left) {
      root = parent;
      parent = parent.parent;
    }
    if (parent == null) return new TreeNode(-1);
    return parent;
  }

  private static TreeNode findMin(TreeNode root) {
    if (root.left == null) return root;
    return findMin(root.left);
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(12);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(16);
    root.right = new TreeNode(42);
    root.right.left = new TreeNode(35);
    root.right.right = new TreeNode(49);
    root.right.right.right = new TreeNode(50);
    root.right.right.left = new TreeNode(47);
    root.left.right.right = new TreeNode(18);
    root.left.right.right.right = new TreeNode(19);
    root.left.parent = root;
    root.right.parent = root;
    root.left.left.parent = root.left;
    root.left.right.parent = root.left;
    root.left.right.right.parent = root.left.right;
    root.left.right.right.right.parent = root.left.right.right;
    root.right.left.parent = root.right;
    root.right.right.parent = root.right;
    root.right.right.left.parent = root.right.right;
    root.right.right.right.parent = root.right.right;

    TreeNode node1 = findSuccessor(root.left.right.right.right);
    System.out.println("successor of 19 is 20 : " + node1.data);

    TreeNode node2 = findSuccessor(root.right);
    System.out.println("successor of 42 is 47 : " + node2.data);

    TreeNode node3 = findSuccessor(root.right.left);
    System.out.println("successor of 35 is 42 : " + node3.data);

    TreeNode node4 = findSuccessor(root.left.left);
    System.out.println("successor of 5 is 12 : " + node4.data);

    TreeNode node5 = findSuccessor(root.left.right);
    System.out.println("successor of 16 is 18 : " + node5.data);

    TreeNode node6 = findSuccessor(root);
    System.out.println("successor of 20 is 35 : " + node6.data);

    TreeNode node7 = findSuccessor(root.right.right.right);
    System.out.println("successor of 50 is -1 : " + node7.data);

  }
}

/*
Find successor of node in BST

If node has right child, find min

  If node does not have right child
    Must be parent root is left child of parent
    Otherwise, recurse up till we find parent of the left child
    If we are at parent, then return null (no successor)




 */
