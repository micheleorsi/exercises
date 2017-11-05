package crackingcode.chapter8_recursionanddynamic;

import org.junit.Test;

import java.util.ArrayList;

public class CombinationOfParentesis {

    @Test
    public void test() {
        ArrayList<String> strings = generateParens(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem <leftRem)
            return; // invalid state
        if (leftRem == 0 && rightRem == 0) { // Out of left and right parentheses
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '('; // Add left and recurse
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')'; // Add right and recurse
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

     ArrayList<String> generateParens(int count) {
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }
}
