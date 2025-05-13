import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T e) {
        list.addLast(e);
    }

    public T dequeue() {
        if (isEmpty()) return null;
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if (isEmpty()) return null;
        return list.getFirst();
    }
}