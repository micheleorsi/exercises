package algo.graph;

import java.util.List;

class GNode
{
  int value;
  List<GNode> adj;
  Status status;

  public GNode(int value)
  {
    this.value = value;
  }

  enum Status
  {
    UNDISCOVERED, DISCOVERED, PROCESSED;
  }
}
