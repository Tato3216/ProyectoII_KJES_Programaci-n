package clases;

import java.util.*;

public class Matriz {
    // Atributos de la Matriz
    private int filas;
    private int columnas;
    private List<List<Nodo>> matriz;

    /**
     * Constructor de Clase
     * 
     * @param filas    Entero de tipo filas
     * @param columnas Entero de tipo columnas
     */
    public Matriz(int filas, int columnas) {
        if (filas != columnas) {
            System.out.println("No se puede crear una matriz no simétrica.");
            return;
        }
        this.filas = filas;
        this.columnas = columnas;
        matriz = new LinkedList<>();
        for (int i = 0; i < filas; i++) {
            List<Nodo> filaMatriz;
            filaMatriz = new LinkedList<>();
            for (int j = 0; j < columnas; j++) {
                filaMatriz.add(new Nodo(null, null, null, null, null));
            }
            matriz.add(filaMatriz);
        }
    }

    /**
     * Funcion insertar Vehiculo en posicion por fila y columna asignada
     * 
     * @param fila     Entero que representara la fila
     * @param columna  Entero que representara la columna
     * @param vehiculo Es un objeto Vehiculo a almacenar en Nodo
     */
    public void insertar(int fila, int columna, Vehiculo vehiculo) {
        if (!validarPosicion(fila, columna)) {
            System.out.println("Posición inválida!");
            return;
        }
        // Enlazaz el vehiculo donde indica fila y columna
        Nodo nuevoNodo = matriz.get(fila).get(columna);
        nuevoNodo.setVehiculo(vehiculo);

        // Empezamos a unir los nodos
        if (fila > 0) {
            Nodo nodoArriba = matriz.get(fila - 1).get(columna);
            nuevoNodo.setArriba(nodoArriba);
            nodoArriba.setAbajo(nuevoNodo);
        }
        if (fila < filas - 1) {
            Nodo nodoAbajo = matriz.get(fila + 1).get(columna);
            nuevoNodo.setAbajo(nodoAbajo);
            nodoAbajo.setArriba(nuevoNodo);
        }
        if (columna > 0) {
            Nodo nodoIzquierda = matriz.get(fila).get(columna - 1);
            nuevoNodo.setIzquierda(nodoIzquierda);
            nodoIzquierda.setDerecha(nuevoNodo);
        }
        if (columna < columnas - 1) {
            Nodo nodoDerecha = matriz.get(fila).get(columna + 1);
            nuevoNodo.setDerecha(nodoDerecha);
            nodoDerecha.setIzquierda(nuevoNodo);
        }
    }

    /**
     * Funcion que valida si fila o columna estan dentro de los limites de la matriz
     * 
     * @param fila    Es un entero fila
     * @param columna Es un entero columna
     * @return Nos retorna un boolean si esta dentro o no
     */
    public boolean validarPosicion(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return false;
        }
        return true;
    }

    /**
     * Funcion busqueda solo por "Placa"
     * 
     * @param placa Es un String que se usara para validar y luego eliminar
     * @return Nos retorna un tipo Nodo que es el objeto en cuestion.
     */
    public Nodo buscarxPlaca(String placa) {
        for (List<Nodo> fila : matriz) {
            for (Nodo nodo : fila) {
                Vehiculo vehiculo;
                vehiculo = nodo.getVehiculo();
                if (vehiculo != null && vehiculo.getPlaca().equals(placa)) {
                    return nodo;
                }
            }
        }
        return null;
    }

    /**
     * Funcion que simplemente recorre nuestra matriz ortogonal
     * Siendo asi que en los espacios vacios mostrar null
     * A forma grafica para ver como se reparten los espacios
     */
    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Vehiculo vehiculo;
                vehiculo = matriz.get(i).get(j).getVehiculo();
                if (vehiculo != null) {
                    System.out.print(vehiculo.toString() + " ");
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Funcion que elimina mediante "fila y columna
     * @param fila    Es la posicion i o fila de la LinkedList
     * @param columna Es la posicion j o columna de la LinkedList
     */
    public void eliminar(int fila, int columna) {
        if (!validarPosicion(fila, columna)) {
            System.out.println("Posición inválida!");
            return;
        }
        Nodo tmp;
        tmp = matriz.get(fila).get(columna);
        Nodo arriba = tmp.getArriba();
        Nodo abajo = tmp.getAbajo();
        Nodo izquierda = tmp.getIzquierda();
        Nodo derecha = tmp.getDerecha();
        // Enlazamos de nuevo los nodos apartir
        if (arriba != null) {
            arriba.setAbajo(abajo);
        }
        if (abajo != null) {
            abajo.setArriba(arriba);
        }
        if (izquierda != null) {
            izquierda.setDerecha(derecha);
        }
        if (derecha != null) {
            derecha.setIzquierda(izquierda);
        }

        // Borramos el nodo
        tmp.setVehiculo(null);

        System.out
                .println("El vehiculo de localizado en: (" + fila + " ," + columna + " ) ha sido eliminado con exito!");
    }

    /**
     * Funcion que elimina mediante una "busqueda de placa"
     * 
     * @param placa String que es la placa del vehiculo a buscar para su eliminacion
     */
    public void eliminarxPlaca(String placa) {
        Nodo tmp = buscarxPlaca(placa);
        if (tmp == null) {
            System.out.println("No existe");
            return;
        }
        if (tmp.getArriba() != null) {
            tmp.getArriba().setAbajo(tmp.getAbajo());
        }
        if (tmp.getAbajo() != null) {
            tmp.getAbajo().setArriba(tmp.getArriba());
        }
        if (tmp.getIzquierda() != null) {
            tmp.getIzquierda().setDerecha(tmp.getDerecha());
        }
        if (tmp.getDerecha() != null) {
            tmp.getDerecha().setIzquierda(tmp.getIzquierda());
        }
        // Borrando de una
        tmp.setVehiculo(null);

        System.out.println("El vehiculo: " + placa + " ha sido eliminado con exito!");
    }

    /**
     * Funcion que hace una busqueda doble
     * es decir que recibe 2 parametros.
     * 
     * @param modelo      String del modelo del vehiculo
     * @param propietario String del propietario del vehiculo
     */
    public void busquedaDoble(String modelo, String propietario) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Vehiculo vehiculo;
                vehiculo = matriz.get(i).get(j).getVehiculo();
                if (vehiculo != null && vehiculo.getModelo().equals(modelo)
                        && vehiculo.getPropietario().equals(propietario)) {
                    System.out.println("Vehiculo localizado en la posicion: (" + i + " , " + j + " )");
                    System.out.println(vehiculo.toString());
                }
            }
        }
    }
}
