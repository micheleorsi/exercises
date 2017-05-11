package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IncrementInteger
{


  @Test
  public void test()
  {

    List<Integer> test1 = new LinkedList<>(Arrays.asList(1,2,9));
    increment(test1);
    Assert.assertEquals(Integer.valueOf(1),test1.get(0));
    Assert.assertEquals(Integer.valueOf(3),test1.get(1));
    Assert.assertEquals(Integer.valueOf(0),test1.get(2));

    List<Integer> test2 = new LinkedList<>(Arrays.asList(9,9,9));
    increment(test2);

    Assert.assertEquals(Integer.valueOf(1),test2.get(0));
    Assert.assertEquals(Integer.valueOf(0),test2.get(1));
    Assert.assertEquals(Integer.valueOf(0),test2.get(2));
    Assert.assertEquals(Integer.valueOf(0),test2.get(3));
  }

  private void increment(List<Integer> ints)
  {
    int acc =1;

    for(int i=ints.size()-1; i>=0; i--)
    {
      ints.set(i,(ints.get(i) + acc)%10);
      if(ints.get(i)!=0)
      {
        acc=0;
      }
    }
    if(acc==1)
    {
      ints.add(0,1);
    }
  }
}
