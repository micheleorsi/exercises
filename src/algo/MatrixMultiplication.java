package algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MatrixMultiplication
{

  // A: 2 x 5 - B: 5 x 3
  public int[][] matrixMultiplication(int[][] A, int[][] B)
  {
    if(A[0].length != B.length)
    {
      throw new RuntimeException("different size");
    }
    int[][] result = new int[A.length][B[0].length];
    for(int i=0; i<A.length; i++) // 2
    {
      for(int j=0; j<B[0].length; j++) // 3
      {
        result[i][j] = 0;
        for(int k=0; k<A[0].length; k++) // 5
        {
          result[i][j] += A[i][k]*B[k][j];
        }
      }
    }
    return result;
  }

  @Test
  public void empty()
  {
    matrixMultiplication(new int[2][10],new int[10][3]);
  }

  @Test(expected = RuntimeException.class)
  public void differentSize()
  {
    matrixMultiplication(new int[2][10],new int[5][3]);
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
    int[][] matrixResult = matrixMultiplication(matrixA,matrixB);
    for(int i=0; i<matrixResult.length; i++)
    {
      for(int j=0; j<matrixResult[0].length; j++)
      {
        System.out.print(matrixResult[i][j]+", ");
      }
      Assert.assertTrue(Arrays.equals(new int[]{15,30,45},matrixResult[i]));
      System.out.println();
    }
  }

}
