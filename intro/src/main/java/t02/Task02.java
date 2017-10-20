package t02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @task02 Найти наименьший номер последовательности,
 * когда элемент последовательности удовлетворяет условию a(n) < e
 * Элементы последовательности генерируются по формуле: a(n) = 1/pow((n - 2), 2)
 */
public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] seq = new double[n];

        for (int i = 0; i < seq.length; i++) {
            seq[i] = 1 / Math.pow(i + 2, 2);
        }

        System.out.println(Arrays.toString(seq));
        int min = seq.length;
        for (int i = 0; i < seq.length; i++) {
            if (ifElse(seq[i])) {
                if (i < min)
                    min = i;
            }
        }
        System.out.println("Наименьший номер: " + min);
        System.out.println(Arrays.toString(seq));
    }

    public static boolean ifElse(double arg) {
        double eps = 0.01;
        if (arg < eps)
            return true;
        else
            return false;
    }
}
