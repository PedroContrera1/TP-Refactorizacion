package tp3.ejercicio2;


import oop2.tp3.ejercicio2.LectorCSV;
import oop2.tp3.ejercicio2.Recaudacion;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecaudacionTest {

    @Test
    public void testFiltraPorNombreDeEmpresa() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");
        var r1=new Recaudacion(new LectorCSV("src/main/resources/data.csv"));
        assertEquals(7, r1.where(options).size());
    }

    @Test
    public void testFiltraPorCiudad() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("city", "Tempe");
        var r1=new Recaudacion(new LectorCSV("src/main/resources/data.csv"));
        assertEquals(3, r1.where(options).size());
    }

    @Test
    public void testFiltraPorEstado() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("state", "CA");
        var r1=new Recaudacion(new LectorCSV("src/main/resources/data.csv"));
        assertEquals(873, r1.where(options).size());
    }

    @Test
    public void testFiltraPorRonda() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");
        var r1=new Recaudacion(new LectorCSV("src/main/resources/data.csv"));
        assertEquals(582, r1.where(options).size());
    }

    @Test
    public void testFiltraPorMultiplesOpciones() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");
        options.put("company_name", "Facebook");
        var r1=new Recaudacion(new LectorCSV("src/main/resources/data.csv"));
        assertEquals(1, r1.where(options).size());
    }

    @Test
    public void testDevuelveListaVaciaCuandoNoExiste() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "NotFacebook");
        var r1=new Recaudacion(new LectorCSV("src/main/resources/data.csv"));
        assertEquals(0, r1.where(options).size());
    }

    @Test
    public void testDevuelveLasClavesCorrectas() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");
        var r1=new Recaudacion(new LectorCSV("src/main/resources/data.csv"));
        Map<String, String> row = r1.where(options).getFirst();

        assertEquals("facebook", row.get("permalink"));
        assertEquals("Facebook", row.get("company_name"));
        assertEquals("450", row.get("number_employees"));
        assertEquals("web", row.get("category"));
        assertEquals("Palo Alto", row.get("city"));
        assertEquals("CA", row.get("state"));
        assertEquals("1-Sep-04", row.get("funded_date"));
        assertEquals("500000", row.get("raised_amount"));
        assertEquals("angel", row.get("round"));

    }
}
