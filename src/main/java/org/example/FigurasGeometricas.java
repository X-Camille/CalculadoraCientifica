package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.Math.PI;

public class FigurasGeometricas {

    public void iniciarPrograma(){
        Scanner scanner = new Scanner(System.in);
        mostrarOpciones();
        String opcion = scanner.nextLine();
        while(!opcion.equals("0")){
            menu(opcion);
            mostrarOpciones();
            opcion = scanner.nextLine();
        }
    }

    private void menu(String opcion) {
        switch (opcion) {
            case "1":
                calcularDatosCuadrado();
                break;
            case "2":
                calcularDatosRectangulo();
                break;
            case "3":
                calcularDatosCirculo();
                break;
            case "4":
                calcularDatosEsfera();
                break;
            case "5":
                calcularDatosCubo();
                break;
            case "6":
                calcularDatosCono();
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }

    private void mostrarOpciones(){
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectángulo");
        System.out.println("3. Círculo");
        System.out.println("4. Esfera");
        System.out.println("5. Cubo");
        System.out.println("6. Cono");
        System.out.println("0. Salir");
        System.out.print("Seleccione la figura que desea calcular: ");
    }


    // Validación de entradas y manejo de excepciones


    private int obtenerValor() {
        Scanner scanner = new Scanner(System.in);
        int valor;
        do {
            valor = manejarExcepcionDeEntradaInt();
        } while (!valorEsValido(valor));
        return valor;
    }

    public boolean valorEsValido(int valor) {
        if(valor <= 0){
            System.out.println("El valor no puede ser negativo. Inténtelo nuevamente.");
            return false;
        } else if(valor > 100000){
            System.out.println("El valor es demasiado grande. Inténtelo nuevamente");
            return false;
        }
        return true;
    }

    private int manejarExcepcionDeEntradaInt(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                return scanner.nextInt();
            } catch(InputMismatchException e ){
                System.out.print("Entrada no válida. Por favor, ingrese un número entero positivo: ");
                scanner.next();
            }
        }
    }


    // Métodos para el cuadrado
    public void calcularDatosCuadrado(){
        System.out.print("Ingrese el lado del cuadrado: ");
        int lado = obtenerValor();
        System.out.println("El área del cuadrado es: " + calcularAreaCuadrado(lado));
        System.out.println("El perimetro del cuadrado es: " + calcularPerimetroCuadrado(lado));
    }

    public int calcularAreaCuadrado(int lado){
        return lado*lado;
    }

    public int calcularPerimetroCuadrado(int lado){
        return lado*4;
    }


    // Métodos para el rectángulo
    private void calcularDatosRectangulo(){
        System.out.print("Ingrese el largo del rectángulo: ");
        int largo = obtenerValor();
        System.out.print("Ingrese el ancho del rectángulo: ");
        int ancho = obtenerValor();
        System.out.println("El área del rectángulo es: " + calcularAreaRectangulo(ancho, largo));
        System.out.println("El perimetro del rectángulo es: " + calcularPerimetroRectangulo(ancho, largo));
    }

    private int calcularAreaRectangulo(int ancho, int largo){
        return ancho*largo;
    }

    private int calcularPerimetroRectangulo(int ancho, int largo){
        return (ancho*2)+(largo*2);
    }


    // Métodos para el círculo
    private void calcularDatosCirculo(){
        System.out.print("Ingrese el radio del círculo: ");
        int radio = obtenerValor();
        System.out.println("El perimetro del círculo es: " + calcularPerimetroCirculo(radio));
        System.out.println("El área del círculo es: " + calcularAreaCirculo(radio));

    }

    public double calcularPerimetroCirculo(int radio){
        return 2*PI*radio;
    }

    public double calcularAreaCirculo(int radio){
        return PI*Math.pow(radio, 2);
    }




    // Métodos para la esfera
    private void calcularDatosEsfera(){
        System.out.print("Ingrese el radio de la esfera: ");
        int radio = obtenerValor();
        System.out.println("El volumen de la esfera es: " + calcularVolumenEsfera(radio));
        System.out.println("El área superficial del cubo es: " + calcularAreaEsfera(radio));
    }

    private double calcularAreaEsfera(int radio){
        return 4*PI*Math.pow(radio, 2);
    }

    private double calcularVolumenEsfera(int radio){
        return ((double) 4 /3)*PI*Math.pow(radio, 3);
    }


    // Métodos para el cubo
    private void calcularDatosCubo(){
        System.out.print("Ingrese el lado del cubo: ");
        int lado = obtenerValor();
        System.out.println("El volumen del cubo es: " + calcularVolumenCubo(lado));
        System.out.println("El área superficial del cubo es: " + calcularAreaCubo(lado));
        System.out.println("El perímetro del cubo es " + calcularPerimetroCubo(lado));
    }

    private double calcularVolumenCubo(int lado){
        return Math.pow(lado, 3);
    }

    private double calcularAreaCubo(int lado){
        return 6*Math.pow(lado, 2);
    }

    private double calcularPerimetroCubo(int lado){
        return 12*lado;
    }


    // Métodos para el cono
    private void calcularDatosCono() {
        System.out.print("Ingrese el radio del cono: ");
        int radio = obtenerValor();
        System.out.print("Ingrese la altura del cono: ");
        int altura = obtenerValor();
        System.out.println("El área del cono es: " + calcularAreaCono(radio, altura));
        System.out.println("El volumen del cono es: " + calcularVolumenCono(radio, altura));
    }

    public double calcularAreaCono(int radio, int altura){
        double generatriz = Math.sqrt(Math.pow(radio, 2) + Math.pow(altura, 2));
        return PI*Math.pow(radio, 2) + PI*radio*generatriz;
    }

    public double calcularVolumenCono(int radio, int altura){
        return (Math.PI*Math.pow(radio, 2)*altura)/3;
    }

}
