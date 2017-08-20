package crackingcode.chapter4_TreesAndGraphs;

import algo.graph.GNode;
import algo.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static algo.graph.GNode.Status.DISCOVERED;
import static algo.graph.GNode.Status.PROCESSED;
import static algo.graph.GNode.Status.UNDISCOVERED;

public class BuildOrder {

    @Test
    public void nocycle() {
        String[] projects = new String[] {"a","b","c","d","e","f"};
        String[][] dependencies = new String[][] {
                {"a","d"},
                {"f","b"},
                {"b","d"},
                {"f","a"},
                {"d","c"}
        };
        Graph graph = buildGraph(projects, dependencies);

        // get the order
        List<GNode<String >> buildOrder = new LinkedList<>();
        topological(graph,buildOrder);
        // output: f,e,a,b,d,c
        Assert.assertEquals("c",buildOrder.get(0).getValue());
        Assert.assertEquals("d",buildOrder.get(1).getValue());
        Assert.assertEquals("a",buildOrder.get(2).getValue());
        Assert.assertEquals("b",buildOrder.get(3).getValue());
        Assert.assertEquals("e",buildOrder.get(4).getValue());
        Assert.assertEquals("f",buildOrder.get(5).getValue());

        while(!buildOrder.isEmpty()) {
            GNode<String> x = buildOrder.get(buildOrder.size() - 1);
            buildOrder.remove(x);
            System.out.println(x);
        }


    }

    @Test(expected = RuntimeException.class)
    public void withCycle() {
        String[] projects = new String[] {"a","b","c","d","e","f"};
        String[][] dependencies = new String[][] {
                {"a","d"},
                {"f","b"},
                {"b","d"},
                {"f","a"},
                {"d","c"},
                {"c","b"}
        };
        Graph graph = buildGraph(projects, dependencies);

        // get the order
        List<GNode<String >> buildOrder = new LinkedList<>();
        topological(graph,buildOrder);

    }

    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph g = new Graph();
        // create the nodes in the graph
        for(int i=0; i<projects.length; i++) {
            Node n=new Node(projects[i]);
            n.status= UNDISCOVERED;
            n.adj = new LinkedList<>();
            g.add(n);
        }
        // set dependencies
        for(int i=0; i<dependencies.length; i++) {
            Node n1 = g.get(dependencies[i][0]);
            Node n2 = g.get(dependencies[i][1]);
            n1.addAdj(n2);
        }
        return g;
    }

    void topological(Graph g, List<GNode<String>> buildOrder) {
        for(GNode<String> n: g.getNode()) {
            if(n.status==UNDISCOVERED) {
                dfs(g,n, buildOrder);
            }
        }

    }

    void dfs(Graph g, GNode<String> head, List<GNode<String>> buildOrder) {
        head.status = DISCOVERED;

        // process early node

        for(GNode<String> n: head.adj) {
            if(n.status==UNDISCOVERED) {
                n.status=DISCOVERED;
                dfs(g,n,buildOrder);
            } else {
                if(n.status==DISCOVERED) {
                    throw new RuntimeException();
                }
            }
        }

        buildOrder.add(head);
        head.status=PROCESSED;

    }



    class Graph extends algo.graph.Graph<Node> {

        void add(Node n) {
            if(nodes==null) {
                nodes = new LinkedList<>();
            }
            nodes.add(n);
        }

        Node get(String string) {
            for(Node n:nodes) {
                if(n.getValue().equals(string)) {
                    return n;
                }
            }
            return null;
        }

        List<Node> getNode() {
            return nodes;
        }

    }

    class Node extends GNode<String> {

        public Node(String value) {
            super(value);
        }

        void addAdj(Node n) {
            if(adj==null) {
                adj=new LinkedList<>();
            }
            adj.add(n);
        }
    }

}
