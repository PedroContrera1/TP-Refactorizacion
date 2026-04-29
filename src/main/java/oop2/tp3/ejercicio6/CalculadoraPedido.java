package oop2.tp3.ejercicio6;
import java.util.function.Supplier;

public class CalculadoraPedido{
    public double calcularTotalConDescuentoVip(Pedido pedido) {
        return ejecutarCalculo (pedido, pedido::clienteVip,0.15);
    }

    public double calcularTotalConDescuentoPrioritario(Pedido pedido) {
        return ejecutarCalculo(pedido, pedido::envioPrioritario,0.05);
    }

    public double ejecutarCalculo(Pedido pedido, Supplier<Boolean> condicion, double porcentaje){
        double descuento = 0;
        if (condicion.get()) {
            descuento = pedido.subtotal() * porcentaje;
        }
        return pedido.subtotal() - descuento;
    }
}

