package algo.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class ConnectedComponent
{
    @Test
    public void test()
    {
        GraphGNode g = GraphBuilder.buildConnectedComponent();
        g.init();

        int connectedComponents = connectedComponents(g);

        Assert.assertEquals(3,connectedComponents);
    }

    int connectedComponents(GraphGNode g)
    {
        BFS bfs = new BFS(new LinkedList<>(),new LinkedList<>());
        int cccount = 0;
        for(GNode n: g.nodes) {
            if(n.status== GNode.Status.UNDISCOVERED)
            {
                System.out.println(n);
                bfs.search(g,n);
                cccount++;
            }
        }
        return cccount;
    }
}
