package t05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @task05 Построить матрицу:
 *
 * 1 0 0 ---- 0 0 1
 * 0 1 0 ---- 0 1 0
 * 0 0 1 ---- 1 0 0
 * ----------------
 * ----------------
 * ----------------
 * 0 0 1 ---- 1 0 0
 * 0 1 0 ---- 0 1 0
 * 1 0 0 ---- 0 0 1
 */

public class Task05 {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i][i] = 1;
            matrix[i][N - i - 1] = 1;
        }
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
