package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {
    private JPanel pantalla;
    private JComboBox<String> tamanoBox1;
    private JComboBox<String> calidadBox2;
    private JTextField pesoTesxtField;
    private JList<String> listProducto;
    private JButton agregarButton;
    private JButton jugoButton;
    private JButton mermeladaButton;
    private JButton conservaButton;
    private JList listPrecio;

    private Fabrica fabrica; // Referencia a la fabrica
    private DefaultListModel<String> listModel; // Modelo para la lista

    public Interfaz(Fabrica fabrica) {
        this.fabrica = fabrica;

        listModel = new DefaultListModel<>();
        listProducto.setModel(listModel);

        // Configurar los botones
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDurazno();
                actualizarLista(); // Actualizar la lista después de agregar un durazno
            }
        });

        jugoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fabrica.procesarDuraznos("jugo");
                actualizarLista();
            }
        });

        mermeladaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fabrica.procesarDuraznos("mermelada");
                actualizarLista();
            }
        });

        conservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fabrica.procesarDuraznos("conserva");
                actualizarLista();
            }
        });

        actualizarLista(); // Para que la lista muestre el estado inicial
    }


    private void agregarDurazno() {
        try {
            double peso = Double.parseDouble(pesoTesxtField.getText());
            String tamano = (String) tamanoBox1.getSelectedItem();
            String calidad = (String) calidadBox2.getSelectedItem();

            Durazno nuevoDurazno = new Durazno(peso, tamano, calidad);
            fabrica.ingresarDurazno(nuevoDurazno);


            // Limpiar los campos
            pesoTesxtField.setText("");
            tamanoBox1.setSelectedIndex(0);
            calidadBox2.setSelectedIndex(0);

            actualizarLista(); // Refrescar la lista
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un peso válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void actualizarLista() {
        listModel.clear();
        listModel.addElement("Duraznos: " + fabrica.getCantidadDuraznos());
        listModel.addElement("Jugo: " + fabrica.getCantidadProductos("jugo"));
        listModel.addElement("Mermelada: " + fabrica.getCantidadProductos("mermelada"));
        listModel.addElement("Conserva: " + fabrica.getCantidadProductos("conserva"));

        // Actualizar la lista de precios por tipo de producto
        DefaultListModel<String> precioModel = new DefaultListModel<>();
        precioModel.addElement("Precio Jugo: $" + fabrica.getPrecioAcumulado("jugo"));
        precioModel.addElement("Precio Mermelada: $" + fabrica.getPrecioAcumulado("mermelada"));
        precioModel.addElement("Precio Conserva: $" + fabrica.getPrecioAcumulado("conserva"));

        // Asignar el modelo a listPrecio
        listPrecio.setModel(precioModel);
    }



    public JPanel getPantalla() {
        return pantalla;
    }
}
