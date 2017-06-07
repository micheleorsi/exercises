package crackingcode.chapter3_StackAndQueues;

public class Stack
{

  Node top = null;

  int pop()
  {
    if(top ==null)
    {
      return -1;
    }
    else
    {
      int data = top.value;
      top = top.next;
      return data;
    }
  }
  void push(int elem)
  {
    Node n = new Node(elem);
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
      return top.value;
    }
  }
  boolean isEmpty()
  {
    return top==null;
  }
}
