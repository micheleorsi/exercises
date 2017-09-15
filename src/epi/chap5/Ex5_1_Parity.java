package epi.chap5;

import org.junit.Assert;
import org.junit.Test;

public class Ex5_1_Parity {

    int[] parityArr = new int[64*1024];

    public Ex5_1_Parity() {
        int max = 64*1024;
        for(int i=0; i<max; i++) {
            parityArr[i]=parity2(i);
        }
    }

    @Test
    public void test() {
        long val = Long.MAX_VALUE-1;
        int mask = 0xFFFF;

        Assert.assertEquals(1,parity(11));
        Assert.assertEquals(0,parity(128+8));
        Assert.assertEquals(1,parity(128));
        Assert.assertEquals(1,parity(8));
        Assert.assertEquals(0,parity(0));

        Assert.assertEquals(0,parity3(val));
        Assert.assertEquals(1,parity3(val+1));
        Assert.assertEquals(0,parity4(val));
        Assert.assertEquals(1,parity4(val+1));
        Assert.assertEquals(1,parity4(11));
        Assert.assertEquals(0,parity4(128+8));
    }

    int parity4(long number) {

        number = number ^ number>>32;
        number = number ^ number>>16;
        number = number ^ number>>8;
        number = number ^ number>>4;
        number = number ^ number>>2;
        number = number ^ number>>1;
        return (int)number & 1;
    }



    int parity3(long number) {
        long size=16;
        int mask = 0xFFFF;

        int one = parityArr[(int)(number>>(3*size))];
        int two = parityArr[(int)((number>>(2*size))&mask)];
        int three = parityArr[(int)((number>>(1*size))&mask)];
        int four = parityArr[(int)((number)&mask)];
        return one ^ two ^ three ^ four;
    }

    int parity0(int number) {
        int parity = 0;
        while(number>0) {
            if((number&1)==1) {
                parity=parity^1;

            }
            number>>=1;
        }
        return parity;
    }

    int parity1(int number) {
        int parity = 0;
        while(number>0) {
            parity=parity^1;
            int temp = number & ~(number-1);
            number = temp ^ number;
        }
        return parity;
    }

    int parity2(int number) {
        int parity = 0;
        while(number>0) {
            parity=parity^1;
            number = number & (number-1);
        }

        return parity;
    }

    int parity(int number) {
        int r0 = parity0(number);
        int r1 = parity1(number);
        int r2 = parity2(number);
        int r3 = parity3(number);
        if(r0!=r1 || r1!=r2 || r2!=r3) {
            throw new RuntimeException();
        }
        return r0;
    }
}
