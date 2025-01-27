package chapter24;

public class Exercise24_05<E> extends java.util.LinkedList<E> {

    // Enqueue method adds to the end of the list
    public void enqueue(E e) {
        this.addLast(e);
    }

    // Dequeue method removes from the front of the list
    public E dequeue() {
        return this.removeFirst();
    }

    // Get the size of the queue
    public int getSize() {
        return this.size();
    }

    // Override toString to provide a custom string representation of the queue
    @Override
    public String toString() {
        return "Queue: " + super.toString();
    }
}