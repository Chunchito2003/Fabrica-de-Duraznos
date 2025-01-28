package org.example;

import java.util.ArrayList;

public class Fabrica {
    private ArrayList<Durazno> duraznos;
    private final Inventario inventario;
    private static int productoIdCounter = 0; // Variable estatica para generar IDs unicos

    // Constructor
    public Fabrica() {
        duraznos = new ArrayList<>();
        this.inventario = new Inventario();
    }

    // Metodo para automatizar los IDs
    private static int generarIdUnico() {
        return ++productoIdCounter;
    }

    // Ingresar duraznos
    public void ingresarDurazno(Durazno durazno) {
        duraznos.add(durazno);
    }

    // Metodo auxiliar para procesar duraznos y generar un producto
    private void procesarYGenerarProducto(String tipoProducto, double margenGanancia, int cantidadNecesaria) {
        double pesoTotal = 0;
        double precioTotal = 0;

        // Calcular peso y costo total de los duraznos necesarios
        for (int i = 0; i < cantidadNecesaria; i++) {
            Durazno durazno = duraznos.get(i);
            pesoTotal += durazno.getPeso();
            precioTotal += durazno.calcularCosto();
        }

        precioTotal *= margenGanancia; // Aplicar margen de ganancia

        // Crear el nuevo producto y agregarlo al inventario
        Producto producto = new Producto(generarIdUnico(), pesoTotal, precioTotal, tipoProducto);
        inventario.agregarProducto(producto);

        // Eliminar los duraznos utilizados
        if (cantidadNecesaria > 0 && cantidadNecesaria <= duraznos.size()) {
            duraznos.subList(0, cantidadNecesaria).clear();
        } else {
            System.out.println("Cantidad necesaria invalida o insuficientes duraznos.");
        }
    }

    // Procesar duraznos según tipo de producto
    public void procesarDuraznos(String tipoProducto) {
        int cantidadNecesaria;
        double margenGanancia;

        switch (tipoProducto) {
            case "jugo":
                cantidadNecesaria = 5;
                margenGanancia = 1.8;
                break;
            case "conserva":
                cantidadNecesaria = 8;
                margenGanancia = 1.5;
                break;
            case "mermelada":
                cantidadNecesaria = 9;
                margenGanancia = 1.3;
                break;
            default:
                System.out.println("Tipo de producto no valido");
                return;
        }

        // Verificar si hay suficiente cantidad de duraznos para generar el producto
        if (duraznos.size() >= cantidadNecesaria) {
            procesarYGenerarProducto(tipoProducto, margenGanancia, cantidadNecesaria);
        } else {
            System.out.println("No hay suficientes duraznos para procesar " + tipoProducto +
                    ". Cantidad actual: " + duraznos.size() + ", se necesitan: " + cantidadNecesaria);
        }
    }

    // Mostrar inventario
    public void mostrarInventario() {
        inventario.ListarProductos();
    }
}
