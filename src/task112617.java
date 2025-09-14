import java.util.Scanner;
import java.util.Arrays;

public class task112617 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] startV = new int[k];
        for (int l = 0; l < k; l++) {
            startV[l] = sc.nextInt();
        }
        Arrays.sort(startV);
        int[] count = new int[n+1];
        int[] v = new int[n+1];
        v[1] = startV[0];
        for (int i = 1; i <= n; i++) {
            v[i] = startV[0];
            int j = 0;
            int res = 0;
            while (j < k && startV[j] <= i) {
                if (count[i - v[i]] <= count[i-startV[j]]) {
                    res = count[i - v[i]];
                }
                else {
                    res = count[i - startV[j]];
                    v[i] = startV[j];
                }
                j++;
            }
            count[i] = 1 + res;
        }
        if (check(v, n)) {
            System.out.println(count[n]);
            print_v(v, n);
        }
    }
    private static void print_v (int[] v, int n) {
        if (n == 0) return;
        print_v(v, n-v[n]);
        System.out.print(v[n] + " ");
    }
    private static boolean check (int[] v, int n) {
        if (n == 0) return true;
        if (n < 0) {
            System.out.println(-1);
            return false;
        }
        return check(v, n-v[n]);

    }
}