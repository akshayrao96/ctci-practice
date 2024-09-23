package rotateMatrix;

import CtCILibrary.CtCILibrary.AssortedMethods;

public class Question {

  /*
  N x N matrix
  1 x 1 matrix = no rotation
  2 x 2 matrix = rotation

  a | b      ->      c | a
  c | d              d | b

  pattern:
  [0][0] -> [1][0]
  [1][0] -> [1][1]
  [1][1] -> [0][1]
  [0][1] -> temp

  only change 4 at a time
  then increment to next index and do the same

  a | b | c | d     ->     n | b | e | a
  e | f | g | h            e | f | g | h
  j | k | l | m            j | k | l | m
  n | o | p | q            q | o | p | d

  [1][0] -> [3][1]
  [3][1] -> [2][3]
  [3][2] -> [0][2]
  [0][2] -> temp

  [1][1] -> temp
  [1][1] -> [2][1]
  [2][1] -> [2][2]
  [2][2] -> [1][2]
  [1][2] -> temp

  temp = [i][start]
  [i][start] = [end][i]
  [end][i] = [j][end]
  [j][end] = [start][j]
  [start][j] = temp

  change corners
  go down and change indexes accordingly till (n-1)
  after finish, increment start + 1, end - 1
  repeat changes


  start = 1
  end = 2
  i = 1
  j = 2
   */

  public static boolean rotateMatrix(int[][] matrix) {
    if (matrix.length <= 1) return false;
    int start = 0;
    int end = matrix.length - 1;
    while (start < end) {
      int i = start;
      int j = end;
      for (int k = i; k < j; i++) {
        int temp = matrix[i][start];
        matrix[i][start] = matrix[end][i];
        matrix[end][i] = matrix[j][end];
        matrix[j][end] = matrix[start][j];
        matrix[start][j] = temp;
        j--;
      }
      start++;
      end--;
    }
    return true;
  }

  public static boolean rotateMatrix2(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) {
      return false;
    }
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
    int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
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
