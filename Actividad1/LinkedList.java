package Actividad1;

public class LinkedList {
    Node head;
    Node tail;

    public void insert(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public Object removeTail() {
        if (tail == null) return null;
        Node current = head;
        if (head == tail) {
            Object val = tail.value;
            head = tail = null;
            return val;
        }
        while (current.next != tail) {
            current = current.next;
        }
        Object val = tail.value;
        tail = current;
        tail.next = null;
        return val;
    }

    public Object removeHead() {
        if (head == null) return null;
        Object val = head.value;
        head = head.next;
        if (head == null) tail = null; 
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node current = head;
        if (current == null) {
            System.out.println("Lista vacía.");
            return;
        }
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
