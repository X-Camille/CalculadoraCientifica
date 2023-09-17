import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.Math.*;

class CalculadoraCientifica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = obtenerValor(scanner, "Ingrese el valor de a: ");
        double b = obtenerValor(scanner, "Ingrese el valor de b: ");
        double c = obtenerValor(scanner, "Ingrese el valor de c: ");

        scanner.close();

        calcularEcuacionCuadratica(a, b, c);
    }

    public static double obtenerValor(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                // Limpiar el búfer del scanner y mostrar un mensaje de error
                scanner.nextLine(); // Limpiar el búfer
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }

    public static void calcularEcuacionCuadratica(double a, double b, double c) {
        try {
            double[] soluciones = ecuCuadratica(a, b, c);
            if (soluciones != null) {
                System.out.println("Las soluciones de la ecuación cuadrática son:");
                System.out.println("Solución 1: " + soluciones[0]);
                System.out.println("Solución 2: " + soluciones[1]);
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double[] ecuCuadratica(double a, double b, double c) {
        double[] soluciones = new double[2];
        if (a == 0) {
            throw new IllegalArgumentException("No es una ecuación cuadrática");
        } else {
            double discriminante = b * b - 4 * a * c;
            if (discriminante < 0) {
                throw new IllegalArgumentException("Solución imaginaria");
            } else if (a == 0) {
                throw new ArithmeticException("División por cero");
            } else {
                soluciones[0] = (-b + sqrt(discriminante)) / (2 * a);
                soluciones[1] = (-b - sqrt(discriminante)) / (2 * a);
            }
        }
        return soluciones;
    }
}
