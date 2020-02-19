/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: October 20, 2019
   Description: Implementation of Strassen's Algorithm for Matrix Multiplication
*/

import java.io.*;
import java.util.Scanner;

public class Assignment1{

  public int[][] denseMatrixMult(int[][] A, int[][] B, int size)
  {
    int[][] M0; // Divided sub Matrix
    int[][] M1; // Divided sub Matrix
    int[][] M2; // Divided sub Matrix
    int[][] M3; // Divided sub Matrix
    int[][] M4; // Divided sub Matrix
    int[][] M5; // Divided sub Matrix
    int[][] M6; // Divided sub Matrix
    int[][] C = initMatrix(size); // Initialize the Final Matrix
    int[][] temp1; // Temperory variable to perform calculations
    int[][] temp2; // Temperory variable to perform calculations
    int[][] z = initMatrix(size); // Initialize a zero matrix
    int[][] C01; // Quadrants of C matrix
    int[][] C10; // Quadrants of C matrix
    int[][] C00; // Quadrants of C matrix
    int[][] C11; // Quadrants of C matrix

    // When the matrix is a single number
    if (size<=1){
      C[0][0] = A[0][0] * B[0][0];
      return C;
    }
    else{
      // Calculations are performed
      temp1 = sum(A, A, 0, 0, size/2, size/2, size/2);
      temp2 = sum(B, B, 0, 0, size/2, size/2, size/2);
      M0 = denseMatrixMult(temp1, temp2, size/2);

      temp1 = sum(A, A, size/2, 0, size/2, size/2, size/2);
      temp2 = sum(B, z, 0, 0, 0, 0, size/2);
      M1 = denseMatrixMult(temp1, temp2, size/2);

      temp1 = sum(A, z, 0, 0, 0, 0, size/2);
      temp2 = sub(B, B, 0, size/2, size/2, size/2, size/2);
      M2 = denseMatrixMult(temp1, temp2, size/2);

      temp1 = sum(A, z, size/2, size/2, 0, 0, size/2);
      temp2 = sub(B, B, size/2, 0, 0, 0, size/2);
      M3 = denseMatrixMult(temp1, temp2, size/2);


      temp1 = sum(A, A, 0, 0, 0, size/2, size/2);
      temp2 = sum(B, z, size/2, size/2, 0, 0, size/2);
      M4 = denseMatrixMult(temp1, temp2, size/2);


      temp1 = sub(A, A, size/2, 0, 0, 0, size/2);
      temp2 = sum(B, B, 0, 0, 0, size/2, size/2);
      M5 = denseMatrixMult(temp1, temp2, size/2);

      temp1 = sub(A, A, 0, size/2, size/2, size/2, size/2);
      temp2 = sum(B, B, size/2, 0, size/2, size/2, size/2);
      M6 = denseMatrixMult(temp1, temp2, size/2);


      // C Matrix Quadrants are populated with correct values
      C01 = sum(M2, M4, 0, 0, 0, 0, size/2);
      C10 = sum(M1, M3, 0, 0, 0, 0, size/2);

      temp1 = sum(M0, M3, 0, 0, 0, 0, size/2);
      temp2 = sum(temp1, M6, 0, 0, 0, 0, size/2);
      C00 = sub(temp2, M4, 0, 0, 0, 0, size/2);


      temp1 = sum(M0, M2, 0, 0, 0, 0, size/2);
      temp2 = sum(temp1, M5, 0, 0, 0, 0, size/2);
      C11 = sub(temp2, M1, 0, 0, 0, 0, size/2);


      // All the quadrants are copied and pasted to the appropriate slot in the final matrix
      for (int row = 0; row < size/2; row++) {
        for (int col = 0; col < size/2; col++) {
          C[row][col] = C00[row][col];
          C[row][col + size/2] = C01[row][col];
          C[row + size/2][col] = C10[row][col];
          C[row + size/2][col + size/2] = C11[row][col];
        }
      }
      return C;
    }

  }

  public int[][] sum(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
  {
    int[][] sum = new int[n][n]; // Sum Matrix
    int[][] subA = new int[n][n]; // The small defined matrix A
    int[][] subB = new int[n][n]; // The small defined matrix B

    // A is being shrunk into sub A defined by coordinates
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        subA[row][col] = A[row + x1][col + y1];
      }
    }

    // B is being shrunk into sub B defined by coordinates
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        subB[row][col] = B[row + x2][col + y2];
      }
    }

    // Sum is calculated
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        sum[row][col] = subA[row][col] + subB[row][col];
      }
    }


    return sum;
  }

  public int[][] sub(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
  {
    int[][] sub = new int[n][n]; // Sum Matrix
    int[][] subA = new int[n][n]; // The small defined matrix A
    int[][] subB = new int[n][n]; // The small defined matrix B

    // A is being shrunk into sub A defined by coordinates
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        subA[row][col] = A[row + x1][col + y1];
      }
    }

    // B is being shrunk into sub B defined by coordinates
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        subB[row][col] = B[row + x2][col + y2];
      }
    }

    // Subtraction is performed
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        sub[row][col] = subA[row][col] - subB[row][col];
      }
    }


    return sub;
  }


  public int[][] initMatrix(int n)
  {
    return new int[n][n];
  }

  public void printMatrix(int n, int[][] A)
  {
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        System.out.print(A[row][col] + " ");
      }
      System.out.println();
    }
  }

  public int[][] readMatrix(String filename, int n) throws Exception
  {
    Scanner input = new Scanner(new File(filename));
    int[][] array = new int[n][n];

    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        array[row][col] = input.nextInt();
      }
    }
    input.close();

    return array;
  }

}
