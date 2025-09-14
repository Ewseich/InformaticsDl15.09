import java.math.BigInteger;
import java.util.Scanner;
public class task207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] result = new BigInteger[n+1];
        result[0] = new BigInteger("1");
        result[1] = new BigInteger("2");
        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1].add(result[i-2]);
        }
        System.out.println(result[n]);

    }
}
