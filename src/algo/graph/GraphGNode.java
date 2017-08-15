package algo.graph;


import java.util.List;

class GraphGNode
{
  List<GNode> nodes;
  boolean isDirected;

  void init()
  {
    for(GNode n: nodes)
    {
      n.status= GNode.Status.UNDISCOVERED;
    }
  }

}
