package zeroMatrix;

import CtCILibrary.CtCILibrary.AssortedMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

  /*
  have another 2d array, initialize everything to false
  when 0 found, make row and column true
  change original matrix
  [i][j] = [0][0], [0][1], [0][2]
  if matrix[i][j] = 0, then change boolean row and column to true

  col = [i]
  row = [j]

   */

  public static void zeroMatrix(int[][] matrix) {
    if (matrix.length == 0) return;
    boolean[][] zero = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          changeZero(zero, i, j);
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (zero[i][j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public static void changeZero(boolean[][] zero, int i, int j) {
    for (int k = 0; k < zero[0].length; k++) {
      zero[i][k] = true;
    }
    for (int k = 0; k < zero.length; k++) {
      zero[k][j] = true;
    }
  }


  public static void zeroMatrix2(int[][] matrix) {
    List<int[]> zero = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          int[] found = new int[]{i, j};
          zero.add(found);
        }
      }
    }
    for (int[] element : zero) {
      int row = element[0];
      int col = element[1];
      Arrays.fill(matrix[row], 0);
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][col] = 0;
      }
    }
  }

  private static boolean matricesAreEqual(int[][] m1, int[][] m2) {
    if (m1.length != m2.length || m1[0].length != m2[0].length) {
      return false;
    }

    for (int k = 0; k < m1.length; k++) {
      for (int j = 0; j < m1[0].length; j++) {
        if (m1[k][j] != m2[k][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private static int[][] cloneMatrix(int[][] matrix) {
    int[][] c = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      System.arraycopy(matrix[i], 0, c[i], 0, matrix[0].length);
    }
    return c;
  }

  public static void main(String[] args) {
    int nrows = 6;
    int ncols = 6;
    int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, 0, 6);
    int[][] matrix2 = cloneMatrix(matrix1);

    AssortedMethods.printMatrix(matrix1);

    zeroMatrix(matrix1);
    zeroMatrix(matrix2);

    System.out.println();

    AssortedMethods.printMatrix(matrix1);
    System.out.println();
    AssortedMethods.printMatrix(matrix2);

    if (matricesAreEqual(matrix1, matrix2)) {
      System.out.println("Equal");
    } else {
      System.out.println("Not Equal");
    }

  }
}

/*
Find where 0's are
use 2D array
Fill row and column with 0's

row : for i = 0 to matrix[row].length, matrix[row][i] = 0;
col : for i = 0 to matrix.length, matrix[i][col] = 0;

3   0   1
0   4   6

< [0, 1], [1, 0] >
 */
