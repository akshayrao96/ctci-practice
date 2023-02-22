package listOfDepths;

import node.BinaryTreeNode;

import java.util.LinkedList;

public class Question {

    public static LinkedList<LinkedList<Integer>> listOfDepths(BinaryTreeNode root) {
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        listOfDepths(root, 0, list);
        return list;
    }

    public static void listOfDepths(BinaryTreeNode root, int height, LinkedList<LinkedList<Integer>> list) {
        if (root != null) {
            if (height > list.size() - 1) {
                list.add(new LinkedList<>());
            }
            list.get(height).add(root.data);
            listOfDepths(root.left, height + 1, list);
            listOfDepths(root.right, height + 1, list);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(4);
        root.left = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(7);
        root.left.left.left = new BinaryTreeNode(9);
        root.left.left.left.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(6);
        root.right.left = new BinaryTreeNode(1);
        root.left.left.right = new BinaryTreeNode(10);

        System.out.println(listOfDepths(root));

    }
}
