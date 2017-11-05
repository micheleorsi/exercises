package leetcode.medium;

import java.util.Stack;

public class BSTIterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode next;
    TreeNode root;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode r) {
        this.root = r;
        this.stack = new Stack<TreeNode>();
        this.next=findMin(root);
    }

    TreeNode findMin(TreeNode n) {
        while(n!=null) {
            stack.push(n);
            n = n.left;
        }
        if(stack.isEmpty()) {
            return null;
        } else {
            return stack.pop();
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return next!=null;
    }

    private TreeNode findNext(TreeNode node) {
        if(node.right!=null) {
            return findMin(node.right);
        } else {
            if(stack.isEmpty()) {
                return null;
            } else {
                TreeNode temp = stack.peek();
                while(temp.left==null) {
                    temp = stack.pop();
                }
                return stack.peek();
            }
        }
    }


    /** @return the next smallest number */
    public int next() {
        int toReturn = next.val;
        next = findNext(next);
        return toReturn;
    }
}