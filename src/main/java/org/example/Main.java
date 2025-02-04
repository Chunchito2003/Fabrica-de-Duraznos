package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Fabrica fabrica= new Fabrica();//se crea un inventario en el constructor de Fabrica

        Interfaz interfaz = new Interfaz(fabrica);// Crear la interfaz y pasarle la fábrica
        // Hacer visible la interfaz
        JFrame frame = new JFrame("Gestión de Duraznos");
        frame.setContentPane(interfaz.getPantalla()); // Usar el JPanel generado
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta el tamaño automáticamente
        frame.setVisible(true);

    }
}