package algo.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class FindCycles
{
    @Test
    public void testWithCycle()
    {
        Graph<GNode> graph = Graph.Builder.buildWithCycle();
        graph.init();

        FC fc = new FC(new LinkedList<>(),new LinkedList<>());
        Assert.assertFalse(fc.isFinished);
        fc.search(graph,graph.nodes.get(0));
        Assert.assertTrue(fc.isFinished);

    }

    @Test
    public void testWithoutCycle()
    {
        Graph<GNode> graph = Graph.Builder.buildWithoutCycle();
        graph.init();

        FC fc = new FC(new LinkedList<>(),new LinkedList<>());
        Assert.assertFalse(fc.isFinished);
        fc.search(graph,graph.nodes.get(0));
        Assert.assertFalse(fc.isFinished);

    }
}

class FC extends DFSRecursive {

    public FC(List<GNode> nodeSeq, List<String> edgeSeq) {
        super(nodeSeq, edgeSeq);
    }

    @Override
    public <T> void processEdge(GNode<T> node1, GNode<T> node2) {
        super.processEdge(node1, node2);
        if(node2.status== GNode.Status.DISCOVERED) {
            System.out.println("cycle from "+node1.value+" to "+node2.value);
            isFinished=true;
        }
    }
}
