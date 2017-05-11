package hackerrank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays
 *
 */
public class SparseArrays
{
//  public static void main(String[] args) {
//    Scanner scan = new Scanner(System.in);
//    int stringSize = scan.nextInt();
//    List<String> stringList = new ArrayList<>();
//    while(stringSize>0)
//    {
//      stringList.add(scan.next());
//      stringSize--;
//    }
//    int  querySize = scan.nextInt();
//    List<String> queryList = new ArrayList<>();
//    while(querySize>0)
//    {
//      queryList.add(scan.next());
//      querySize--;
//    }
//    System.out.println(stringList);
//    System.out.println(queryList);
//
//  }

  @Before
  public void setup()
  {}
  @Test
  public void bigValues()
  {
    List<String> stringList = new ArrayList<>();
    List<String> queryList = new ArrayList<>();
    Random random = new Random();
    for(int i=0; i<1000; i++)
    {
      stringList.add("str34567890123456"+random.nextInt(100));
      queryList.add("query34567890123456"+random.nextInt(100));
    }

    this.calculate(stringList,queryList);
  }


    @Test
  public void voidList()
  {
    List<String> stringList = new ArrayList<>(Arrays.asList(

    )
    );
    List<String> queryList = new ArrayList<>(Arrays.asList(

    ));

    int[] result = this.calculate(stringList,queryList);
    Assert.assertTrue(result.length==0);

  }
  @Test
  public void sample()
  {
    List<String> stringList = new ArrayList<>(Arrays.asList(
      "aba","baba","aba","xzxb"
    )
    );
    List<String> queryList = new ArrayList<>(Arrays.asList(
      "aba","xzxb","ab"
    ));

    int[] result = this.calculate(stringList,queryList);
    Assert.assertEquals(2,result[0]);
    Assert.assertEquals(1,result[1]);
    Assert.assertEquals(0,result[2]);
  }

  public int[] calculate(List<String> stringList, List<String> queryList)
  {
    int[] queryOccurence = new int[queryList.size()];
    for(int i=0; i<queryList.size(); i++)
    {
      String query = queryList.get(i);
      queryOccurence[i] = 0;
      for(String str: stringList)
      {
        if(str.equals(query))
        {
          queryOccurence[i]++;
        }
      }
    }
    return queryOccurence;
  }
}
