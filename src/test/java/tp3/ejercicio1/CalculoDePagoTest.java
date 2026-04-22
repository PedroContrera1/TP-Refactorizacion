package tp3.ejercicio1;

import oop2.tp3.ejercicio1.Alquiler;
import oop2.tp3.ejercicio1.Cliente;
import oop2.tp3.ejercicio1.CopiaLibro;
import oop2.tp3.ejercicio1.Libro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoDePagoTest {

    @Test
    void calculaPagoDeLibroRegularPorDosDias() {
        Cliente cliente = new Cliente("Juan");
        Libro libro = new Libro("El principito", Libro.REGULARES);
        CopiaLibro copia = new CopiaLibro(libro);

        cliente.alquilar(new Alquiler(copia, 2));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(2.0, (double) resultado[0]);
        assertEquals(1, (int) resultado[1]);
    }

    @Test
    void calculaPagoDeLibroRegularPorCincoDias() {
        Cliente cliente = new Cliente("Juan");
        Libro libro = new Libro("1984", Libro.REGULARES);
        CopiaLibro copia = new CopiaLibro(libro);

        cliente.alquilar(new Alquiler(copia, 5));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(6.5, (double) resultado[0]);
        assertEquals(1, (int) resultado[1]);
    }

    @Test
    void calculaPagoDeLibroInfantilPorTresDias() {
        Cliente cliente = new Cliente("Juan");
        Libro libro = new Libro("Caperucita", Libro.INFANTILES);
        CopiaLibro copia = new CopiaLibro(libro);

        cliente.alquilar(new Alquiler(copia, 3));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(1.5, (double) resultado[0]);
        assertEquals(1, (int) resultado[1]);
    }

    @Test
    void calculaPagoDeLibroInfantilPorCincoDias() {
        Cliente cliente = new Cliente("Juan");
        Libro libro = new Libro("Pinocho", Libro.INFANTILES);
        CopiaLibro copia = new CopiaLibro(libro);

        cliente.alquilar(new Alquiler(copia, 5));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(4.5, (double) resultado[0]);
        assertEquals(1, (int) resultado[1]);
    }

    @Test
    void calculaPagoDeNuevoLanzamientoPorUnDia() {
        Cliente cliente = new Cliente("Juan");
        Libro libro = new Libro("Duna", Libro.NUEVO_LANZAMIENTO);
        CopiaLibro copia = new CopiaLibro(libro);

        cliente.alquilar(new Alquiler(copia, 1));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(3.0, (double) resultado[0]);
        assertEquals(1, (int) resultado[1]);
    }

    @Test
    void nuevoLanzamientoPorMasDeUnDiaDaPuntoBonus() {
        Cliente cliente = new Cliente("Juan");
        Libro libro = new Libro("Batman", Libro.NUEVO_LANZAMIENTO);
        CopiaLibro copia = new CopiaLibro(libro);

        cliente.alquilar(new Alquiler(copia, 2));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(6.0, (double) resultado[0]);
        assertEquals(2, (int) resultado[1]);
    }

    @Test
    void calculaPagoYpuntosConVariosAlquileres() {
        Cliente cliente = new Cliente("Juan");

        cliente.alquilar(new Alquiler(
                new CopiaLibro(new Libro("Libro regular", Libro.REGULARES)), 3
        ));
        cliente.alquilar(new Alquiler(
                new CopiaLibro(new Libro("Libro infantil", Libro.INFANTILES)), 4
        ));
        cliente.alquilar(new Alquiler(
                new CopiaLibro(new Libro("Estreno", Libro.NUEVO_LANZAMIENTO)), 2
        ));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(12.5, (double) resultado[0]);
        assertEquals(4, (int) resultado[1]);
    }
}