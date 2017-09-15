package epi.chap11;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Ex11_1_MergeSortedFiles {

    int[][] values = new int[][]{
            {3,5,7},
            {0,6},
            {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}
    };

    @Test
    public void test() {
        List<Integer> integers = sort(values);
        for (int i=1; i<integers.size(); i++) {
            System.out.println(integers.get(i));
            if(integers.get(i)<integers.get(i-1)) {
                Assert.fail();
            }
        }
    }


    List<Integer> sort(int[][] values) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<values.length; i++) {
            int val = values[i][0];
            Node n = new Node(i,0,val);
            heap.add(n);
        }
        while (!heap.isEmpty()) {
            Node node = heap.poll();

            if(node!=null) {
                list.add(node.val);
                if(node.valIdx+1 < values[node.arrayIdx].length) {
                    Node newNode = new Node(node.arrayIdx,node.valIdx+1, values[node.arrayIdx][node.valIdx+1]);
                    heap.add(newNode);
                }
            }
        }
        return list;
    }

    class Node implements Comparable<Node> {
        int arrayIdx;
        int valIdx;
        int val;

        public Node(int arrayIdx, int valIdx, int val) {
            this.arrayIdx = arrayIdx;
            this.valIdx = valIdx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val-o.val;
        }
    }
}
