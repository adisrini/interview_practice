package ch3.stacksqueues.practice;

import java.util.LinkedList;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis. People must
 * adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they
 * would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific
 * animal they would like. Create the data structures to maintain this system and implement operations such as enqueue,
 * dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class AnimalShelter {
    
    abstract class Animal {
        String name;
        int priority;
        Animal(String name) {
            this.name = name;
        }
        void setPriority(int priority) {
            this.priority = priority;
        }
        int getPriority() {
            return this.priority;
        }
        boolean isOlderThan(Animal other) {
            return this.priority < other.priority;
        }
        @Override
        public String toString() {
            return this.name;
        }
    }
    
    class Dog extends Animal {
        Dog(String name) {
            super(name);
        }
    }
    
    class Cat extends Animal {
        Cat(String name) {
            super(name);
        }
    }
    
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order;
    
    AnimalShelter() {
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
        order = 0;
    }
    
    public void enqueue(Animal a) {
        a.setPriority(order++);
        
        if(a instanceof Dog) { dogs.addLast((Dog) a); }
        if(a instanceof Cat) { cats.addLast((Cat) a); }
    }
    
    public Animal dequeueAny() {
        if(dogs.isEmpty()) {
            return cats.removeFirst();
        } else if(cats.isEmpty()) {
            return dogs.removeFirst();
        }
        return (cats.peek().isOlderThan(dogs.peek())) ? cats.removeFirst() : dogs.removeFirst();
    }
    
    public Dog dequeueDog() {
        return dogs.removeFirst();
    }
    
    public  Cat dequeueCat() {
        return cats.removeFirst();
    }
    
    public static void main(String[] args) {
        AnimalShelter s = new AnimalShelter();
        s.enqueue(s.new Cat("alex"));
        s.enqueue(s.new Cat("bobbi"));
        s.enqueue(s.new Dog("charlie"));
        s.enqueue(s.new Cat("dexter"));
        s.enqueue(s.new Dog("eli"));
        s.enqueue(s.new Dog("forrest"));
        s.enqueue(s.new Cat("gilbert"));
        System.out.println(s.dequeueAny());
        System.out.println(s.dequeueDog());
        System.out.println(s.dequeueDog());
        System.out.println(s.dequeueDog());
        System.out.println(s.dequeueAny());
    }

}
