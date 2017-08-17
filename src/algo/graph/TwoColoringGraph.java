package algo.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TwoColoringGraph
{

    boolean isBipartite=true;

    @Test
    public void testBipartite()
    {
        Graph<TCNode> g = Graph.Builder.buildTwoVertexColourBiPartite();
        g.init();
        twocolor(g);
        Assert.assertTrue(isBipartite);
        for(TCNode node: g.nodes)
        {
            System.out.println(node);
        }
    }

    @Test
    public void testNotBipartite()
    {
        Graph<TCNode> g = Graph.Builder.buildTwoVertexColourNotBiPartite();
        g.init();
        twocolor(g);
        Assert.assertFalse(isBipartite);
        for(TCNode node: g.nodes)
        {
            System.out.println(node);
        }
    }

    void twocolor(Graph<TCNode> g)
    {
        for (TCNode node: g.nodes)
        {
            node.colour=Colour.UNCOLORED;
        }

        for(TCNode node: g.nodes)
        {
            if(node.status== GNode.Status.UNDISCOVERED)
            {
                node.colour=Colour.WHITE;
                search(node);
            }
        }
    }

    <T> void search(TCNode<T> n)
    {
        Queue<TCNode> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty())
        {
            TCNode<T> actual = q.remove();
            process(actual);
            actual.status = GNode.Status.PROCESSED;

            for(TCNode node:actual.adj)
            {
                if(node.status!= GNode.Status.PROCESSED)
                {
                    processEdge(actual,node);
                }
                if(node.status== GNode.Status.UNDISCOVERED)
                {
                    q.add(node);
                    node.status= GNode.Status.DISCOVERED;
                    node.parent=actual;
                }
            }
        }
    }

    private void processEdge(TCNode actual, TCNode node) {
        if(actual.colour==node.colour)
        {
            isBipartite=false;
        }
        if(actual.colour==Colour.WHITE)
        {
            node.colour=Colour.BLACK;
        } else {
            node.colour=Colour.WHITE;
        }
    }

    private void process(TCNode actual) {
    }

    enum Colour
    {
        WHITE,BLACK,UNCOLORED;
    }

}

class TCNode<T> extends GNode<T>
{
    List<TCNode> adj;
    TCNode parent;
    TwoColoringGraph.Colour colour;

    public TCNode(T value) {
        super(value);
    }


    @Override
    public String toString() {
        return "TCNode{" +
                "value=" + value +
                ", status=" + status +
                ", colour=" + colour +
                '}';
    }
}

