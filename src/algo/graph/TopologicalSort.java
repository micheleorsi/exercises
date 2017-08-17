package algo.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    TS ts;

    @Test(expected = RuntimeException.class)
    public void testWithCycle() {
        GraphGNode g = GraphBuilder.buildDAGWithCycle();
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
        GraphGNode g = GraphBuilder.buildDAGWith1TopologicalSort();
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
        // 7, 1, 2, 3, 6, 5, 4

        Assert.assertEquals(4, nodeOrder.get(0).value);
        Assert.assertEquals(5, nodeOrder.get(1).value);
        Assert.assertEquals(6, nodeOrder.get(2).value);
        Assert.assertEquals(3, nodeOrder.get(3).value);
        Assert.assertEquals(2, nodeOrder.get(4).value);
        Assert.assertEquals(1, nodeOrder.get(5).value);
        Assert.assertEquals(7, nodeOrder.get(6).value);

    }

    void topsort(GraphGNode g) {
        int i=0;

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
    public void processEarly(List<GNode> nodeSeq, GNode actual) {

    }

    @Override
    public void processLate(List<GNode> nodeSeq, GNode actual) {
        super.processLate(nodeSeq, actual);
        nodeSeq.add(actual);
    }

    @Override
    public void processEdge(List<String> edgeSeq, GNode node1, GNode node2) {
        super.processEdge(edgeSeq, node1, node2);

        if(node2.status== GNode.Status.DISCOVERED) {
            throw new RuntimeException("There is a cycle");
        }
    }
}