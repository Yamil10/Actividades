package Actividad1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack comandos = new Stack();
        Queue procesos = new Queue();

        int opcion = 0;

        do {
            try {
                System.out.println("Menu");
                System.out.println("1) Agregar comando");
                System.out.println("2) Agregar proceso");
                System.out.println("3) Mostrar comandos y procesos pendientes");
                System.out.println("4) Ejecutar último comando");
                System.out.println("5) Ejecutar primer proceso");
                System.out.println("6) Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1:
                        String comando;
                        do {
                            System.out.print("Ingrese un comando: ");
                            comando = sc.nextLine();
                            comandos.push(comando);

                            String respuesta;
                            while (true) {
                                System.out.print("¿Desea agregar otro comando? (s/n):");
                                respuesta = sc.nextLine().trim().toLowerCase();
                                if (respuesta.equals("s") || respuesta.equals("n")) break;
                                System.out.println("Respuesta inválida. Por favor ingrese 's' o 'n'");
                            }
                            if (respuesta.equals("n")) break;
                        } while (true);
                        break;

                    case 2:
                        String proceso;
                        do {
                            System.out.print("Ingrese un proceso:");
                            proceso = sc.nextLine();
                            procesos.enqueue(proceso);

                            String respuesta;
                            while (true) {
                                System.out.print("¿Desea agregar otro proceso? (s/n):");
                                respuesta = sc.nextLine().trim().toLowerCase();
                                if (respuesta.equals("s") || respuesta.equals("n")) break;
                                System.out.println("Respuesta inválida. Por favor ingrese 's' o 'n'");
                            }
                            if (respuesta.equals("n")) break;
                        } while (true);
                        break;

                    case 3:
                        System.out.println("Comandos pendientes:");
                        comandos.printStack();
                        System.out.println("Procesos pendientes:");
                        procesos.printQueue();
                        break;

                    case 4:
                        Object ultimoComando = comandos.pop();
                        if (ultimoComando != null)
                            System.out.println("Ejecutando último comando:" + ultimoComando);
                        else
                            System.out.println("No hay comandos para ejecutar");
                        break;

                    case 5:
                        Object primerProceso = procesos.dequeue();
                        if (primerProceso != null)
                            System.out.println("Ejecutando primer proceso: " + primerProceso);
                        else
                            System.out.println("No hay procesos para ejecutar");
                        break;

                    case 6:
                        System.out.println("Has salido del programa");
                        break;

                    default:
                        System.out.println("Opción inválida, intente de nuevo");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido");
                sc.nextLine(); 
            }

        } while (opcion != 6);

        sc.close();
    }
}
