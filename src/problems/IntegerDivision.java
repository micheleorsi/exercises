package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class IntegerDivision {

    int calculate(int numerator, int denominator)
    {
        if (numerator == denominator)
            return 1;

        if (numerator < denominator)
            return 0;

        int originalDen = denominator;
        int quot = 1;
        while(denominator<=numerator)
        {
            denominator<<=1;
            quot<<=1;
        }
        denominator>>=1;
        quot>>=1;
        return quot + calculate(numerator-denominator,originalDen);
    }

    @Test
    public void test() {
        System.out.print("test\n".length());
        List<Integer> list = new LinkedList<>();
    }

    @Test
    public void test1()
    {
        Assert.assertEquals(10/3,calculate(10,3));
    }
    @Test
    public void test2()
    {
        Assert.assertEquals(20/3,calculate(20,3));
    }
    @Test
    public void test3()
    {
        Assert.assertEquals(30/3,calculate(30,3));
    }


}

