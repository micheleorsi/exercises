package algo;

import org.junit.Test;

public class MatrixMultiplication
{

  public void matrixMultiplication(int[][] A, int[][] B, int[][] result)
  {
    for(int i=0; i<A.length; i++) // 2
    {
      for(int j=0; j<B[0].length; j++) // 3
      {
        result[i][j] = 0;
        for(int k=0; k<A[0].length; k++) // 5
        {
          result[i][j] = A[i][k]*B[k][j];
        }
      }

    }
  }

  @Test
  public void test()
  {
    // A = 2 x 5
    // [ 1 2 3 4 5 ]
    // [ 1 2 3 4 5 ]
    int[][] matrixA = new int[][] {
      new int[]{1,2,3,4,5},
      new int[]{1,2,3,4,5}
    };
    // B = 5 x 3
    // [ 1 2 3 ]
    // [ 1 2 3 ]
    // [ 1 2 3 ]
    // [ 1 2 3 ]
    // [ 1 2 3 ]
    int[][] matrixB = new int[][] {
      new int[]{1,2,3},
      new int[]{1,2,3},
      new int[]{1,2,3},
      new int[]{1,2,3},
      new int[]{1,2,3}
    };
    // result = 2 x 3
    int[][] matrixResult = new int[][] {
      new int[]{0,0,0},
      new int[]{0,0,0}
    };

    matrixMultiplication(matrixA,matrixB,matrixResult);
    for(int i=0; i<matrixResult.length; i++)
    {
      for(int j=0; j<matrixResult[0].length; j++)
      {
        System.out.print(matrixResult[i][j]+", ");
      }
      System.out.println();
    }
  }

}
