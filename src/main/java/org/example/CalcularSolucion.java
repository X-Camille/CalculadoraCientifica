package org.example;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.exception.*;

import java.util.Scanner;

public class CalcularSolucion {

    public static void main(String[] args) {
        System.out.println("Melo");
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
    private static boolean verificarNumero(String numero){
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

    }

}
