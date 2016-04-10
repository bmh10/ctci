package c3_stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackMin {

    // Create stack with a min() operation which runs in O(1)
    // Approach: use another stack to keep track of min history
    class MinStack {

        final Deque<Integer> actualStack;
        final Deque<Integer> minHistoryStack;

        public MinStack() {
            this.actualStack = new ArrayDeque();
            this.minHistoryStack = new ArrayDeque();
        }

        public void push(int i) {
            actualStack.push(i);
            Integer prevMin = min();
            if (prevMin == null || i <= prevMin) {
                minHistoryStack.push(i);
            }
        }

        public Integer pop() {
            Integer val = actualStack.pop();
            if (val != null && min() != null && val == min()) {
                minHistoryStack.pop();
            }

            return val;
        }

        public Integer min() {
            return minHistoryStack.peek();
        }
    }

    @Test
    public void test() throws Exception {
        final MinStack stack = new MinStack();
        Assert.assertEquals(null, stack.min()); // {}

        stack.push(3); // { 3 }
        Assert.assertEquals(3, (int) stack.min());

        stack.push(4); // { 3 4 }
        Assert.assertEquals(3, (int) stack.min());

        stack.push(1); // { 3 4 1 }
        Assert.assertEquals(1, (int) stack.min());

        stack.push(1); // { 3 4 1 1 }
        Assert.assertEquals(1, (int) stack.min());

        int val = stack.pop(); // { 3 4 1 }
        Assert.assertEquals(1, val);
        Assert.assertEquals(1, (int) stack.min());

        stack.push(2); // { 3 4 1 2 }
        Assert.assertEquals(1, (int) stack.min());

        val = stack.pop(); // { 3 4 1 }
        Assert.assertEquals(2, val);
        Assert.assertEquals(1, (int) stack.min());

        val = stack.pop(); // { 3 4 }
        Assert.assertEquals(1, val);
        Assert.assertEquals(3, (int) stack.min());

        val = stack.pop(); // { 3 }
        Assert.assertEquals(4, val);
        Assert.assertEquals(3, (int) stack.min());

        val = stack.pop(); // {}
        Assert.assertEquals(3, val);
        Assert.assertEquals(null, stack.min());
    }
}
