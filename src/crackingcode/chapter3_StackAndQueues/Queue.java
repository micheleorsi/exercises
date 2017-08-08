package crackingcode.chapter3_StackAndQueues;

import algo.linkedlist.LLNode;

public class Queue
{

  private LLNode first;
  private LLNode last;

  void add(int item)
  {
    LLNode newNode = new LLNode(item,null);
    if(last!=null)
    {
      last.next = newNode;
    }
    last = newNode;
    if(first==null)
    {
      first=last;
    }
  }

  int remove()
  {
    if(first==null)
    {
      throw new RuntimeException("empty queue");
    }
    int data = first.item;
    first = first.next;
    if(first==null)
    {
      last=null;
    }
    return data;
  }

  int peek()
  {
    if(first==null)
    {
      throw new RuntimeException("empty queue");
    }
    else
    {
      return first.item;
    }

  }

  boolean isEmpty()
  {
    return first==null;
  }

}
