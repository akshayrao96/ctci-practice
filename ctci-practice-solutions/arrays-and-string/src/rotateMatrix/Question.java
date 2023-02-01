package rotateMatrix;

import CtCILibrary.CtCILibrary.AssortedMethods;

public class Question {

    public static boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            int top = left;
            int bottom = right;
            for (int i = 0; i < right; i++) {
                int temp = matrix[left][i];
                matrix[left][i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[right][bottom - i];
                matrix[right][bottom - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }




    public static void main(String[] args) {
//        int[][] example = new int[][]{{5, 7, 9, 11}, {6, 3, 10, 4}, {2, 6, 1, 7}, {8, 3, 2, 5}};
//        for (int i = 0; i < example[0].length; i++) {
//            System.out.println(Arrays.toString(example[i]));
//        }
//        System.out.println();
//        rotateMatrix(example);
//        for (int i = 0; i < example[0].length; i++) {
//            System.out.println(Arrays.toString(example[i]));
//        }
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);

    }
}

/*
Rotating 4 at a time, then rotate inwards

for i = 0 to n
    int[] temp = top[i];
    top[i] = left[i];
    left[i] = bottom[i];
    bottom[i] = right[i];
    right[i] = temp[i];

 */
