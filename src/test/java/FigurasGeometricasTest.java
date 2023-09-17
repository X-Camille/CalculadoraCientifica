import org.example.FigurasGeometricas;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FigurasGeometricasTest {
    FigurasGeometricas figurasGeometricas = new FigurasGeometricas();
    int[] valores;
    boolean[] resultadosEsperadoParaValores;
    int datoCuadrado;
    int[] respuestasDatosCuadrado;
    int datoCirculo;
    double[] respuestasDatosCirculo;
    int[] datosCono;
    double[] respuestasDatosCono;

    @BeforeEach
    public void init() {
        valores = new int[]{0, -1, -10000000, 10000000, 5};
        resultadosEsperadoParaValores = new boolean[]{false, false, false, false, true};

        datoCuadrado = 10;
        respuestasDatosCuadrado = new int[]{40, 100};

        datoCirculo = 10;
        respuestasDatosCirculo = new double[]{62.8318530718 ,314.159265359};

        datosCono = new int[]{5, 10};
        respuestasDatosCono = new double[]{254.1601846, 261.799};

    }

    @Test
    public void valorEsValidoTest(){
        boolean resultadoCorrecto = true;
        for(int i=0; i < valores.length; i++){
            if(figurasGeometricas.valorEsValido(valores[i]) != resultadosEsperadoParaValores[i]){
                resultadoCorrecto = false;
            }
        }
        assertTrue(resultadoCorrecto);
    }

    @Test
    public void calcularDatosCuadradoTest(){
        int perimetroCalculado = figurasGeometricas.calcularPerimetroCuadrado(datoCuadrado);
        int areaCalculada = figurasGeometricas.calcularAreaCuadrado(datoCuadrado);

        int perimetroEsperado = respuestasDatosCuadrado[0];
        int areaEsperada = respuestasDatosCuadrado[1];

        boolean perimetroCorrecto = perimetroCalculado == perimetroEsperado;
        boolean areaCorrecta = areaCalculada == areaEsperada;

        assertTrue(perimetroCorrecto);
        assertTrue(areaCorrecta);
    }

    @Test
    public void calcularDatosCirculoTest(){
        double perimetroCalculado = figurasGeometricas.calcularPerimetroCirculo(datoCirculo);
        double areaCalculada = figurasGeometricas.calcularAreaCirculo(datoCirculo);

        double perimetroEsperado = respuestasDatosCirculo[0];
        double areaEsperada = respuestasDatosCirculo[1];

        boolean perimetroCorrecto = Math.round(perimetroCalculado) == Math.round(perimetroEsperado);
        boolean areaCorrecta = Math.round(areaCalculada) == Math.round(areaEsperada);

        assertTrue(perimetroCorrecto);
        assertTrue(areaCorrecta);
    }

    @Test
    public void calcularDatosConoTest(){
        double areaCalculada = figurasGeometricas.calcularAreaCono(datosCono[0], datosCono[1]);
        double volumenCalculado = figurasGeometricas.calcularVolumenCono(datosCono[0], datosCono[1]);

        double areaEsperada = respuestasDatosCono[0];
        double volumenEsperado = respuestasDatosCono[1];

        boolean areaCorrecta = Math.round(areaCalculada) == Math.round(areaEsperada);
        boolean volumenCorrecto = Math.round(volumenCalculado) == Math.round(volumenEsperado);

        assertTrue(areaCorrecta);
        assertTrue(volumenCorrecto);
    }
}
