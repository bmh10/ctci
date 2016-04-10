package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {

    public Node detectLoop(Node head) {
        final Set<Node> seen = new HashSet<Node>();
        Node n = head;

        while (n != null) {
            if (seen.contains(n)) {
                return n;
            }

            seen.add(n);
            n = n.next;
        }

        return null;
    }

    private class Node {
        private Object val;
        private Node next;

        Node(Object val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test() {
        final Node e = new Node("E", null);
        final Node c = new Node("C", new Node("D", e));
        e.next = c;
        final Node head = new Node("A", new Node("B", c));

        Assert.assertEquals(c, detectLoop(head));

        final Node head2 = new Node("A", new Node("B", new Node("A", null)));
        Assert.assertEquals(null, detectLoop(head2));
    }
}
