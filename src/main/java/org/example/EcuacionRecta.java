package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EcuacionRecta {

    public double[] ingresarPunto1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el punto 1");

        double x1 = ingresarDoubleConManejoDeExcepciones("x1: ");
        double y1 = ingresarDoubleConManejoDeExcepciones("y1: ");

        return new double[]{x1, y1};
    }

    public double[] ingresarPunto2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el punto 2");

        double x2 = ingresarDoubleConManejoDeExcepciones("x2: ");
        double y2 = ingresarDoubleConManejoDeExcepciones("y2: ");

        return new double[]{x2, y2};
    }

    public double calcularPendiente(double[] punto1, double[] punto2) {
        return (punto2[1] - punto1[1]) / (punto2[0] - punto1[0]);
    }

    public boolean denominadorEsValido(double[] punto1, double[] punto2){
        return punto2[0] != punto1[0];
    }

    public double calcularCoeficienteDePosicion(double[] punto1, double pendiente) {
        return punto1[1] - pendiente * punto1[0];
    }

    public void encontrarEcuacionDeLaRecta() {
        double[] punto1 = ingresarPunto1();
        double[] punto2 = ingresarPunto2();
        double pendiente = calcularPendiente(punto1, punto2);
        double coeficientePosicion = calcularCoeficienteDePosicion(punto1, pendiente);
        if(denominadorEsValido(punto1, punto2)){
            System.out.println("La ecuación de la recta es y = " + pendiente + "x + " + coeficientePosicion);
        } else {
            System.out.println("Ecuación de la recta no válida. El denominador no puede ser 0.");
        }

    }

    private double ingresarDoubleConManejoDeExcepciones(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Por favor, ingrese un número: ");
                scanner.next();
            }
        }
    }
}
