package org.example;

public class Producto {
    private int id;
    private String Tipo; //como "mermelada", "jugo" o "conserva"
    private double peso;//: Peso total del producto en gramos, calculado a partir de los duraznos procesados.
    private double precio;

    //constructor
    public Producto(int id, double peso, double precio, String tipo) {
        this.id = id;
        this.peso = peso;
        this.precio = precio;
        Tipo = tipo;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public void mostrarDetaelles(){
        System.out.println("ID: " + id);
        System.out.println("Peso: " + peso + " gramos");
        System.out.println("Tipo: "+ Tipo);
        System.out.println("Precio: "+precio);
    }
}
