package problems;

import org.junit.Assert;
import org.junit.Test;

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
    public void test()
    {
        Assert.assertEquals(10/3,calculate(10,3));
    }


}

