import org.example.EcuacionRecta;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EcuacionRectaTest {
    EcuacionRecta ecuacionRecta = new EcuacionRecta();
    double[] ejemploPunto1;
    double[] ejemploPunto2;

    @BeforeEach
    public void init(){
        ejemploPunto1 = new double[]{10, 5};
        ejemploPunto2 = new double[]{5, 7};
    }

    @Test
    public void calcularPendienteTest(){
        double pendienteEsperada = -0.4;
        double pendienteCalculada = ecuacionRecta.calcularPendiente(ejemploPunto1, ejemploPunto2);
        assertEquals(pendienteEsperada, pendienteCalculada);
    }

    @Test
    public void calcularCoeficienteDePosicionTest(){
        double coeficienteEsperado = 9;
        double pendienteCalculada = ecuacionRecta.calcularPendiente(ejemploPunto1, ejemploPunto2);
        double coeficienteCalculado = ecuacionRecta.calcularCoeficienteDePosicion(ejemploPunto1, pendienteCalculada);
        assertEquals(coeficienteEsperado, coeficienteCalculado);
    }
}
