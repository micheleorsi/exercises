package algo.graph;

import java.util.List;

class GNode
{
  int value;
  List<GNode> adj;
  Status status;
  GNode parent;
  int entryTime;
  int exitTime;

  public GNode(int value)
  {
    this.value = value;
  }

  @Override
  public String toString() {
    return "GNode{" +
            "value=" + value +
            ", status=" + status +
            ", entrytime=" +entryTime+
            ", exittime=" +exitTime+
            ", parent=" +(parent!=null ? parent.value : null)+
            '}';
  }

  enum Status
  {
    UNDISCOVERED, DISCOVERED, PROCESSED;
  }
}
