package c3_stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SortStack {

    public void sortStack(final Deque<Integer> stack) {
        final Deque<Integer> tmpStack = new ArrayDeque<Integer>();

        for (int sortedCount = 0; sortedCount < stack.size(); sortedCount++) {
            assert(tmpStack.isEmpty());

            int max = stack.pop();
            while (stack.size() > sortedCount) {
                int curr = stack.pop();
                if (curr > max) {
                    tmpStack.push(max);
                    max = curr;
                } else {
                    tmpStack.push(curr);
                }
            }

            // Push max back to main stack
            stack.push(max);

            // Copy other elements back to main stack
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
        }
    }

    @Test
    public void test() {
        final int[] nums = { 5, 1, 5, 71, 15, 90, 9, -1 };
        final Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int n : nums) {
            stack.push(n);
        }

        sortStack(stack);
        Arrays.sort(nums);

        for (int n : nums) {
            Assert.assertEquals(n, (long) stack.pop());
        }
    }
}
