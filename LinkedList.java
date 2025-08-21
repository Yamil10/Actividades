package Actividad1;

public class LinkedList {
    private enum ListType {
        SIMPLE, DOBLE, CIRCULAR
    }

    private Node<Contacto> firstNode;
    private Node<Contacto> lastNode;
    private final ListType type;

    public LinkedList(String type) {
        this.firstNode = null;
        this.lastNode = null;
        this.type = ListType.valueOf(type.toUpperCase());
    }

    public void insertar(Contacto contacto) {
        Node<Contacto> newNode = new Node<>(contacto);
        switch (type) {
            case SIMPLE:
                insertarSimple(newNode);
                break;
            case DOBLE:
                insertarDoble(newNode);
                break;
            case CIRCULAR:
                insertarCircular(newNode);
                break;
        }
    }

    private void insertarSimple(Node<Contacto> newNode) {
        if (this.firstNode == null) {
            this.firstNode = newNode;
        } else {
            Node<Contacto> actual = this.firstNode;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
    }

    private void insertarDoble(Node<Contacto> newNode) {
        if (this.firstNode == null) {
            this.firstNode = newNode;
            this.lastNode = newNode;
        } else {
            newNode.setPrevious(this.lastNode);
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
        }
    }

    private void insertarCircular(Node<Contacto> newNode) {
        if (firstNode == null) {
            firstNode = newNode;
            firstNode.setNext(firstNode);
        } else {
            Node<Contacto> current = firstNode;
            while (current.getNext() != firstNode) {
                current = current.getNext();
            }
            newNode.setNext(firstNode);
            current.setNext(newNode);
            firstNode = newNode;
        }
    }

    public void mostrarLista() {
    if (firstNode == null) {
        System.out.println("La lista está vacía");
        return;
    }

    switch (type) {
        case SIMPLE:
            mostrarListaSimple();
            break;
        case DOBLE:
            mostrarListaDoble();
            break;
        case CIRCULAR:
            mostrarListaCircular();
            break;
    }
}

private void mostrarListaSimple() {
    Node<Contacto> current = firstNode;
    while (current != null) {
        System.out.print(current.getData() + " -> ");
        current = current.getNext();
    }
    System.out.println("null");
}

private void mostrarListaDoble() {
    Node<Contacto> current = firstNode;
    while (current != null) {
        if (current.getNext() != null) {
            System.out.print(current.getData() + " <-> ");
        } else {
            System.out.print(current.getData());
        }
        current = current.getNext();
    }
    System.out.println();
}

private void mostrarListaCircular() {
    Node<Contacto> current = firstNode;
    if (current != null) {
        do {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        } while (current != firstNode);
        System.out.println("(regresa al inicio de la lista circular)");
    }
}

    public int encontrar(Contacto contacto) {
        if (firstNode == null) {
            return -1;
        }
        Node<Contacto> current = firstNode;
        int posicion = 1;
        do {
            if (current.getData().equals(contacto)) {
                return posicion;
            }
            current = current.getNext();
            posicion++;
        } while (current != null && current != firstNode);
        return -1;
    }

    public boolean actualizar(Contacto viejo, Contacto nuevo) {
        if (firstNode == null) {
            return false;
        }
        Node<Contacto> current = firstNode;
        do {
            if (current.getData().equals(viejo)) {
                current.setData(nuevo);
                return true;
            }
            current = current.getNext();
        } while (current != null && current != firstNode);
        return false;
    }

    public boolean borrarNodo(Contacto contacto) {
        if (firstNode == null) {
            return false;
        }

        if (firstNode.getData().equals(contacto)) {
            switch (type) {
                case SIMPLE:
                case DOBLE:
                    firstNode = firstNode.getNext();
                    if (firstNode != null && type == ListType.DOBLE) {
                        firstNode.setPrevious(null);
                    }
                    if (firstNode == null && type == ListType.DOBLE) {
                        lastNode = null;
                    }
                    break;
                case CIRCULAR:
                    if (firstNode.getNext() == firstNode) {
                        firstNode = null;
                    } else {
                        Node<Contacto> temp = firstNode;
                        while (temp.getNext() != firstNode) {
                            temp = temp.getNext();
                        }
                        firstNode = firstNode.getNext();
                        temp.setNext(firstNode);
                    }
                    break;
            }
            return true;
        }

        Node<Contacto> current = firstNode;
        while (current.getNext() != null && current.getNext() != firstNode) {
            if (current.getNext().getData().equals(contacto)) {
                if (type == ListType.DOBLE) {
                    Node<Contacto> temp = current.getNext().getNext();
                    current.setNext(temp);
                    if (temp != null) {
                        temp.setPrevious(current);
                    } else {
                        lastNode = current;
                    }
                } else {
                    current.setNext(current.getNext().getNext());
                }
                return true;
            }
            current = current.getNext();
        }

        return false;
    }
}