package crackingcode.chapter8_recursionanddynamic;

import org.junit.Assert;
import org.junit.Test;

public class RecursiveMultiply {

    int stackCall=0;

    @Test
    public void test() {
        Assert.assertEquals(5*4,multiply(5,4));
        Assert.assertEquals(0,multiply(0,0));
        Assert.assertEquals(0,multiply(0,4));
        Assert.assertEquals(0,multiply(1,0));
        int bigInt = Integer.MAX_VALUE>>2;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(bigInt*3);
        Assert.assertEquals(1610612733,multiply(3,bigInt));
    }

    int multiply(int a,int b) {
        if(b>a) {
            return multiply(b,a);
        }
        if(b==0) return 0;
        if(b==1) return a;
        int temp=multiply(a,b/2);
        temp=temp+temp;
        if(b%2==1) {
            return a+temp;
        } else {
            return temp;
        }
    }
}
