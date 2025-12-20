package knowledge.mathematics.problems;

import java.io.*;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 01:28
 * @description 区间筛
 */
public class HDU6069 {

    public class Main {
        static final long MOD = 998244353;
        static final int MAX_SQRT = 1000005; // sqrt(10^12)
        static final int MAX_LEN = 1000005;  // r - l <= 10^6

        static boolean[] notPrime = new boolean[MAX_SQRT];
        static int[] primes = new int[MAX_SQRT];
        static int primeCount = 0;

        // 区间数组
        static long[] nums = new long[MAX_LEN]; // 存储 l+i 剩余的数值
        static long[] d = new long[MAX_LEN];    // 存储 l+i 的约数个数结果

        public static void main(String[] args) throws IOException {
            // 1. 预处理小质数
            initPrimes();

            // 快速输入输出
            StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

            in.nextToken();
            int T = (int) in.nval;

            while (T-- > 0) {
                in.nextToken();
                long l = (long) in.nval;
                in.nextToken();
                long r = (long) in.nval;
                in.nextToken();
                long k = (long) in.nval;

                out.println(solve(l, r, k));
            }
            out.flush();
        }

        static void initPrimes() {
            notPrime[0] = notPrime[1] = true;
            for (int i = 2; i < MAX_SQRT; i++) {
                if (!notPrime[i]) {
                    primes[primeCount++] = i;
                }
                for (int j = 0; j < primeCount && i * primes[j] < MAX_SQRT; j++) {
                    notPrime[i * primes[j]] = true;
                    if (i % primes[j] == 0) break;
                }
            }
        }

        static long solve(long l, long r, long k) {
            int len = (int) (r - l + 1);

            // 初始化区间数组
            for (int i = 0; i < len; i++) {
                nums[i] = l + i;
                d[i] = 1;
            }

            // 遍历所有小质数，进行区间筛
            for (int i = 0; i < primeCount; i++) {
                long p = primes[i];

                // 优化：如果 p*p > r，说明剩下的小质数不可能贡献 >=2 的指数了
                // 但为了逻辑完整，通常筛到 sqrt(r)
                // 实际上 p 只要 <= r 都有可能贡献因子
                // 但我们只需要筛到 sqrt(r) 即可，大于 sqrt(r) 的质因子最多只会出现一次
                if (p * p > r && p > r) break; // 稍微松一点的界限

                // 找到区间内第一个 p 的倍数
                // 公式：(l + p - 1) / p * p
                long start = (l + p - 1) / p * p;
                if (start < l) start += p; // 修正一下，虽然公式通常是对的

                // 遍历区间内所有 p 的倍数
                for (long j = start; j <= r; j += p) {
                    int idx = (int) (j - l);
                    int exponent = 0;

                    // 计算 p 的指数
                    while (nums[idx] % p == 0) {
                        exponent++;
                        nums[idx] /= p;
                    }

                    // 更新约数个数公式: ans *= (k * exponent + 1)
                    long term = (k * exponent + 1) % MOD;
                    d[idx] = (d[idx] * term) % MOD;
                }
            }

            // 处理剩余的大质因子
            long totalSum = 0;
            for (int i = 0; i < len; i++) {
                // 如果 nums[i] > 1，说明剩下的 nums[i] 是一个大于 sqrt(r) 的质数
                // 它的指数肯定是 1
                if (nums[i] > 1) {
                    long term = (k * 1 + 1) % MOD;
                    d[i] = (d[i] * term) % MOD;
                }
                totalSum = (totalSum + d[i]) % MOD;
            }

            return totalSum;
        }
    }

}
