package leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber {

    @Test
    public void test() {
        allMapping("23");
    }
    void allMapping(String digits) {

        List<String> all = new ArrayList<>();
        char[][] chars = mapping(digits);
        recursion(all, "", chars,0);

        for (String s : all) {
            System.out.println(s);
        }

    }

    char[][] mapping(String temp) {
        char[][] mapping = new char[][] {
                {},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'},
                {'+'},
                {' '},
                {'#'}
        };
        char[][] toReturn = new char[temp.length()][];
        for(int i=0; i<temp.length(); i++) {
            toReturn[i]=mapping[temp.charAt(i)-'0'-1];
        }
        return toReturn;
    }

    void recursion(List<String> all, String prefix, char[][] level, int l) {
        if(l==level.length) {
            all.add(new String(prefix));
            return;
        }
        for(int i=0; i<level[l].length; i++) {
            String newPrefix = prefix+level[l][i];
            recursion(all,newPrefix, level, l+1);
        }
    }

}
