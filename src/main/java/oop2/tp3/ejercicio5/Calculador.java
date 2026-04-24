package oop2.tp3.ejercicio5;


public class Calculador {

    public static final String LABEL_MONTO_GANADO = "Monto ganado: ";
    public static final String LABEL_CREDITOS_GANADOS = "Créditos ganados: ";
    public static final String LABEL_FACTURACION = "Facturación para ";

    public String reporte(Factura factura) {
        float totalAmount = 0;
        float creditos = 0;
        var result = LABEL_FACTURACION + factura.nombreCliente() + "\n"; //Me fallaba el test usando lineseparator

        var actuaciones = factura.actuaciones();

        for (var actuacion : actuaciones) {
            float monto = actuacion.calcularMonto();
            creditos += actuacion.calcularCreditos();

            result += actuacion.getNombreEvento() + ": " + monto +
                    ". Asientos: " + actuacion.getNumeroEspectadores() + "\n";

            totalAmount += monto;
        }

        result += LABEL_MONTO_GANADO + totalAmount + "\n";
        result += LABEL_CREDITOS_GANADOS + creditos + "\n";

        return result;
    }
}
