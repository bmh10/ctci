package c2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDups {

    // Time O(n) Space O(n)
    public void removeDups(LinkedList list) {
        Set seen = new HashSet();

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (seen.contains(o)) {
                it.remove();
            }

            seen.add(o);
        }
    }

    // Time O(n^2) Space O(1)
    public void removeDupsNoBuffer(LinkedList list) {
        Iterator it = list.iterator();
        int idx = 0;

        while (it.hasNext()) {
            Object o = it.next();
            // Use same iterator object for inner iterator
            // to avoid concurrent modification exception
            it = list.listIterator(idx + 1);

            while (it.hasNext()) {
                Object innerO = it.next();
                if (o.equals(innerO)) {
                    it.remove();
                }
            }

            idx++;
            it = list.listIterator(idx);
        }
    }

    @Test
    public void test() {
        final LinkedList<Integer> A1 = new LinkedList<Integer>() {{
            add(3); add(3); add(4); add(1); add(5); add(4); add(1);
        }};

        final LinkedList<Integer> A2 = new LinkedList<Integer>(A1);

        final LinkedList<Integer> Aans = new LinkedList<Integer>() {{
            add(3); add(4); add(1); add(5);
        }};


        removeDups(A1);
        Assert.assertEquals(Aans, A1);

        removeDupsNoBuffer(A2);
        Assert.assertEquals(Aans, A2);
    }
}
