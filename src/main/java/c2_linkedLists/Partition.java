package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class Partition {

    // Time O(n) Space O(n)
    public void partition(LinkedList<Integer> list, int x) {
        final LinkedList<Integer> lessPartition = new LinkedList<Integer>();

        // Move all elements < x into lessPartition
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i < x) {
                lessPartition.add(i);
                it.remove();
            }
        }

        // Add all elements in lessPartition to front of linked list
        it = lessPartition.iterator();
        while (it.hasNext()) {
            list.addFirst(it.next());
        }
    }

    private boolean isPartitionedCorrectly(LinkedList<Integer> list, int x) {
        boolean inRightPartition = false;
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            int val = it.next();
            if (val >= x) {
                inRightPartition = true;
            }

            if (inRightPartition && val < x) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(3); add(5); add(8); add(5); add(10); add(2); add(1);
        }};


        partition(A, 5);
        Assert.assertTrue(isPartitionedCorrectly(A, 5));
    }
}
