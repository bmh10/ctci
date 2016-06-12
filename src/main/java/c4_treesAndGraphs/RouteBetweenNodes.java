package c4_treesAndGraphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RouteBetweenNodes {


    private class Node {
        private String name;
        private boolean visited;
        private List<Node> children;

        Node(String name) {
            this.name = name;
            this.visited = false;
            this.children = new ArrayList<Node>();
        }

        private void addChild(Node n) {
            children.add(n);
        }
    }

    public boolean isRouteBetweenBFS(final Node start, final Node end) {
        final Deque<Node> q = new ArrayDeque<Node>();
        q.add(start);
        Node curr;
        while (!q.isEmpty()) {
            curr = q.removeFirst();
            if (curr.name.equals(end.name)) {
                return true;
            }
            curr.visited = true;

            for (Node child : curr.children) {
                if (!child.visited) {
                    q.addLast(child);
                }
            }
        }

        return false;
    }

    public boolean isRouteBetweenDFS(final Node start, final Node end) {
        if (start.name.equals(end.name)) {
            return true;
        }

        start.visited = true;

        for (Node child : start.children) {
            if (!child.visited) {
                if (isRouteBetweenDFS(child, end)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        final Node[] n = {
            new Node("0"),
            new Node("1"),
            new Node("2"),
            new Node("3"),
            new Node("4"),
            new Node("5")};

        n[0].addChild(n[1]);
        n[0].addChild(n[4]);
        n[0].addChild(n[5]);
        n[1].addChild(n[3]);
        n[1].addChild(n[4]);
        n[2].addChild(n[1]);
        n[3].addChild(n[2]);
        n[3].addChild(n[4]);

        Assert.assertTrue(isRouteBetweenBFS(n[2], n[2]));
        resetVisited(n);
        Assert.assertTrue(isRouteBetweenBFS(n[0], n[3]));
        resetVisited(n);
        Assert.assertFalse(isRouteBetweenBFS(n[5], n[2]));

        resetVisited(n);
        Assert.assertTrue(isRouteBetweenDFS(n[2], n[2]));
        resetVisited(n);
        Assert.assertTrue(isRouteBetweenDFS(n[0], n[3]));
        resetVisited(n);
        Assert.assertFalse(isRouteBetweenDFS(n[5], n[2]));
    }

    private void resetVisited(Node[] nodes) {
        for (Node n : nodes) {
            n.visited = false;
        }
    }
}
