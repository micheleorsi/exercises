package algo.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *                  1
 *                  |
 *            |-5 - 2 - 6
 *            |     |
 *            |     3
 *            |    / \
 *            |---4  7
 */
public class FindPath
{
    List<GNode> list = new LinkedList<>();

    @Test
    public void testFindPath()
    {
        Graph<GNode> g = Graph.Builder.buildWithCycle();
        Stack<GNode> list = new Stack<>();
        g.init();
        findPath(g,g.nodes.get(1),g.nodes.get(6),list);

        int[] expectedOrder = new int[] {2,3,7};
        for(int i=0; i<list.size(); i++) {
            Assert.assertEquals(expectedOrder[i],list.pop().value);
        }

    }

    <T> void findPath(Graph g, GNode<T> head, GNode<T> last, Stack<GNode> path) {
        // init queue
        Queue<GNode> queue = new LinkedList<>();
        // add root to the queue (at the end)
        queue.add(head);
        head.status = GNode.Status.DISCOVERED;

        // while the queue is not empty
        while (!queue.isEmpty()) {
            // extract first from the queue
            GNode<T> actual = queue.remove();
            // process
            if (actual.status == GNode.Status.DISCOVERED) {
//                process(actual);
                actual.status = GNode.Status.PROCESSED;
            }
            // loop through all the other one
            for (GNode n : actual.adj) {
                if (n.status != GNode.Status.PROCESSED || g.isDirected) {
//                    processEdge(actual, n);
                }
                // add to the queue if not visited
                if (n.status == GNode.Status.UNDISCOVERED) {
                    queue.add(n);
                    n.parent = actual;
                    n.status = GNode.Status.DISCOVERED;
                    if(n==last)
                    {
                        break;
                    }
                }
            }
        }
        while(last!=null)
        {
            path.push(last);
            last = last.parent;
        }
    }

    private void findPath(GNode gNode1, GNode gNode2) {
        if(gNode1==gNode2)
        {
            System.out.print(gNode1+" <- ");
            list.add(gNode1);
        }
        else
        {
            findPath(gNode1,gNode2.parent);
            System.out.print(gNode2+" <- ");
            list.add(gNode2);
        }
    }
}
