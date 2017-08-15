package algo.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TwoColoringGraph
{

    boolean isBipartite=true;

    /**
     *        1
     *       / \
     *      2  3 - 5
     *      \ /
     *       4
     *
     *  8 - 7 - 6
     *
     *  9 - 10 - 11 - 12
     *  \             |
     *  \-------------/
     *
     * @return
     */
    GraphTCNode buildTwoVertexColourBiPartite()
    {
        TCNode one = new TCNode(1);
        TCNode two = new TCNode(2);
        TCNode three = new TCNode(3);
        TCNode four = new TCNode(4);
        TCNode five = new TCNode(5);
        TCNode six = new TCNode(6);
        TCNode seven = new TCNode(7);
        TCNode eigth = new TCNode(8);
        TCNode nine = new TCNode(9);
        TCNode ten = new TCNode(10);
        TCNode eleven = new TCNode(11);
        TCNode twelve = new TCNode(12);

        one.adj = Arrays.asList(two,three);
        two.adj = Arrays.asList(one,four);
        three.adj = Arrays.asList(four,one,five);
        four.adj = Arrays.asList(two,three);
        five.adj = Arrays.asList(three);

        six.adj = Arrays.asList(seven);
        seven.adj = Arrays.asList(six,eigth);
        eigth.adj = Arrays.asList(seven);

        nine.adj = Arrays.asList(ten,twelve);
        ten.adj = Arrays.asList(nine,eleven);
        eleven.adj = Arrays.asList(ten,twelve);
        twelve.adj = Arrays.asList(eleven,nine);

        GraphTCNode g = new GraphTCNode();
        g.nodes = Arrays.asList(one,two,three,four,five,six,seven,eigth,nine,ten,eleven,twelve);
        return g;
    }
    @Test
    public void testBipartite()
    {
        GraphTCNode g = this.buildTwoVertexColourBiPartite();
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
        GraphTCNode g = this.buildTwoVertexColourNotBiPartite();
        g.init();
        twocolor(g);
        Assert.assertFalse(isBipartite);
        for(TCNode node: g.nodes)
        {
            System.out.println(node);
        }
    }

    /**
     *        1
     *       / \
     *      2 - 3 - 5
     *      \  /
     *       4
     *
     *
     * @return
     */
    GraphTCNode buildTwoVertexColourNotBiPartite() {
        TCNode one = new TCNode(1);
        TCNode two = new TCNode(2);
        TCNode three = new TCNode(3);
        TCNode four = new TCNode(4);
        TCNode five = new TCNode(5);

        one.adj = Arrays.asList(two,three);
        two.adj = Arrays.asList(one,three,four);
        three.adj = Arrays.asList(one,two,four);
        four.adj = Arrays.asList(two,three);
        five.adj = Arrays.asList(three);

        GraphTCNode g = new GraphTCNode();
        g.nodes = Arrays.asList(one,two,three,four,five);
        return g;
    }

    void twocolor(GraphTCNode g)
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
                search(g,node);
            }
        }
    }

    void search(GraphTCNode g, TCNode n)
    {
        Queue<TCNode> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty())
        {
            TCNode actual = q.remove();
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

    class TCNode
    {
        int value;
        List<TCNode> adj;
        GNode.Status status;
        TCNode parent;

        Colour colour;

        public TCNode(int value) {
            this.value = value;
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
}

class GraphTCNode
{
    List<TwoColoringGraph.TCNode> nodes;
    boolean isDirected;

    void init()
    {
        for(TwoColoringGraph.TCNode n: nodes)
        {
            n.status= GNode.Status.UNDISCOVERED;
        }
    }

}

