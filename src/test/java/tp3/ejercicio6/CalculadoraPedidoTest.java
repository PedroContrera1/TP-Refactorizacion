package tp3.ejercicio6;

import oop2.tp3.ejercicio6.CalculadoraPedido;
import oop2.tp3.ejercicio6.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraPedidoTest {
    @Test
    public void calcularCuandoElClienteEsVip() {
        CalculadoraPedido calculadoraPedido=new CalculadoraPedido();
        Pedido pedido=new Pedido(500,true,true);
        double total=calculadoraPedido.calcularTotalConDescuentoVip(pedido);
        assertEquals(425,total);
    }

    @Test
    public void calcularCuandoEsEnvioPrioritario() {
        CalculadoraPedido calculadoraPedido=new CalculadoraPedido();
        Pedido pedido=new Pedido(500,true,true);
        double total=calculadoraPedido.calcularTotalConDescuentoPrioritario(pedido);
        assertEquals(475,total);
    }

}
