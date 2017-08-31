package algo.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    TS ts;

    @Test(expected = RuntimeException.class)
    public void testWithCycle() {
        Graph<GNode> g = Graph.Builder.buildDAGWithCycle();
        g.init();

        for(GNode node: g.nodes)
        {
            Assert.assertEquals(GNode.Status.UNDISCOVERED,node.status);
        }

        List<GNode> nodeOrder = new LinkedList<>();
        List<String> edgeOrder = new LinkedList<>();

        ts = new TS(nodeOrder,edgeOrder);

        topsort(g);

    }

    @Test
    public void test() {
        Graph<GNode> g = Graph.Builder.buildDAGWith1TopologicalSort();
        g.init();

        for(GNode node: g.nodes)
        {
            Assert.assertEquals(GNode.Status.UNDISCOVERED,node.status);
        }

        List<GNode> nodeOrder = new LinkedList<>();
        List<String> edgeOrder = new LinkedList<>();

        ts = new TS(nodeOrder,edgeOrder);

        topsort(g);

        Assert.assertEquals(10, edgeOrder.size());
        Assert.assertEquals(7, nodeOrder.size());

        // G, A, B, C, F, E, D

        Assert.assertEquals("d", nodeOrder.get(0).value);
        Assert.assertEquals("e", nodeOrder.get(1).value);
        Assert.assertEquals("f", nodeOrder.get(2).value);
        Assert.assertEquals("c", nodeOrder.get(3).value);
        Assert.assertEquals("b", nodeOrder.get(4).value);
        Assert.assertEquals("a", nodeOrder.get(5).value);
        Assert.assertEquals("g", nodeOrder.get(6).value);

    }

    void topsort(Graph<GNode> g) {
        for(GNode n: g.nodes) {
            if(n.status== GNode.Status.UNDISCOVERED) {
                ts.search(g,n);
            }
        }
    }
}

class TS extends DFSRecursive {

    public TS(List<GNode> nodeSeq, List<String> edgeSeq) {
        super(nodeSeq, edgeSeq);
    }

    @Override
    public <T> void processEarly(GNode<T> actual) {
    }

    @Override
    public <T> void processLate(GNode<T> actual) {
        super.processLate(actual);
        nodeSeq.add(actual);
    }

    @Override
    public <T> void processEdge(GNode<T> node1, GNode<T> node2) {
        super.processEdge(node1, node2);

        if(node2.status== GNode.Status.DISCOVERED) {
            throw new RuntimeException("There is a cycle");
        }
    }
}