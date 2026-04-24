package tp3.ejercicio5;

import oop2.tp3.ejercicio5.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadorTest {

    @Test
    public void test01() {

        var factura = crearFactura();

        assertEquals("""
                Facturación para c1
                Escuela de Rock: 156400.0. Asientos: 158
                Hamlet: 113000.0. Asientos: 103
                El Perfume: 40000.0. Asientos: 8
                Monto ganado: 309400.0
                Créditos ganados: 232.0
                """, new Calculador().reporte(factura));
    }

    private Factura crearFactura() {
        return new Factura("c1", List.of(new Comedia("Escuela de Rock", 158),
                new Drama("Hamlet", 103),
                new Drama("El Perfume", 8)));
    }
}
