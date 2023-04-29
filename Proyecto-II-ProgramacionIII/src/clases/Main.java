package clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Atributos
        Scanner scanner = new Scanner(System.in);
        Matriz matriz = null;

        while (true) {
            System.out.println("\t-------Menu-------");
            System.out.println("1. Creacion de matriz ");
            System.out.println("2. Insertar vehículo en la matriz");
            System.out.println("3. Menu de busquedas en la matriz");
            System.out.println("4. Menu de eliminacion en la matriz");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            int menu = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Digite el número de filas : ");
                    int filas = scanner.nextInt();
                    System.out.println("Digite el número de columnas : ");
                    int columnas = scanner.nextInt();
                    //Validando si es simetrica
                    if (filas != columnas) {
                        System.out.println("\nNo se puede crear una matriz no simétrica.");
                        break;
                    }
                    //Creacion de objeto matriz  y asignacion de filas y columnas
                    matriz = new Matriz(filas, columnas);
                    System.out.println("Matriz creada con éxito.");
                    break;
                case 2:
                //Valida si es simetrica
                    if (matriz == null) {
                        System.out.println("\nDebe crear una matriz primero.");
                        break;
                    }
                    //Recibimiento de datos y luego asignacion
                    System.out.print("\nDigite la placa del vehículo a insertar: ");
                    String placa = scanner.next();
                    System.out.print("Digite el color del vehículo: ");
                    String color = scanner.next();
                    System.out.print("Digite la línea del vehículo: ");
                    String linea = scanner.next();
                    System.out.print("Digite el modelo del vehículo: ");
                    String modelo = scanner.next();
                    System.out.print("Digite el propietario del vehículo: ");
                    String propietario = scanner.next();
                    System.out.print("Digite la fila en la que desea insertar el vehículo: ");
                    int fila = scanner.nextInt();
                    System.out.print("Digite la columna en la que desea insertar el vehículo: ");
                    int columna = scanner.nextInt();
                    //Valida que este dentro del rango
                    if (!matriz.validarPosicion(fila, columna)) {
                        System.out.println("Posición inválida!");
                        break;
                    }
                    Vehiculo vehiculo = new Vehiculo(placa, color, linea, modelo, propietario);
                    matriz.insertar(fila, columna, vehiculo);
                    System.out.println("Vehículo insertado con éxito.");
                    matriz.imprimir();
                    break;
                // Busqueda
                case 3:
                    System.out.println("Menu de Busqueda ");
                    System.out.println("1. Por Placa");
                    System.out.println("2. Por Modelo y Propietario");
                    System.out.print("Opcion: ");
                    menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            // Validando busqueda solo por placa
                            if (matriz == null) {
                                System.out.println("\nDebe crear una matriz primero.");
                                break;
                            }
                            System.out.print("\nDigite la placa del vehículo a buscar: ");
                            placa = scanner.next();
                            Nodo nodobusqueda;
                            nodobusqueda = matriz.buscarxPlaca(placa);
                            if (nodobusqueda != null) {
                                System.out.println("El vehiculo: " + placa + " ha sido encontrado ");
                                System.out.println(nodobusqueda.getVehiculo());
                            } else {
                                System.out.println("El vehiculo: " + placa + " no se encuentra en la matriz");
                            }
                            break;
                        // Validando busqueda por dos campos
                        case 2:
                            if (matriz == null) {
                                System.out.println("\nDebe crear una matriz primero.");
                                break;
                            }
                            System.out.print("Ingrese modelo vehiculo: ");
                            modelo = scanner.next();
                            System.out.print("Ingrese propietario: ");
                            propietario = scanner.next();
                            matriz.busquedaDoble(modelo, propietario);
                            break;
                    }
                    break;
                // Eliminando
                case 4:
                    // Menu de Eliminacion
                    System.out.println("Menu eliminacion");
                    System.out.println("1. Por fila y columna");
                    System.out.println("2. Por placa");
                    System.out.print("Opcion: ");
                    menu = scanner.nextInt();
                    switch (menu) {
                        // Elimina mediante las filas y columnas
                        case 1:
                            System.out.print("Ingrese fila donde esta el Vehiculo a eliminar: ");
                            fila = scanner.nextInt();
                            System.out.print("Ingrese fila donde esta el Vehiculo a eliminar: ");
                            columna = scanner.nextInt();
                            matriz.eliminar(fila, columna);
                            matriz.imprimir();
                            break;
                        // Elimina solo mediante la placa
                        case 2:
                            System.out.println("Ingrese placa a eliminar: ");
                            placa = scanner.next();
                            matriz.eliminarxPlaca(placa);
                            matriz.imprimir();
                            break;
                        default:
                            System.out.println("Opcion invalida!");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("\nFinalizando sistema...");
                    return;

                default:
                    System.out.println("\nOpción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }
}
