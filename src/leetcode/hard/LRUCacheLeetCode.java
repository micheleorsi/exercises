package leetcode.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Hashtable;

public class LRUCacheLeetCode {

    LRUCache cache;

    @Before
    public void setup() {
        cache = new LRUCache(5);
    }

    @Test
    public void addOneGetOne() {
        cache.set(1,1);
        Assert.assertEquals(1,cache.get(1));
    }

    @Test
    public void retrieveRightVal() {
        cache.set(2,2);
        cache.set(3,3);
        Assert.assertEquals(3,cache.get(3));
    }

    @Test
    public void removeLatestAccessedVal() {
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        cache.set(5,5);
        cache.set(6,6);
        Assert.assertEquals(-1,cache.get(1));
    }

    @Test
    public void accessPromoteInFront() {
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        cache.set(5,5);
        cache.get(1);
        cache.set(6,6);
        Assert.assertEquals(1,cache.get(1));
        Assert.assertEquals(-1,cache.get(2));
    }

    @Test
    public void changeValue() {
        cache.set(1,1);
        cache.set(1,2);
        Assert.assertEquals(2,cache.get(1));
    }
}

class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;

        DLinkedNode(int key, int value) {
            this.key=value;
            this.value=value;
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNodeInFront(DLinkedNode node){
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNodeInFront(node);
    }

    // pop the current tail.
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode>
            cache = new Hashtable<Integer, DLinkedNode>();
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new DLinkedNode(-1,-1);
        head.pre = null;

        tail = new DLinkedNode(-1,-1);
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){

            DLinkedNode newNode = new DLinkedNode(key,value);

            this.cache.put(key, newNode);
            this.addNodeInFront(newNode);

            if(this.cache.size() > capacity){
                // pop the tail
                DLinkedNode tail = this.removeTail();
                this.cache.remove(tail.key);
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }

    }

}


