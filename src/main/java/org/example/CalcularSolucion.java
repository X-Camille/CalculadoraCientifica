package org.example;

import org.apache.commons.math3.linear.*;

import java.util.Scanner;

public class CalcularSolucion {

    public static void main(String[] args) {
        System.out.println("Melo");
        resolverSistema();
    }

    private static double[] ingresarEcuacion(){
        double[] coeficientes = new double[3];
        System.out.println("Ax + By = C");
        System.out.println("Ingrese su A:");
        coeficientes[0]=obtenerNumero();
        System.out.println("Ingrese su B:");
        coeficientes[1]=obtenerNumero();
        System.out.println("Ingrese su C:");
        coeficientes[2]=obtenerNumero();
        return coeficientes;
    }

    private static String scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static boolean verificarNumero(String numero){
        try {
            Double.parseDouble(numero);
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Error, formato de número no válido.");
            return true;
        }
    }
    private static double obtenerNumero(){
        boolean on = true;
        String numero = "a";
        while (on){
            numero = scanner();
            on=verificarNumero(numero);
        }
        return Double.parseDouble(numero);
    }

    public static void resolverSistema(){
        System.out.println("Ingrese su primera ecuación:");
        double[] ecuacion1=ingresarEcuacion();
        System.out.println("Ingrese su segunda ecuación:");
        double[] ecuacion2=ingresarEcuacion();

        double[][] coeficientes = {
                {ecuacion1[0], ecuacion1[1]},
                {ecuacion2[0], ecuacion2[1]}
        };
        double[] terminosIndependientes = {ecuacion1[2], ecuacion2[2]};

        tieneSolucionUnica(coeficientes,terminosIndependientes);
    }

    public static boolean tieneSolucionUnica(double [][] coeficientes, double[] terminosIndependientes){
        RealMatrix coefficientsMatrix = new Array2DRowRealMatrix(coeficientes, false);
        DecompositionSolver solver = new LUDecomposition(coefficientsMatrix).getSolver();
        RealVector constantsVector = new ArrayRealVector(terminosIndependientes, false);
        try {
            RealVector solucion = solver.solve(constantsVector);
            System.out.println("Solución:");
            System.out.println(solucion);
            return true;
        } catch (SingularMatrixException e) {
            System.err.println("El sistema de ecuaciones no tiene solución única.");
            return false;
        }
    }

}
