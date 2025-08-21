package Actividad1;

public class Queue {
    private LinkedList list = new LinkedList();

    public void enqueue(Object data) {
        list.insert(data);
    }

    public Object dequeue() {
        return list.removeHead();
    }

    public Object peek() {
        return list.head != null ? list.head.value : null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void printQueue() {
        list.printList();
    }
}
