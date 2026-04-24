package tp3.ejercicio3;

import oop2.tp3.ejercicio3.Gasto;
import oop2.tp3.ejercicio3.ReporteDeGastos;
import oop2.tp3.ejercicio3.TipoDeGasto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteDeGastosTest {

    @Test
    void generaReporteConUnDesayunoSinExceso() {
        ReporteDeGastos reporte = new ReporteDeGastos(LocalDate.of(2026, 4, 23));

        String resultado = reporte.imprimir(List.of(
                new Gasto(TipoDeGasto.DESAYUNO, 1000)
        ));

        String esperado = "Expenses 2026-04-23" + System.lineSeparator()
                + "Desayuno\t1000\t " + System.lineSeparator()
                + "Gastos de comida: 1000" + System.lineSeparator()
                + "Total de gastos: 1000" + System.lineSeparator();

        assertEquals(esperado, resultado);
    }

    @Test
    void marcaConXLaCenaMayorA5000() {
        ReporteDeGastos reporte = new ReporteDeGastos(LocalDate.of(2026, 4, 23));

        String resultado = reporte.imprimir(List.of(
                new Gasto(TipoDeGasto.CENA, 6000)
        ));

        String esperado = "Expenses 2026-04-23" + System.lineSeparator()
                + "Cena\t6000\tX" + System.lineSeparator()
                + "Gastos de comida: 6000" + System.lineSeparator()
                + "Total de gastos: 6000" + System.lineSeparator();

        assertEquals(esperado, resultado);
    }

    @Test
    void marcaConXElDesayunoMayorA1000() {
        ReporteDeGastos reporte = new ReporteDeGastos(LocalDate.of(2026, 4, 23));

        String resultado = reporte.imprimir(List.of(
                new Gasto(TipoDeGasto.DESAYUNO, 1200)
        ));

        String esperado = "Expenses 2026-04-23" + System.lineSeparator()
                + "Desayuno\t1200\tX" + System.lineSeparator()
                + "Gastos de comida: 1200" + System.lineSeparator()
                + "Total de gastos: 1200" + System.lineSeparator();

        assertEquals(esperado, resultado);
    }

    @Test
    void noCuentaElAlquilerDeAutoComoGastoDeComida() {
        ReporteDeGastos reporte = new ReporteDeGastos(LocalDate.of(2026, 4, 23));

        String resultado = reporte.imprimir(List.of(
                new Gasto(TipoDeGasto.ALQUILER_AUTO, 8000)
        ));

        String esperado = "Expenses 2026-04-23" + System.lineSeparator()
                + "Alquiler de Autos\t8000\t " + System.lineSeparator()
                + "Gastos de comida: 0" + System.lineSeparator()
                + "Total de gastos: 8000" + System.lineSeparator();

        assertEquals(esperado, resultado);
    }

    @Test
    void calculaTotalesConVariosGastos() {
        ReporteDeGastos reporte = new ReporteDeGastos(LocalDate.of(2026, 4, 23));

        String resultado = reporte.imprimir(List.of(
                new Gasto(TipoDeGasto.DESAYUNO, 1200),
                new Gasto(TipoDeGasto.CENA, 6000),
                new Gasto(TipoDeGasto.ALQUILER_AUTO, 8000)
        ));

        String esperado = "Expenses 2026-04-23" + System.lineSeparator()
                + "Desayuno\t1200\tX" + System.lineSeparator()
                + "Cena\t6000\tX" + System.lineSeparator()
                + "Alquiler de Autos\t8000\t " + System.lineSeparator()
                + "Gastos de comida: 7200" + System.lineSeparator()
                + "Total de gastos: 15200" + System.lineSeparator();

        assertEquals(esperado, resultado);
    }
}
