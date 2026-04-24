package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    private final LocalDate fecha;

    public ReporteDeGastos() {
        this(LocalDate.now());
    }

    public ReporteDeGastos(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String imprimir(List<Gasto> gastos) {
        StringBuilder reporte = new StringBuilder();

        reporte.append("Expenses ")
                .append(fecha)
                .append(System.lineSeparator());

        for (Gasto gasto : gastos) {
            reporte.append(lineaDelGasto(gasto));
        }

        reporte.append("Gastos de comida: ")
                .append(calcularGastosDeComida(gastos))
                .append(System.lineSeparator());

        reporte.append("Total de gastos: ")
                .append(calcularTotal(gastos))
                .append(System.lineSeparator());

        return reporte.toString();
    }

    private String lineaDelGasto(Gasto gasto) {
        return nombreGasto(gasto) + "\t" + gasto.monto + "\t" + marcaExcesoComidas(gasto) + System.lineSeparator();
    }

    private int calcularGastosDeComida(List<Gasto> gastos) {
        int gastosDeComida = 0;

        for (Gasto gasto : gastos) {
            if (esGastoDeComida(gasto)) {
                gastosDeComida += gasto.monto;
            }
        }

        return gastosDeComida;
    }

    private int calcularTotal(List<Gasto> gastos) {
        int total = 0;

        for (Gasto gasto : gastos) {
            total += gasto.monto;
        }

        return total;
    }

    private boolean esGastoDeComida(Gasto gasto) {
        return gasto.tipoGasto == TipoDeGasto.CENA || gasto.tipoGasto == TipoDeGasto.DESAYUNO;
    }

    private String nombreGasto(Gasto gasto) {
        return switch (gasto.tipoGasto) {
            case CENA -> "Cena";
            case DESAYUNO -> "Desayuno";
            case ALQUILER_AUTO -> "Alquiler de Autos";
        };
    }

    private String marcaExcesoComidas(Gasto gasto) {
        if (esCenaConExceso(gasto) || esDesayunoConExceso(gasto)) {
            return "X";
        }

        return " ";
    }

    private boolean esCenaConExceso(Gasto gasto) {
        return gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > 5000;
    }

    private boolean esDesayunoConExceso(Gasto gasto) {
        return gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > 1000;
    }
}