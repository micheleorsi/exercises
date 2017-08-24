package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * sorted order
 */
public class CalendarConflicts {

    int[][] cal = new int[][]{
            {1, 2, 'a'},
            {3, 5, 'b'},
            {4, 6, 'c'},
            {7, 10, 'd'},
            {8, 11, 'e'},
            {10, 12, 'f'},
            {13, 14, 'g'},
            {13, 14, 'h'},
            {14, 25,'i'},
            {15, 16,'l'},
            {17, 18,'m'},
    };

    @Test
    public void test() {
        List<List<Character>> conflicts = findConflicts(cal);
        for (List<Character> conflict : conflicts) {
            System.out.println(conflict);
        }

    }

    List<List<Character>> findConflicts(int[][] cal) {
        List<List<Character>> conflicts = new ArrayList<>();
        List<Character> temp = new ArrayList<>(Character.valueOf((char)cal[0][2]));
        int end = cal[0][1];

        for(int i=1; i<cal.length; i++) {
            if(cal[i][0]>=end) {
                if(temp.size()>1) {
                    conflicts.add(temp);
                }
                temp = new ArrayList<>();
            }
            end = Math.max(cal[i][1],end);
            temp.add(Character.valueOf((char)cal[i][2]));
        }

        if(temp.size()>1) {
            conflicts.add(temp);
        }

        return conflicts;

    }
}
