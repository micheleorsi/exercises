package algo.graph;

import java.util.List;

class GNode
{
  int value;
  List<GNode> adj;
  Status status;
  GNode parent;

  public GNode(int value)
  {
    this.value = value;
  }

  @Override
  public String toString() {
    return "GNode{" +
            "value=" + value +
            ", status=" + status +
            '}';
  }

  enum Status
  {
    UNDISCOVERED, DISCOVERED, PROCESSED;
  }
}
