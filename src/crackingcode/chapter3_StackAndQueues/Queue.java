package crackingcode.chapter3_StackAndQueues;

public class Queue
{

  private Node first;
  private Node last;

  void add(int item)
  {
    Node newNode = new Node(item);
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
    int data = first.value;
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
      return first.value;
    }

  }

  boolean isEmpty()
  {
    return first==null;
  }

}
