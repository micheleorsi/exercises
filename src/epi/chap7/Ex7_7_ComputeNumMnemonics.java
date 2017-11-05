package epi.chap7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex7_7_ComputeNumMnemonics {

    @Test
    public void test() {
        List<String> all = new ArrayList<>();
        mnemonics("2",new StringBuffer(),0,all);
        for (String s : all) {
            System.out.println(s);
        }

    }

    void mnemonics(String str, StringBuffer temp, int idx, List<String> all) {
        if(idx==str.length()) {
            all.add(temp.toString());
        } else {
            char[] setOfChar;
            setOfChar = getCharsOf(str.charAt(idx)-'0');
            for(int i=0; i<setOfChar.length; i++) {
                temp.append(setOfChar[i]);
                mnemonics(str, temp, idx+1, all);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    private char[] getCharsOf(int c) {
        char[][] mapping = new char[][] {
                {'0'},
                {'1'},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        return mapping[c];
    }
}
