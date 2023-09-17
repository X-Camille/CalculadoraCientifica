import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraCientificaTest {

    @Test
    public void testEcuCuadraticaConSolucionesReales() {
        double[] soluciones = CalculadoraCientifica.ecuCuadratica(1, -3, 2);
        assertArrayEquals(new double[]{2.0, 1.0}, soluciones, 0.001);
    }

    @Test
    public void testEcuCuadraticaConSolucionImaginaria() {
        try {
            CalculadoraCientifica.ecuCuadratica(1, 2, 5);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Solución imaginaria", e.getMessage());
        }
    }



    @Test
    public void testEcuCuadraticaNoEsCuadratica() {
        try {
            CalculadoraCientifica.ecuCuadratica(0, 0, 5);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No es una ecuación cuadrática", e.getMessage());
        }
    }//
}
