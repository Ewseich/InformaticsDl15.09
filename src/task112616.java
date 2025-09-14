import java.util.Scanner;
public class task112616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[n+1];
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i < 5) {
                count[i] = 1 + count[i-1];
                v[i] = 1;
            }
            else if (i < 6) {
                count[i] = 1 + Math.min(count[i-1], count[i-5]);
                v[i] = 5;
            }
            else {
                count[i] = 1 + Math.min(count[i-1], Math.min(count[i-5], count[i-6]));
                if (count[i-6] <= count[i-5] && count[i-6] <= count[i-1]) v[i] = 6;
                if (count[i-5] <= count[i-1] && count[i-5] <= count[i-6]) v[i] = 5;
                if (count[i-1] <= count[i-5] && count[i-1] <= count[i-6]) v[i] = 1;
            }
        }
        System.out.println(count[n]);
        print_v(v, n);
        for (int i = 0; i <= n; i++) {
            System.out.print(v[i] + " ");
        }

    }
    private static void print_v (int[] v, int n) {
        if (n == 0) return;
        print_v(v, n-v[n]);
        System.out.print(v[n] + " ");
    }
}
