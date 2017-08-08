package crackingcode.chapter3_StackAndQueues;

import algo.linkedlist.LLNode;

public class Stack
{

  LLNode top = null;

  int pop()
  {
    if(top ==null)
    {
      return -1;
    }
    else
    {
      int data = top.item;
      top = top.next;
      return data;
    }
  }
  void push(int elem)
  {
    LLNode n = new LLNode(elem,null);
    n.next=top;
    top = n;
  }
  int peek()
  {
    if(top==null)
    {
      return -1;
    }
    else
    {
      return top.item;
    }
  }
  boolean isEmpty()
  {
    return top==null;
  }
}
