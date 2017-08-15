package algo.graph;

import org.junit.Assert;
import org.junit.Test;

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
        BreadFirstSearch bfs = new BreadFirstSearch();
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
