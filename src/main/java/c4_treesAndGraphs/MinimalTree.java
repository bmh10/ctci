package c4_treesAndGraphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MinimalTree {

    public Node createMinimalTree(final int[] values) {
        return createMinimalTree(values, 0, values.length - 1);
    }

    private Node createMinimalTree(final int[] values, final int start, final int end) {
        if (end < start) {
            return null;
        }

        final int mid = (start + end) / 2;
        final Node n = new Node(values[mid]);
        n.leftChild = createMinimalTree(values, start, mid - 1);
        n.rightChild = createMinimalTree(values, mid + 1, end);
        return n;
    }

    private class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        Node(final int value) {
            this.value = value;
        }
    }

    @Test
    public void test() {
        final int[] arr = { 2, 5, 7, 9, 11, 15 };
        final Node root = createMinimalTree(arr);

        final List<Integer> flatTree = new ArrayList<Integer>();
        flattenTreeInOrder(root, flatTree);
        final Integer[] flatTreeArr = flatTree.toArray(new Integer[flatTree.size()]);
        Assert.assertEquals(Arrays.toString(arr), Arrays.toString(flatTreeArr));
    }

    private void flattenTreeInOrder(final Node n, final List<Integer> vals) {
        if (n.leftChild != null) {
            flattenTreeInOrder(n.leftChild, vals);
        }
        vals.add(n.value);
        if (n.rightChild != null) {
            flattenTreeInOrder(n.rightChild, vals);
        }
    }
}
