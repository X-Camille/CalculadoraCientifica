package org.example;
import java.util.Scanner;
public class operaciones_aritmeticas {

    // atributos
    private static double num1;
    private static double num2;

    // método main
    public static void main(String[] args) {
        num1 = validarNum(num1,"Ingrese el primer numero: ");
        num2 = validarNum(num2,"Ingrese el segundo número: ");
        double resultado;
        resultado = dividir(num1,num2);


    }

    // métodos aritmeticos
    public static double sumar(double a, double b){
        double suma = a+b;
        return suma;
    }
    public static double restar(double a, double b){
        double resta = a-b;
        return resta;
    }
    public static double multiplicar(double a, double b){
        double producto = a*b;
        return producto;
    }
    public static double dividir(double a, double b){
        // b distinto de cero
        validarNumDivision(b);
        double division = a/b;
        return division;
    }

    // método de validación de la división
    public static void validarNumDivision(double valor2) {
        boolean NumValido = false;
        do{
            try {
                //valor2 = ingresar().nextDouble();
                if(valor2 != 0){
                    NumValido = true;
                }
            }catch (Exception e){
                System.err.println("Error! El número no es válido, ingrese nuevamente");
            }
        }while(!NumValido);
        //return valor1,valor2;
    }

    // método potencia
    public static double potencia(double a, double b){
        // a distinto de b
        validarNumPotencia(a,b);
        double potencia = Math.pow(a,b);
        return potencia;
    }
    // método de validación de la potencia
    public static void validarNumPotencia(double valor1,double valor2) {
        boolean NumValido = false;
        do{
            try {
                if((valor1==0)&&(valor2!=0)){
                    NumValido = true;
                }else if((valor1!=0)&&(valor2==0)){
                    NumValido = true;
                }
            }catch (Exception e){
                System.err.println("Error! Si uno de los números es cero,el otro debe ser distinto de cero. Ingrese nuevamente");
            }
        }while(!NumValido);

    }
    // método porcentaje
    public static double porcentaje(double a, double b){
        // a, b no deben ser negativos
        // se puede obtener el o% de un número
        return a*(b/100);
    }

    // método de validaciones de porcentaje
    public static void validarNumPorcentaje(double valor1,double valor2) {

    }


    // método de ingreso por el usuario
    public static Scanner ingresar(){
        Scanner teclado = new Scanner(System.in);
        return teclado;
    }

    // método de validación de entrada
    public static double validarNum(double numero,String mensaje) {
        boolean NumValido = false;
        do{
            System.out.println(mensaje);
            try {
                numero = ingresar().nextDouble();
                NumValido = true;
            }catch (Exception e){
                System.err.println("Error! El número no es válido, ingrese nuevamente");
            }
        }while(!NumValido);
        return numero;
    }


}
