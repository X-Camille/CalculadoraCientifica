package org.example;
import java.util.Scanner;
public class operaciones_aritmeticas {

    // atributos
    private static double num1;
    private static double num2;

    // método main
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ingresarOpcion();
            procesarOpcion(opcion);
        }while(opcion!=9);
    }

    // método de inicialización de menú
    public static void iniciar(){
        mostrarOpciones();
        procesarOpcion(ingresarOpcion());
    }
    // método menú
    public static void mostrarOpciones() {
        System.out.println("""
      
            [1] Sumar los dos valores
            [2] Restar los dos valores
            [3] Multiplicar los dos valores
            [4] Dividir los dos valores
            [5] Obtener la potencia
            [6] Obtener el porcentaje
            [7] Mostrar el mayor de los dos valores
            [8] Mostrar el menor de los dos valores
            [9] Finalizar
                """);
    }

    public static int ingresarOpcion() {
        int opcion;
        do {
            System.out.println("Escoja una opción válida:");
            opcion = validarEntradaOpcion();
        } while (opcion < 1 || opcion > 9);
        return opcion;
    }
    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println(">>>INGRESE LOS VALORES PARA REALIZAR LA SUMA");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                System.out.println(num1+" + "+num2+" = "+sumar(num1,num2));
                break;
            case 2:
                System.out.println(">>>INGRESE LOS VALORES PARA REALIZAR LA RESTA");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                System.out.println(num1+" - "+num2+" = "+restar(num1,num2));
                break;
            case 3:
                System.out.println(">>>INGRESE LOS VALORES PARA REALIZAR LA MULTIPLICACIÓN");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                System.out.println(num1+" * "+num2+" = "+multiplicar(num1,num2));
                break;
            case 4:
                System.out.println(">>>INGRESE LOS VALORES PARA REALIZAR LA DIVISIÓN");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                System.out.println(num1+" / "+num2+" = "+dividir(num1,num2));
                break;
            case 5:
                System.out.println("""
                >>>INGRESE LOS VALORES PARA OBTENER LA POTENCIA
                   > EL PRIMER VALOR ES LA BASE DE LA POTENCIA
                   > EL SEGUNDO VALOR ES EL EXPONENTE""");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                System.out.println("La potencia obtenida de "+num1+" ^ "+num2+" es "+potencia(num1,num2));
                break;
            case 6:
                System.out.println("""
                >>>INGRESE LOS VALORES PARA OBTENER EL PORCENTAJE (NO NEGATIVO)
                   > EL PRIMER VALOR INGRESADO SERÁ AL CUAL SE LE CALCULARÁ EL PORCENTAJE
                   > EL SEGUNDO VALOR INGRESADO SERÁ EL PORCENTAJE""");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                System.out.println("El "+num2+"% del número "+num1+" es "+porcentaje(num1,num2));
                break;
            case 7:
                System.out.println(">>>INGRESE LOS VALORES PARA VERIFICAR CUÁL NÚMERO ES MAYOR");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                numMayor(num1,num2);
                break;
            case 8:
                System.out.println(">>>INGRESE LOS VALORES PARA VERIFICAR CUÁL NÚMERO ES MENOR");
                num1 = validarNum(num1,"Ingrese el primer número: ");
                num2 = validarNum(num2,"Ingrese el segundo número: ");
                numMenor(num1,num2);
                break;
            case 9:
                System.out.println("El programa a Finalizado");
                break;
            default:
                System.err.println("Opción inválida! Escoja una opción (Utilizar un número del 1 al 9)");
        }
    }
    public static int validarEntradaOpcion() {
        int entrada = -1;
        try {
            entrada = ingresar().nextInt();
        } catch (Exception e) {
            System.err.println("Opción inválida");
        }
        return entrada;
    }





    // método para el mayor de dos números
    public static void numMayor(double a, double b){
        if(a>b){
            System.out.println("El primer número ingresado es mayor: "+a);
        }else if(b>a){
            System.out.println("El segundo número ingresado es mayor: "+b);
        }else{
            System.out.println("Los números son iguales");
        }
    }

    // método para el menor de dos números
    public static void numMenor(double a, double b){
        if(a<b){
            System.out.println("El primer número ingresado es menor: "+a);
        }else if(b<a){
            System.out.println("El segundo número ingresado es menor: "+b);
        }else{
            System.out.println("Los números son iguales");
        }
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
                }else if(valor2 == 0){
                    System.out.println("El número debe ser distinto de cero, el resultado se mostrará como indefinido/infinito (error matemático)");
                    return;
                }
            }catch (Exception e){
                System.err.println("Error! El número no es válido, ingrese nuevamente");
            }
        }while(!NumValido);
        //return valor1,valor2;
    }

    // método potencia
    public static double potencia(double a, double b){
        // a distinto de b, en términos de que un valor ingresado sea cero
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
                }else{
                    System.out.println("Si uno de los números es cero,el otro debe ser distinto de cero. Ingrese nuevamente");
                    System.out.println("El error matemático se mostrará como resultado: 1.0");
                    return;
                }
            }catch (Exception e){
                System.err.println("Error! El número no es válido, ingrese nuevamente");
            }
        }while(!NumValido);

    }
    // método porcentaje
    public static double porcentaje(double a, double b){
        // a, b no deben ser negativos
        // se puede obtener el o% de un número
        validarNumPorcentaje(a,b);
        double porcentaje = a*(b/100);
        return porcentaje;
    }

    // método de validaciones de porcentaje
    public static void validarNumPorcentaje(double valor1,double valor2) {
        boolean NumValido = false;
        do{
            try {
                if((valor1>=0)&&(valor2>=0)){
                    NumValido = true;
                }else{
                    System.out.println("Los números no pueden ser negativos. Ingrese nuevamente");
                    return;
                }
            }catch (Exception e){
                System.err.println("Error! El número no es válido, ingrese nuevamente");
            }
        }while(!NumValido);
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
            try {
                System.out.println(mensaje);
                numero = ingresar().nextDouble();
                NumValido = true;
            }catch (Exception e){
                System.err.println("Error! El número no es válido, ingrese nuevamente");
            }
        }while(!NumValido);
        return numero;
    }


}
