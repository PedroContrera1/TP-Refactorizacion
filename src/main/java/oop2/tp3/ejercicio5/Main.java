package oop2.tp3.ejercicio5;

import java.util.List;

public class Main {

    public void main(String[] args) {
        var eventos = cargarEventos();
        var factura = crearFactura();

        System.out.println(new Calculador().reporte(factura));
    }

    private static List<Evento> cargarEventos() {
        return List.of(new Evento("Escuela de Rock", "Comedia"),
                new Evento("Hamlet", "Drama"),
                new Evento("El Avion", "Dram"),
                new Evento("Cantando en la playa", "Comedia"),
                new Evento("El Perfume", "Drama")
        );
    }

    private  Factura crearFactura() {
        return new Factura("c1", List.of(new Comedia("Escuela de Rock", 158),
                new Drama("Hamlet", 103),
                new Drama("El Perfume", 8)));
    }
}
