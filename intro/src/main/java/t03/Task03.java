package t03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @task03 Программа для вычисления функции F(x) на отрезне [a, b] через шаг h
 */
public class Task03 {

    static int h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        int a = scanner.nextInt();
        int b;
        System.out.println("Условие b > a");
        do {
            System.out.print("b: ");
            b = scanner.nextInt();
        } while(b < a || b == a);
        System.out.print("Шаг h:");
        h = scanner.nextInt();

        int size = (b - a)/h;
        int [][] tableResults = getResultsFunction(new int[size][2], a);
        toString(tableResults);
    }

    /**
     * Вывод всего содержимого таблицы значений
     * @param tableResults
     */
    private static void toString(int[][] tableResults) {
        for (int[] arr : tableResults) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * Вычисление значений функции
     * @param tableResults
     * @param a
     * @return
     */
    public static int[][] getResultsFunction(int[][] tableResults, int a){
        for (int[] arr : tableResults) {
            arr[0] = a;
            arr[1] = func(a);
            a += h;
        }
        return tableResults;
    }

    /**
     * Функция F(x)
     * @param x
     * @return
     */
    public static int func(int x){
        return (int) (Math.tan(2*x) - 3);
    }
}
