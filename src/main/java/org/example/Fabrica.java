package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fabrica {
    private ArrayList<Durazno> duraznos;
    private final Inventario inventario;
    private Map<String, Double> preciosAcumulados; // Almacena el precio acumulado por tipo de producto

    private static int productoIdCounter = 0; // Variable estatica para generar IDs unicos

    // Constructor
    public Fabrica() {
        duraznos = new ArrayList<>();
        this.inventario = new Inventario();
        this.preciosAcumulados = new HashMap<>();

        // Inicializar precios en 0 para cada tipo de producto
        preciosAcumulados.put("jugo", 0.0);
        preciosAcumulados.put("mermelada", 0.0);
        preciosAcumulados.put("conserva", 0.0);
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

        precioTotal *= margenGanancia;

        // Asegurar que el precio se acumule correctamente
        preciosAcumulados.put(tipoProducto, preciosAcumulados.get(tipoProducto) + precioTotal);

        Producto producto = new Producto(generarIdUnico(), pesoTotal, precioTotal, tipoProducto);
        inventario.agregarProducto(producto);


        //eliminar los duraznos hechos
        duraznos.subList(0, cantidadNecesaria).clear();
        System.out.println("Precio acumulado actualizado para " + tipoProducto + ": $" + preciosAcumulados.get(tipoProducto));

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
            JOptionPane.showMessageDialog(null,
                    "No hay suficientes duraznos para procesar " + tipoProducto +
                            ".\nCantidad actual: " + duraznos.size() + ", se necesitan: " + cantidadNecesaria,
                    "Error de produccion", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mostrar inventario
    public int getCantidadProductos(String tipoProducto) {
        return inventario.contarProductosPorTipo(tipoProducto);
    }

    public int getCantidadDuraznos() {
        return duraznos.size();
    }

    public double getPrecioAcumulado(String tipoProducto) {
        return preciosAcumulados.getOrDefault(tipoProducto, 0.0);
    }

}
