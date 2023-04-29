package clases;

public class Nodo {
    // Atributos
    private Nodo arriba;
    private Nodo abajo;
    private Nodo izquierda;
    private Nodo derecha;
    private Vehiculo vehiculo;

    /**
     * Constructor vacio
     */
    public Nodo() {
        this(null, null, null, null, null);
    }

    /**
     * Constructor Nodo
     * @param vehiculo Objeto vehiculo
     * @param arriba Apuntador arriba
     * @param abajo Apuntador abajo
     * @param izquierda Apuntador izquierda
     * @param derecha Apuntador derecha
     */
    public Nodo(Vehiculo vehiculo, Nodo arriba, Nodo abajo, Nodo izquierda, Nodo derecha) {
        this.vehiculo = vehiculo;
        this.arriba = arriba;
        this.abajo = abajo;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    // Getters y Setters
    public Nodo getArriba() {
        return arriba;
    }

    public void setArriba(Nodo arriba) {
        this.arriba = arriba;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
