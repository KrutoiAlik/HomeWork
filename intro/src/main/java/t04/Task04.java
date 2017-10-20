package t04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @task04 Найти max(a(1) + a(n - 1), a(2) + a(n - 2), ..., a(n/2 - 1) + a(n/2)),
 * где a - множество действительных чисел, i - значения от 1 до n
 */
public class Task04 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        Random random = new Random();
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = random.nextInt(1000);
        }
        int max = 0;
        for (int i = 0; i < N / 2; i++) {
            if(seq[i] + seq[N - i - 1] > max)
                max = seq[i] + seq[N - i - 1];
        }
        System.out.println(Arrays.toString(seq));
        System.out.println("Max " + max);

    }
}
