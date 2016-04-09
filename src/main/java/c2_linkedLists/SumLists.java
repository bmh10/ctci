package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class SumLists {

    public LinkedList<Integer> sumListsReverse(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        final LinkedList<Integer> res = new LinkedList<Integer>();
        int carry = 0;
        final Iterator<Integer> it1 = l1.iterator();
        final Iterator<Integer> it2 = l2.iterator();

        while (it1.hasNext() || it2.hasNext()) {
            int v1 = it1.hasNext() ? it1.next() : 0;
            int v2 = it1.hasNext() ? it2.next() : 0;
            int sum = v1 + v2 + carry;
            carry = Math.floorDiv(sum, 10);
            res.add(sum % 10);
        }

        return res;
    }

    @Test
    public void test() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(7); add(1); add(6); add(3);
        }};

        final LinkedList<Integer> B = new LinkedList<Integer>() {{
            add(5); add(9); add(2);
        }};

        final LinkedList<Integer> ans = new LinkedList<Integer>() {{
            add(2); add(1); add(9); add(3);
        }};

        Assert.assertEquals(ans, sumListsReverse(A, B));
    }
}
