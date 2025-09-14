import java.util.Scanner;
public class task912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] result = new long[n+1];
        result[0] = 1;
        result[1] = 2;
        if (n > 1)  result[2] = 4;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i-1] + result[i-3] + result[i-2];
        }
        System.out.println(result[n]);

    }
}
