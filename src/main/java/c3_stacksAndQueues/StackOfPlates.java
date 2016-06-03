package c3_stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StackOfPlates {

    class SetOfStacks {

        final int MAX_STACK_SIZE = 2;
        final List<Deque<Integer>> stackSet;
        int currentStackIdx = 0;

        public SetOfStacks() {
            stackSet = new ArrayList<Deque<Integer>>();
        }

        public void push(int i) {
            Deque<Integer> currentStack = getStack(currentStackIdx);
            if (currentStack.size() >= MAX_STACK_SIZE) {
                currentStackIdx++;
                currentStack = getStack(currentStackIdx);
            }

            currentStack.push(i);
        }

        public int pop() {
            Deque<Integer> currentStack = getStack(currentStackIdx);
            if (currentStack.isEmpty()) {
                currentStackIdx--;
                currentStack = getStack(currentStackIdx);
            }

            return currentStack.pop();
        }

        // Pops stack at specific sub-stack index
        public int popAt(int stackIdx) {
            return getStack(stackIdx).pop();
        }

        // Not all stack may be full so cannot use o(1) calculation
        public int getSize() {
            int size = 0;
            for (Deque d : stackSet) {
                size += d.size();
            }

            return size;
        }

        public int getNumStacks() {
            return currentStackIdx + 1;
        }

        private Deque<Integer> getStack(int idx) {
            assert(idx >= 0);

            if (idx < stackSet.size()) {
                return stackSet.get(idx);
            }

            final Deque<Integer> stack = new ArrayDeque<Integer>();
            stackSet.add(idx, stack);
            return stack;
        }
    }

    @Test
    public void test() {
        final SetOfStacks stackSet = new SetOfStacks();
        Assert.assertEquals(0 , stackSet.getSize());
        Assert.assertEquals(1, stackSet.getNumStacks());

        stackSet.push(5); // { 5 }
        Assert.assertEquals(1, stackSet.getSize());
        Assert.assertEquals(1, stackSet.getNumStacks());

        stackSet.push(2); // { 5, 2 }
        Assert.assertEquals(2, stackSet.getSize());
        Assert.assertEquals(1, stackSet.getNumStacks());

        stackSet.push(1); // { 5, 2, 1 }
        Assert.assertEquals(3, stackSet.getSize());
        Assert.assertEquals(2, stackSet.getNumStacks());

        stackSet.push(3); // { 5, 2, 1, 3 }
        stackSet.push(6); // { 5, 2, 1, 3, 6 }

        Assert.assertEquals(5, stackSet.getSize());
        Assert.assertEquals(3, stackSet.getNumStacks());

        Assert.assertEquals(6, stackSet.pop());
        Assert.assertEquals(3, stackSet.pop());
        Assert.assertEquals(1, stackSet.pop());
        Assert.assertEquals(2, stackSet.pop());
        Assert.assertEquals(5, stackSet.pop());

        Assert.assertEquals(0, stackSet.getSize());
        Assert.assertEquals(1, stackSet.getNumStacks());
    }

    @Test
    public void test_popAt() {
        final SetOfStacks stackSet = new SetOfStacks();
        stackSet.push(7);
        stackSet.push(1);
        stackSet.push(8);
        stackSet.push(3);
        stackSet.push(5);

        Assert.assertEquals(5, stackSet.getSize());
        Assert.assertEquals(3, stackSet.getNumStacks());

        Assert.assertEquals(3, stackSet.popAt(1));
        Assert.assertEquals(1, stackSet.popAt(0));

        Assert.assertEquals(3, stackSet.getSize());
        Assert.assertEquals(3, stackSet.getNumStacks());

        Assert.assertEquals(5, stackSet.pop());
        Assert.assertEquals(8, stackSet.pop());
        Assert.assertEquals(7, stackSet.pop());
    }
}
