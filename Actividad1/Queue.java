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
        Node current = list.head;
        if (current == null) {
            System.out.println("Lista vacía.");
            return;
        }
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }
}
