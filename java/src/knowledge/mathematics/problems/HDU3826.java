package knowledge.mathematics.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 01:25
 * @description - 如果一个数N的所有质因子的指数都为1，则它是 Square-free。
 * 换句话说，如果存在任意质数 p，使得p^2 能整除 N，那么 N 就不是 Square-free。
 */
public class HDU3826 {

    public class Main {
        static final int MAX_LIMIT = 1000005;
        static boolean[] notPrime = new boolean[MAX_LIMIT];
        static int[] primes = new int[MAX_LIMIT];
        static int primeCount = 0;

        public static void main(String[] args) throws IOException {
            initPrimes();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            for (int t = 1; t <= T; t++) {
                while (!st.hasMoreTokens()) {
                    String line = br.readLine();
                    if (line == null) return;
                    st = new StringTokenizer(line);
                }
                long N = Long.parseLong(st.nextToken());
                if (solve(N)) {
                    System.out.println("Case " + t + ": Yes");
                } else {
                    System.out.println("Case " + t + ": No");
                }
            }
        }

        static void initPrimes() {
            notPrime[0] = true;
            notPrime[1] = true;
            for (int i = 2; i < MAX_LIMIT; i++) {
                if (!notPrime[i]) {
                    primes[primeCount++] = i;
                }
                for (int j = 0; j < primeCount && i * primes[j] < MAX_LIMIT; j++) {
                    notPrime[i * primes[j]] = true;
                    if (i % primes[j] == 0) break;
                }
            }
        }

        static boolean solve(long n) {
            // 步骤 1: 用 10^6 以内的质数去试除
            for (int i = 0; i < primeCount; i++) {
                long p = primes[i];
                // 如果 p^3 > n，其实可以提前结束循环，但为了逻辑简单，
                // 我们只判断 p*p*p 是否溢出或者 p 是否太大
                if (p * p * p > n) break;

                if (n % p == 0) {
                    n /= p;
                    // 如果除了一次 p 之后还能被 p 整除，说明有 p^2 因子
                    if (n % p == 0) {
                        return false; // 含有平方因子
                    }
                }
            }

            // 步骤 2: 检查剩余部分
            // 此时 n 的所有质因子都大于 10^6 (或者 n 剩下的质因子可能稍小但不足以构成平方，
            // 比如 n 原本是 p*q，p被除掉了，剩下q)
            // 实际上经过上面的循环，n 中不可能包含 <= 10^6 的质因子的平方。
            // 剩下的 n 要么是 1，要么是素数，要么是素数的乘积，要么是素数的平方。
            // 唯一需要警惕的是：剩下的 n 是一个大质数的平方。

            if (n == 1) return true;

            // 判断 n 是否为完全平方数
            // 使用 Math.sqrt 计算平方根，注意精度
            long root = (long) Math.sqrt(n);
            return root * root != n; // 是完全平方数，即 root^2 | n
        }
    }

}
