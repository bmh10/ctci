package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

public class DeleteMiddleNode {

    // Delete node from linked list with access only to that node
    public void deleteMiddleNode(Node n) {
        n.val = n.next.val;
        n.next = n.next.next;
    }

    private class Node {
        private Object val;
        private Node next;

        Node(Object val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private String nodeToString(Node n) {
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb = sb.append(n.val + " ");
            n = n.next;
        }

        return sb.toString().trim();
    }

    @Test
    public void test() {
        Node head = new Node("a", new Node("b", new Node("c", new Node("d", new Node("e", null)))));
        Node cnode = head.next.next;

        Assert.assertEquals("a b c d e", nodeToString(head));
        deleteMiddleNode(cnode);
        Assert.assertEquals("a b d e", nodeToString(head));
    }
}
