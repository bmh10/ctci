package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

    // Time O(N) Space O(N)
    public boolean intersect(Node l1, Node l2) {
        final Set<Node> nodes = new HashSet<Node>();
        Node n = l1;
        while (n != null) {
            nodes.add(n);
            n = n.next;
        }

        n = l2;
        while (n != null) {
            // Contains() uses hash code which will compare nodes by reference
            // not value, since hash code has not been overridden
            if (nodes.contains(n)) {
                return true;
            }

            n = n.next;
        }

        return false;
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
        Node common = new Node(2, new Node(5, null));
        Node l1 = new Node(1, common);
        Node l2 = new Node(4, new Node(4, common));
        Assert.assertTrue(intersect(l1, l2));

        l1 = new Node(1, new Node(2, new Node(3, null)));
        l2 = new Node(4, new Node(2, new Node(3, null)));
        Assert.assertFalse(intersect(l1, l2));
    }
}
