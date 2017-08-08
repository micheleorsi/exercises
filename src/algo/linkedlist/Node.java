package algo.linkedlist;


public class Node<T>
{
  public T data;
  public Node<T> next;

  Node(T data)
  {
    this.data = data;
  }

  void appendToTail(T data)
  {
    Node end = new Node(data);
    Node n = this;
    while(n.next != null)
    {
      n = n.next;
    }
    n.next = end;
  }

  Node deleteNode(Node head, T data)
  {
    Node n = head;

    if(n.data == data)
    {
      return head.next; // moved head
    }

    while(n.next != null)
    {
      if(n.next.data == data)
      {
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }
    return head; // no data present
  }
}
