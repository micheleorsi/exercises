package epi.chap7;

import org.junit.Assert;
import org.junit.Test;

public class Ex7_1_InterconvertStringAndIntegers {

    @Test
    public void convertStringToInt() {
        Assert.assertEquals(-12345, convert("-12345"));
        Assert.assertEquals(12345, convert("12345"));
        Assert.assertEquals("12345", convert(12345));
        Assert.assertEquals("-12345", convert(-12345));
    }

    int convert(String str) {
        // are there only numbers?
        // are there
        int tenPower=1;
        int total=0;
        for(int i=str.length()-1; i>=0; i--) {
            char c = str.charAt(i);
            if(c!='-') {
                int n = c-'0';
                total += n*tenPower;
                tenPower=tenPower*10;
            } else {
                total=-1*total;
            }
        }
        return total;
    }

    String convert(int input) {
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if(input<0) {
            negative=true;
            input = -1*input;
        }

        while(input>0) {
            int val=input % 10;
            char temp = (char)(((int)'0')+val);
            sb.append(""+temp);
            input = input/10;
        }
        if(negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }


}
