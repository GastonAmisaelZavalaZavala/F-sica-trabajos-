import java.util.Scanner;

import java.util.Scanner;

public class VectorOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tamaño de los vectores
        System.out.print("Ingrese el tamaño de los vectores: ");
        int n = scanner.nextInt();

        // Declaración de vectores
        String[] vectorA = new String[n];
        String[] vectorB = new String[n];

        // Ingreso de elementos para el vector A
        System.out.println("Ingrese los elementos del vector A:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vectorA[i] = scanner.next();
        }

        // Ingreso de elementos para el vector B
        System.out.println("Ingrese los elementos del vector B:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vectorB[i] = scanner.next();
        }

        // Suma de vectores
        String[] suma = new String[n];
        for (int i = 0; i < n; i++) {
            suma[i] = vectorA[i] + vectorB[i];
        }

        // Resta de vectores
        String[] resta = new String[n];
        for (int i = 0; i < n; i++) {
            resta[i] = vectorA[i] + "-" + vectorB[i];
        }

        // Mostrar resultados
        System.out.println("\nResultado de la suma:");
        mostrarVector(suma);

        System.out.println("\nResultado de la resta:");
        mostrarVector(resta);

        scanner.close();
    }

    // Método para mostrar un vector
    private static void mostrarVector(String[] vector) {
        System.out.print("[ ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}