package c3_stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class AnimalShelter {

    private final Deque<Cat> cats = new ArrayDeque<Cat>();
    private final Deque<Dog> dogs = new ArrayDeque<Dog>();

    public void enqueue(final Animal animal) {
        animal.setEnqueuedTime(System.currentTimeMillis());
        if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        } else if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (cats.isEmpty()) {
            return dogs.getFirst();
        }

        if (dogs.isEmpty()) {
            return cats.getFirst();
        }

        final Cat oldestCat = cats.peekFirst();
        final Dog oldestDog = dogs.peekFirst();
        if (oldestCat.isOlderThan(oldestDog)) {
            return cats.pollFirst();
        } else {
            return dogs.pollFirst();
        }
    }

    public Dog dequeueDog() {
        return dogs.pollFirst();
    }

    public Cat dequeueCat() {
        return cats.pollFirst();
    }

    private class Cat extends Animal {
        Cat(String name) {
            super(name);
        }
    }

    private class Dog extends Animal {
        Dog(String name) {
            super(name);
        }
    }

    private abstract class Animal {

        private final String name;
        private long enqueuedTime;

        Animal(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setEnqueuedTime(final long enqueuedTime) {
            this.enqueuedTime = enqueuedTime;
        }

        public boolean isOlderThan(final Animal other) {
            return enqueuedTime < other.enqueuedTime;
        }
    }



    @Test
    public void test() {
        final AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Dog("Ben"));
        shelter.enqueue(new Cat("Pixel"));
        shelter.enqueue(new Cat("Trixie"));
        shelter.enqueue(new Dog("Buster"));

        Assert.assertEquals("Ben", shelter.dequeueAny().getName());
        Assert.assertEquals("Pixel", shelter.dequeueCat().getName());
        Assert.assertEquals("Buster", shelter.dequeueDog().getName());
        Assert.assertEquals("Trixie", shelter.dequeueAny().getName());
    }
}
