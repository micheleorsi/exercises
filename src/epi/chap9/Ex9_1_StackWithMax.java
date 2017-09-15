package epi.chap9;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Ex9_1_StackWithMax {

    @Test
    public void test() {
        MaxStack s = new MaxStack();
        int[] array = new int[] {2,1,3,4,0,10,-10,0,2,3,23};


        for(int n: array) {
            s.push(n);
        }
        Assert.assertEquals(23,s.max().intValue());


        for(int i=0; i<8; i++) {
            s.pop();
        }

        Assert.assertEquals(3,s.max().intValue());

    }

    class MaxStack extends Stack<Integer> {
        Stack<Integer> max = new Stack<>();

        @Override
        public Integer pop() {
            // checks
            max.pop();
            return super.pop();
        }

        public Integer max() {
            // checks
            return max.peek();
        }

        @Override
        public Integer push(Integer val) {
            super.push(val);
            if(!max.isEmpty()) {
                Integer actualMax = Math.max(max.peek(),val);
                max.push(actualMax);
            } else {
                max.push(val);
            }
            return val;

        }
    }
}
