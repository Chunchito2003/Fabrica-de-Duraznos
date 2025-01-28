package org.example;

import java.util.ArrayList;

public class Inventario {
    ArrayList<Producto> productos;

    //constructor
    public Inventario() {
        productos = new ArrayList<>();
    }

    //añadir
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    //listar
    public void ListarProductos() {
        int contadorMermelada = 0;
        int contadorJugo = 0;
        int contadorConserva = 0;
        //la idea de este metodo es mostrar el total en vez de los productos en si
        for (Producto producto : productos) {
            // Agrupar y contar según el tipo de producto
            if (producto.getTipo().equalsIgnoreCase("mermelada")) {
                contadorMermelada++;
            } else if (producto.getTipo().equalsIgnoreCase("jugo")) {
                contadorJugo++;
            } else if (producto.getTipo().equalsIgnoreCase("conserva")) {
                contadorConserva++;
            }
        }
        System.out.println("Productos por tipo:");
        System.out.println("Mermelada: " + contadorMermelada);
        System.out.println("Jugo: " + contadorJugo);
        System.out.println("Conserva: " + contadorConserva);
    }

    //Busca un producto en el inventario según su ID. Retorna el
    //producto si se encuentra; de lo contrario, retorna null.
    public Producto buscarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

}
