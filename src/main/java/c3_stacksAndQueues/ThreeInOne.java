package c3_stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

public class ThreeInOne {

    // Implement 3 stacks using 1 array
    class TriStack {

        private int stackSize;
        private Object[] triStack;
        private int[] pointers;

        public TriStack(int stackSize) {
            this.stackSize = stackSize;
            this.triStack = new Object[3*stackSize];
            pointers = new int[3];
            for (int i = 0; i < 3; i++) {
                pointers[i] = getStackMinIdx(i);
            }
        }

        public void push(int stack, Object val) throws Exception {
            checkStackIdx(stack);
            if (pointers[stack] > getStackMaxIdx(stack)) {
                throw new Exception(String.format("Stack %s is full"));
            }

            triStack[pointers[stack]] = val;
            pointers[stack]++;
        }

        public Object pop(int stack) throws Exception {
            checkStackIdx(stack);
            if (pointers[stack] == getStackMinIdx(stack)) {
                throw new Exception(String.format("Stack %s is empty"));
            }

            pointers[stack]--;
            return triStack[pointers[stack]];
        }

        public Object peek(int stack) throws Exception {
            checkStackIdx(stack);
            if (pointers[stack] == getStackMinIdx(stack)) {
                throw new Exception(String.format("Stack %s is empty"));
            }

            return triStack[pointers[stack] - 1];
        }

        private void checkStackIdx(int stack) throws Exception {
            if (stack < 0 || stack > 2) {
                throw new Exception("Stack index should be 0, 1 or 2");
            }
        }

        private int getStackMaxIdx(int stack) {
            return ((stack + 1) * stackSize) - 1;
        }

        private int getStackMinIdx(int stack) {
            return stack * stackSize;
        }
    }

    @Test
    public void test() throws Exception {
        final TriStack triStack = new TriStack(3);
        triStack.push(0, 0);
        triStack.push(1, 3);
        triStack.push(2, 6);
        triStack.push(2, 7);
        triStack.push(1, 4);
        triStack.push(0, 1);

        Assert.assertEquals(1, triStack.peek(0));
        Assert.assertEquals(4, triStack.peek(1));
        Assert.assertEquals(7, triStack.peek(2));

        Assert.assertEquals(1, triStack.pop(0));
        Assert.assertEquals(4, triStack.pop(1));
        Assert.assertEquals(7, triStack.pop(2));

        Assert.assertEquals(0, triStack.pop(0));
        Assert.assertEquals(3, triStack.pop(1));
        Assert.assertEquals(6, triStack.pop(2));
    }

    @Test (expected = Exception.class)
    public void test_peekEmptyStack() throws Exception {
        final TriStack triStack = new TriStack(3);
        triStack.peek(1);
    }

    @Test (expected = Exception.class)
    public void test_popEmptyStack() throws Exception {
        final TriStack triStack = new TriStack(3);
        triStack.pop(2);
    }

    @Test (expected = Exception.class)
    public void test_pushToFullStack() throws Exception {
        final TriStack triStack = new TriStack(2);
        triStack.push(1, 3);
        triStack.push(1, 4);
        triStack.push(1, 5);
    }

    @Test (expected = Exception.class)
    public void test_badStackIndex() throws Exception {
        final TriStack triStack = new TriStack(3);
        triStack.pop(5);
    }
}
