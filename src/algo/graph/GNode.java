package algo.graph;

import java.util.List;

interface IGNode<T> {
  T getValue();
}

class GNode<T> implements IGNode<T> {
  Object value;
  List<GNode> adj;
  Status status;
  GNode parent;
  int entryTime;
  int exitTime;

  public GNode(T value)
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
            ", parent=" +(parent!=null ? parent.getValue() : null)+
            '}';
  }

  @Override
  public T getValue() {
    return (T) value;
  }

  enum Status
  {
    UNDISCOVERED, DISCOVERED, PROCESSED;
  }
}
