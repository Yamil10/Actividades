package Actividad1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones");
            System.out.println("1. Crear y gestionar una lista simple");
            System.out.println("2. Crear y gestionar una lista doble");
            System.out.println("3. Crear y gestionar una lista circular");
            System.out.println("4. Ver ejemplo de lista simple");
            System.out.println("5. Ver ejemplo de lista doble");
            System.out.println("6. Ver ejemplo de lista circular");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida ingresa un número del 1 al 7");
                scanner.nextLine(); 
                opcion = 0; 
            }

            switch (opcion) {
                case 1:
                    gestionarLista("simple", scanner);
                    break;
                case 2:
                    gestionarLista("doble", scanner);
                    break;
                case 3:
                    gestionarLista("circular", scanner);
                    break;
                case 4:
                    new DataTypeExamples().ejemploListaSimple();
                    break;
                case 5:
                    new DataTypeExamples().ejemploListaDoble();
                    break;
                case 6:
                    new DataTypeExamples().ejemploListaCircular();
                    break;
                case 7:
                    System.out.println("Has salido del programa");
                    break;
                default:
                    if (opcion != 0) {
                        System.out.println("Opción no invalida intenta de nuevo");
                    }
                    break;
            }
        } while (opcion != 7);
    }

    private static void gestionarLista(String tipoLista, Scanner scanner) {
        LinkedList lista = new LinkedList(tipoLista);
        int opcionGestion;
        do {
            System.out.println(" Gestión de Lista " + tipoLista.substring(0, 1).toUpperCase() + tipoLista.substring(1) + "");
            System.out.println("1. Insertar contacto");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Encontrar contacto");
            System.out.println("4. Actualizar contacto");
            System.out.println("5. Borrar contacto");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcionGestion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opción no inválida ingresa un número del 1 al 6");
                scanner.nextLine();
                opcionGestion = 0;
            }

            switch (opcionGestion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    double salario = 0;
                    boolean salarioValido = false;
                    while (!salarioValido) {
                        try {
                            System.out.print("Salario: ");
                            salario = scanner.nextDouble();
                            salarioValido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada no válida para el salario ingresa un número");
                            scanner.nextLine();
                        }
                    }
                    scanner.nextLine();
                    lista.insertar(new Contacto(nombre, direccion, telefono, salario));
                    System.out.println("Contacto agregado");
                    break;
                case 2:
                    lista.mostrarLista();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto a buscar: ");
                    String telefonoBuscar = scanner.nextLine();
                    Contacto contactoBuscar = new Contacto(nombreBuscar, null, telefonoBuscar, 0);
                    int posicion = lista.encontrar(contactoBuscar);
                    if (posicion != -1) {
                        System.out.println("Contacto encontrado en la posición: " + posicion);
                    } else {
                        System.out.println("No se encontro el contacto");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del contacto a actualizar: ");
                    String nombreViejo = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto a actualizar: ");
                    String telefonoViejo = scanner.nextLine();
                    Contacto contactoViejo = new Contacto(nombreViejo, null, telefonoViejo, 0);

                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese la nueva dirección: ");
                    String nuevaDireccion = scanner.nextLine();
                    System.out.print("Ingrese el nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    double nuevoSalario = 0;
                    boolean nuevoSalarioValido = false;
                    while (!nuevoSalarioValido) {
                        try {
                            System.out.print("Ingrese el nuevo salario: ");
                            nuevoSalario = scanner.nextDouble();
                            nuevoSalarioValido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada no inválida para el salario ingresa un número");
                            scanner.nextLine();
                        }
                    }
                    scanner.nextLine();
                    Contacto contactoNuevo = new Contacto(nuevoNombre, nuevaDireccion, nuevoTelefono, nuevoSalario);

                    if (lista.actualizar(contactoViejo, contactoNuevo)) {
                        System.out.println("Contacto actualizado");
                    } else {
                        System.out.println("No se encontró el contacto para actualiza");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del contacto a borrar: ");
                    String nombreBorrar = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto a borrar: ");
                    String telefonoBorrar = scanner.nextLine();
                    Contacto contactoBorrar = new Contacto(nombreBorrar, null, telefonoBorrar, 0);

                    if (lista.borrarNodo(contactoBorrar)) {
                        System.out.println("Contacto borrado");
                    } else {
                        System.out.println("No se encontró el contacto para borrar");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    if (opcionGestion != 0) {
                        System.out.println("Opción no inválida intenta de nuevo");
                    }
            }
        } while (opcionGestion != 6);
    }
}