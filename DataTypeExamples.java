package Actividad1;

public class DataTypeExamples {
    public void ejemploListaSimple() {
        LinkedList listaContactos = new LinkedList("simple");
        listaContactos.insertar(new Contacto("Arturo", "Calle A", "123456789", 5000.0));
        listaContactos.insertar(new Contacto("Betty", "Calle B", "987654321", 6000.0));

        System.out.println("Lista Simple de Contactos:");
        listaContactos.mostrarLista();
    }

    public void ejemploListaDoble() {
        LinkedList listaContactos = new LinkedList("doble");
        listaContactos.insertar(new Contacto("A", "Dir A", "111", 1000.0));
        listaContactos.insertar(new Contacto("B", "Dir B", "222", 2000.0));

        System.out.println("Lista Doble de Contactos:");
        listaContactos.mostrarLista();
    }

    public void ejemploListaCircular() {
        LinkedList listaContactos = new LinkedList("circular");
        listaContactos.insertar(new Contacto("Felipe", "Calle F", "555", 9000.0));
        listaContactos.insertar(new Contacto("Gaby", "Calle G", "666", 10000.0));

        System.out.println("Lista Circular de Contactos:");
        listaContactos.mostrarLista();
    }
}