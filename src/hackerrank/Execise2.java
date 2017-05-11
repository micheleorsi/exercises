package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class Execise2
{

  String canReach(int x1,int y1, int x2, int y2)
  {
    if(x1 == x2 && y1 == y2)
    {
      return "Yes";
    }
    else if(x1 > x2 || y1 > y2) {
      return "No";
    } else {
      String firstBranch = canReach(x1+y1,y1,x2,y2);
      String secondBranch = canReach(x1,x1+y1,x2,y2);
      if(firstBranch.contains("Yes") || secondBranch.contains("Yes")) {
        return "Yes";
      }
      else {
        return "No";
      }
    }
  }

  @Test
  public void test()
  {
    Assert.assertEquals("No",canReach(1,2,2,1));
    Assert.assertEquals("Yes",canReach(1,4,5,9));
  }
}
