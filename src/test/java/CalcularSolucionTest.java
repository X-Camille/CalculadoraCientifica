import org.example.CalcularSolucion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcularSolucionTest {

    @Test
    public void verificarNumeroTest() {
        String[] numeros = {"2", "ae", "2.3", "", "2a", "2,1"};
        boolean[] esperado = {false, true, false, true, true, true};
        for (int i = 0; i < 6; i++) {
            Assertions.assertEquals(CalcularSolucion.verificarNumero(numeros[i]),
                    esperado[i]);
        }
    }

    @Test
    public void tieneSolucionUnicaTest() {
        double[][][] coeficientes = {{{0, 0}, {0, 0}}, {{1, 2}, {2, 4}}, {{2, 3}, {4, 7}}};
        double[][] terminosindependientes = {{0, 0}, {3, 6}, {7, 2}};
        boolean[] esperado = {false, false, true};
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(CalcularSolucion.tieneSolucionUnica(coeficientes[i],
                    terminosindependientes[i]), esperado[i]);
        }
    }
}