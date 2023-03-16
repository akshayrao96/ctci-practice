package commonAncestor;

import CtCILibrary.CtCILibrary.TreeNode;
import com.sun.source.tree.Tree;

public class Question {

  public static TreeNode commonAncestor(TreeNode tree, TreeNode p, TreeNode q) {
    if (tree == null || (!covers(tree, p) || !covers(tree, q)))
      return null;
    if (tree.equals(p) && tree.equals(q))
      return tree;
    return commonAncestorHelper(tree, p, q);
  }


  public static TreeNode commonAncestorHelper(TreeNode tree, TreeNode p, TreeNode q) {
    boolean checkLeftP = isLeft(tree, p);
    boolean checkLeftQ = isLeft(tree, q);

    if ((tree.equals(p) || tree.equals(q)) || checkLeftP != checkLeftQ) return tree;

    if (checkLeftP) {
      return commonAncestorHelper(tree.left, p, q);
    }
    else {
      return commonAncestorHelper(tree.right, p, q);
    }
  }

  public static boolean isLeft(TreeNode tree, TreeNode node) {
    return covers(tree.left, node);
  }

  public static boolean isRight(TreeNode tree, TreeNode node) {
    return covers(tree.right, node);
  }

  public static boolean covers(TreeNode tree, TreeNode node) {
    if (tree == null) return false;
    if (tree.equals(node)) return true;
    return covers(tree.left, node) || covers(tree.right, node);
  }


  public static TreeNode firstCommonAncestor(TreeNode f, TreeNode s) {
    int first = getHeight(f);
    int second = getHeight(s);
    TreeNode ancestor = null;

    if (first == second) {
      ancestor = recurseUp(f, s);
    } else {
      if (first < second) {
        while (first != second) {
          s = s.parent;
          second -= 1;
        }
      } else {
        while (first != second) {
          f = f.parent;
          first -= 1;
        }
      }
      ancestor = recurseUp(f, s);
    }
    return ancestor;
  }

  private static TreeNode recurseUp(TreeNode f, TreeNode s) {
    while (f != null && !f.equals(s)) {
      f = f.parent;
      s = s.parent;
    }
    return f;
  }

  public static int getHeight(TreeNode t) {
    int height = 0;
    while (t != null) {
      t = t.parent;
      height += 1;
    }
    return height;
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

    TreeNode result = firstCommonAncestor(root.left, root.left.right.right.right);
    TreeNode result2 = commonAncestor(root, root.left, root.left.right.right.right);

    System.out.println(result.data + "       "  + result2.data);
  }
}
