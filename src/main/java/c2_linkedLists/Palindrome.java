package c2_linkedLists;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Palindrome {

    // Time O(N) Space O(N)
    public boolean isPalindrome_singlyLinked(LinkedList<Integer> L) {
        final Deque<Integer> stack = new ArrayDeque<Integer>();
        final int mirrorPoint = (int)Math.ceil((double)L.size() / 2d);
        boolean pastMirrorPoint = false;

        final Iterator<Integer> it = L.iterator();
        int idx = 0;
        while (it.hasNext()) {
            if (!pastMirrorPoint) {
                stack.push(it.next());
            } else {
                if (it.next() != stack.pop()) {
                    return false;
                }
            }

            idx++;
            if (!pastMirrorPoint && idx >= mirrorPoint) {
                pastMirrorPoint = true;
                if (L.size() % 2 == 1) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isPalindrome_doublyLinked(LinkedList<Integer> L) {
        // TODO
        return false;
    }

    @Test
    public void test_sumListsReverse() {
        final LinkedList<Integer> A = new LinkedList<Integer>() {{
            add(1); add(2); add(3); add(2); add(1);
        }};

        final LinkedList<Integer> B = new LinkedList<Integer>() {{
            add(1); add(2); add(2); add(1);
        }};

        final LinkedList<Integer> C = new LinkedList<Integer>() {{
            add(1); add(2); add(2); add(2);
        }};

        Assert.assertTrue(isPalindrome_singlyLinked(A));
        Assert.assertTrue(isPalindrome_singlyLinked(B));
        Assert.assertFalse(isPalindrome_singlyLinked(C));
    }
}
