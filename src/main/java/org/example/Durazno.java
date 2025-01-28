package org.example;

public class Durazno {
    private int id;
    private double peso;
    private String tamano;
    private String calidad;
    // Variable estatica para generar IDs únicos
    private static int contadorId = 0;

    //constructor
    public Durazno(double peso, String tamano, String calidad) {
        this.id = generarIdUnico();
        this.peso = peso;
        this.tamano = tamano;
        this.calidad = calidad;
    }
    //metodo paara automatizar los id
    private static int generarIdUnico() {
        return ++contadorId;
    }

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

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    //metodos
    public double calcularCosto() {
        double costoBase = 2.0;
        double multiplicadorTamano = 0.0;
        double ajusteCalidad = 0.0;

        // Determinando multiplicador según el tamaño
        switch (tamano) {
            case "pequeño":
                multiplicadorTamano = 0.5;
                break;
            case "mediano":
                multiplicadorTamano = 1.0;
                break;
            case "grande":
                multiplicadorTamano = 1.5;
                break;
            default:
                System.out.println("Tamaño no válido.");
                return 0.0;
        }

        // Ajuste segun la calidad
        switch (calidad) {
            case "alta":
                ajusteCalidad = 1.5;
                break;
            case "media":
                ajusteCalidad = 1.0;
                break;
            case "baja":
                ajusteCalidad = 0.5;
                break;
            default:
                System.out.println("Calidad no válida.");
                return 0.0;
        }

        // Calculando el costo total
        return (costoBase * multiplicadorTamano + ajusteCalidad) * peso;
    }

    public void mostrarDetalles() {
        System.out.println("ID: " + id);
        System.out.println("Peso: " + peso + " gramos");
        System.out.println("Tamaño: " + tamano);
        System.out.println("Calidad: " + calidad);
        System.out.println("Costo: $" + calcularCosto());
    }
}
