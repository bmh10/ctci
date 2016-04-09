package c2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class RemoveDups {

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

    @Test
    public void test() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(3); add(3); add(4); add(1); add(5); add(4); add(1);
        }};

        final LinkedList<Integer> Aans = new LinkedList<Integer>() {{
            add(3); add(4); add(1); add(5);
        }};

        removeDups(A);
        Assert.assertEquals(Aans, A);
    }

}
