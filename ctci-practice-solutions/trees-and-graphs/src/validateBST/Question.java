package validateBST;

import CtCILibrary.CtCILibrary.TreeNode;

public class Question {

    public static boolean validateBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    public static boolean validateBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.data <= min) || (max != null && root.data > max)) {
            return false;
        }
        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
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
//        root.right.left.left.left = new TreeNode(20);
        System.out.println(validateBST(root));
    }
}
