package org.example;
//subirlo a github
//Hacer el main
//diseñar una interfaz

public class Main {
    public static void main(String[] args) {

        Fabrica fabrica= new Fabrica();//se crea un inventario en el constructor de Fabrica
        //ingresan duraznos
        Durazno durazno1 = new Durazno(5.0,"grande","baja");
        Durazno durazno2 = new Durazno(5.0,"mediano","baja");
        Durazno durazno3 = new Durazno(5.0,"pequeño","baja");
        Durazno durazno4 = new Durazno(5.0,"mediano","alta");
        Durazno durazno5 = new Durazno(5.0,"grande","baja");
        Durazno durazno6 = new Durazno(5.0,"mediano","media");

        //se guardan los duraznos en la fabrica
        fabrica.ingresarDurazno(durazno1);
        fabrica.ingresarDurazno(durazno2);
        fabrica.ingresarDurazno(durazno3);
        fabrica.ingresarDurazno(durazno4);
        fabrica.ingresarDurazno(durazno5);
        fabrica.ingresarDurazno(durazno6);

        //se generan los productos
        fabrica.procesarDuraznos("mermelada");
        fabrica.procesarDuraznos("jugo");

        //se muestra el inventario
        fabrica.mostrarInventario();
    }
}