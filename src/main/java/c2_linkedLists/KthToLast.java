package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class KthToLast {

    // Time O(n) (get internally iterates linked list)
    // Space O(1)
    public Object getKthToLast(LinkedList list, int k) {
        if (k < 1 || k > list.size()) {
            throw new IndexOutOfBoundsException("k must be >= 1 and <= size of linked list");
        }

        return list.get(list.size() - k);
    }

    @Test
    public void test() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(3); add(3); add(4); add(1); add(5); add(4); add(1);
        }};

        Assert.assertEquals(1, getKthToLast(A, 1));
        Assert.assertEquals(4, getKthToLast(A, 2));
        Assert.assertEquals(1, getKthToLast(A, 4));
        Assert.assertEquals(3, getKthToLast(A, 7));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void test_negativeK() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(3); add(3); add(4); add(1); add(5); add(4); add(1);
        }};

        getKthToLast(A, 0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void test_largeK() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(3); add(3); add(4); add(1); add(5); add(4); add(1);
        }};

        getKthToLast(A, 8);
    }
}
