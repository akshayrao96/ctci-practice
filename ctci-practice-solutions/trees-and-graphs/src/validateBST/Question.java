package validateBST;

import CtCILibrary.CtCILibrary.TreeNode;

public class Question {

    public static boolean validateBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.data < root.left.data) {
            return false;
        }
        if (root.right != null && root.data > root.right.data) {
            return false;
        }
        return validateBST(root.left) && validateBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
//        root.right.left.left = new TreeNode(15);
//        root.right.left.left.left = new TreeNode(20);
        System.out.println(validateBST(root));
    }
}
