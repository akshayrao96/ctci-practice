package checkBalanced;

import CtCILibrary.CtCILibrary.TreeNode;
import node.BinaryTreeNode;

public class Question {

    public static boolean checkBalanced(TreeNode root) {
        return checkBalanced(root, 0);
    }

    public static boolean checkBalanced(TreeNode root, int height) {
        if (root != null && root.left == null && root.right == null) {
            height += 1;
        }
        return checkBalanced(root.left)
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        System.out.println(checkBalanced(root));
    }
}
