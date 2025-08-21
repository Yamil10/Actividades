package Actividad1;

public class Stack {
    private LinkedList list = new LinkedList();

    public void push(Object data) {
        list.insert(data);
    }

    public Object pop() {
        return list.removeTail(); 
    }

    public Object peek() {
        return list.tail != null ? list.tail.value : null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void printStack() {
        list.printList();
    }
}