package c3_stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueViaStacks {

    class MyQueue {

        private Deque<Integer> newStack;
        private Deque<Integer> oldStack;

        public MyQueue() {
            newStack = new ArrayDeque<Integer>();
            oldStack = new ArrayDeque<Integer>();
        }

        public void add(int i) {
            newStack.push(i);
        }

        public int dequeue() {
            shiftToOldStack();
            return oldStack.pop();
        }

        public int peek() {
            shiftToOldStack();
            return oldStack.peek();
        }

        public int size() {
            return newStack.size() + oldStack.size();
        }

        private void shiftToOldStack() {
            if (oldStack.isEmpty()) {
                while (!newStack.isEmpty()) {
                    oldStack.push(newStack.pop());
                }
            }
        }
    }

    @Test
    public void test() {
        MyQueue q = new MyQueue();
        Assert.assertEquals(0, q.size());
        q.add(5);
        q.add(7);
        q.add(9); // { 5, 7, 9 }

        Assert.assertEquals(3, q.size());
        Assert.assertEquals(5, q.peek());
        Assert.assertEquals(3, q.size());
        Assert.assertEquals(5, q.dequeue());
        Assert.assertEquals(2, q.size());

        q.add(1); // { 7, 9, 1 }

        Assert.assertEquals(3, q.size());
        Assert.assertEquals(7, q.dequeue());
        Assert.assertEquals(9, q.dequeue());
        Assert.assertEquals(1, q.dequeue());
        Assert.assertEquals(0, q.size());
    }
}
