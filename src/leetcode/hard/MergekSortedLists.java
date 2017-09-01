package leetcode.hard;

import org.junit.Test;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class MergekSortedLists {

    @Test
    public void test() {
        this.mergeKLists(new ListNode[]{});
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) {
            return null;
        }
        ListNode prev = new ListNode(Integer.MIN_VALUE);
        ListNode head = prev;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
                (ListNode l1, ListNode l2) -> {
                    return l1.val-l2.val;
                }
        );
        for(int i=0; i<lists.length; i++) {
            if(lists[i]!=null) {
                queue.offer(lists[i]);
            }
        }

        while(queue.size()>0) {
            ListNode n = queue.poll();
            if(n.next!=null) {
                queue.offer(n.next);
            }
            n.next=null;
            prev.next = n;
            prev = n;
        }
        return head.next;

    }
}
