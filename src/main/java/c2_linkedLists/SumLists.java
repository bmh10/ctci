package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class SumLists {

    // Time O(N) Space O(N)
    public LinkedList<Integer> sumListsReverse(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        final LinkedList<Integer> res = new LinkedList<Integer>();
        final Iterator<Integer> it1 = l1.iterator();
        final Iterator<Integer> it2 = l2.iterator();
        int carry = 0;

        while (it1.hasNext() || it2.hasNext()) {
            int v1 = it1.hasNext() ? it1.next() : 0;
            int v2 = it1.hasNext() ? it2.next() : 0;
            int sum = v1 + v2 + carry;
            carry = Math.floorDiv(sum, 10);
            res.add(sum % 10);
        }

        return res;
    }

    // Time O(N) Space O(N)
    public LinkedList<Integer> sumListsForwards(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Iterator<Integer> it = l1.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb = sb.append(it.next());
        }

        int sum = Integer.parseInt(sb.toString());

        it = l2.iterator();
        sb = new StringBuilder();
        while (it.hasNext()) {
            sb = sb.append(it.next());
        }

        sum += Integer.parseInt(sb.toString());

        final LinkedList<Integer> res = new LinkedList<Integer>();
        for (char c : Integer.toString(sum).toCharArray()) {
            res.addLast(Integer.parseInt(c + ""));
        }

        return res;
    }

    @Test
    public void test_sumListsReverse() {
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

    @Test
    public void test_sumListsForwards() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(3); add(6); add(1); add(7);
        }};

        final LinkedList<Integer> B = new LinkedList<Integer>() {{
            add(2); add(9); add(5);
        }};

        final LinkedList<Integer> ans = new LinkedList<Integer>() {{
            add(3); add(9); add(1); add(2);
        }};

        Assert.assertEquals(ans, sumListsForwards(A, B));
    }
}
