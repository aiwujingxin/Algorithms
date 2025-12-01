package knowledge.mathematics.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 11/13/25 23:43
 * @description 模运算
 * (x + y) mod m = ((x mod m) + (y mod m)) mod m
 * (x - y) mod m = ((x mod m) - (y mod m)) mod m
 * (x * y) mod m = ((x mod m) * (y mod m)) mod m
 * <p>
 * a ^ b mod m = (a mod m) ^ b mod m
 */
public class HDU1061 {

    public class Main {
        // 快速幂：计算 (a^b) % mod
        public static int modPow(long a, long b, int mod) {
            long res = 1;
            a %= mod;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = (res * a) % mod;
                }
                a = (a * a) % mod;
                b >>= 1;
            }
            return (int) res;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T-- > 0) {
                long n = sc.nextLong();
                System.out.println(modPow(n, n, 10)); // 取个位
            }
            sc.close();
        }
    }
}
