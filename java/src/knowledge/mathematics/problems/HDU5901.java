package knowledge.mathematics.problems;

import java.io.*;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 00:55
 * @description 巨大范围素数统计 1<=n<=10^11 范围内素数的个数
 */
public class HDU5901 {

    public class Main {
        //算法核心思路 (Meissel-Lehmer 简化版)
        //我们要计算 π(n) (n以内的质数个数）。
        //根据勒让德公式（Legendre's Formula），我们可以通过递归容斥的方式来计算，但直接递归太慢。Meissel-Lehmer 引入了预处理和组合数学优化。
        //这里提供一份在 ACM/ICPC 圈内广泛使用的、针对 10^11级别优化的 Java 模板。
        static long n;
        static final int M = 320000; // sqrt(1e11) 约为 316227，稍微开大一点
        static long[] dp; // 用于存储大范围的计算结果
        static int[] primes; // 存储小范围质数
        static int[] pi; // 存储小范围质数计数
        static boolean[] isNotPrime;
        static int primeCount;

        public static void main(String[] args) throws IOException {
            // 使用 StreamTokenizer 提高输入速度
            StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

            // 预处理小范围质数 (筛到 M)
            sieve(M);

            while (in.nextToken() != StreamTokenizer.TT_EOF) {
                n = (long) in.nval;
                out.println(solve(n));
            }
            out.flush();
        }

        // 线性筛预处理
        static void sieve(int limit) {
            isNotPrime = new boolean[limit + 1];
            primes = new int[limit + 1];
            pi = new int[limit + 1];
            primeCount = 0;

            for (int i = 2; i <= limit; i++) {
                if (!isNotPrime[i]) {
                    primes[++primeCount] = i;
                }
                for (int j = 1; j <= primeCount && i * primes[j] <= limit; j++) {
                    isNotPrime[i * primes[j]] = true;
                    if (i % primes[j] == 0) break;
                }
                // pi[i] 记录 i 以内的质数个数
                pi[i] = primeCount;
            }
        }

        // Lucy-Richardson / Meissel-Lehmer 核心逻辑
        static long solve(long n) {
            if (n <= M) return pi[(int) n];
            int m = (int) Math.sqrt(n);
            long[] v = new long[2 * m + 10];
            long[] S = new long[2 * m + 10];
            int count = 0;
            for (long i = 1; i <= n; ) {
                long val = n / i;
                long next_i = n / val + 1;
                v[++count] = val;
                S[count] = val - 1;
                i = next_i;
            }
            // 核心 DP 过程
            // 逐步筛掉第 p 个质数的倍数
            for (int p = 1; p <= primeCount; p++) {
                long prime = primes[p];
                long sqrPrime = prime * prime;
                if (sqrPrime > n) break;
                for (int i = 1; i <= count; i++) {
                    long val = v[i];
                    if (sqrPrime > val) break; // 剪枝
                    long target = val / prime;
                    long sub = S[getIndex(target, n, m, count)] - (p - 1);
                    S[i] -= sub;
                }
            }

            return S[1];
        }

        // 辅助函数：给定数值 val，找到它在 v 数组中的下标
        static int getIndex(long val, long n, int m, int count) {
            if (val <= m) {
                return count - (int) val + 1;
            }
            return (int) (n / val); // 这里的映射关系取决于 v 的生成顺序
        }
    }


    public class Main_Min25 {
        static long n;
        static int sqrt_n;
        static int[] primes;
        static int prime_cnt;
        static boolean[] not_prime;

        // w 数组存储分块的值，g 数组存储 DP 结果
        static long[] w;
        static long[] g;
        // id1 和 id2 用于索引映射
        static int[] id1; // 用于 x <= sqrt_n
        static int[] id2; // 用于 x > sqrt_n
        static int m; // 分块数量

        public static void main(String[] args) throws IOException {
            StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

            // 预处理 sqrt(1e11) 约为 320000
            int MAX_SQRT = 320000;
            sieve(MAX_SQRT);

            while (in.nextToken() != StreamTokenizer.TT_EOF) {
                n = (long) in.nval;
                out.println(solve(n));
            }
            out.flush();
        }

        static void sieve(int limit) {
            not_prime = new boolean[limit + 1];
            primes = new int[limit + 1];
            prime_cnt = 0;
            for (int i = 2; i <= limit; i++) {
                if (!not_prime[i]) primes[++prime_cnt] = i;
                for (int j = 1; j <= prime_cnt && i * primes[j] <= limit; j++) {
                    not_prime[i * primes[j]] = true;
                    if (i % primes[j] == 0) break;
                }
            }
        }

        static long solve(long n) {
            if (n <= 1) return 0;
            sqrt_n = (int) Math.sqrt(n);

            // 初始化数组大小
            // 分块数量大约是 2 * sqrt(n)
            int size = 2 * sqrt_n + 10;
            w = new long[size];
            g = new long[size];
            id1 = new int[sqrt_n + 10];
            id2 = new int[sqrt_n + 10];
            m = 0;

            // 1. 数论分块 (整除分块)
            // 将 [1, n] 分成若干个区间，每个区间内 n/i 的值相同
            for (long l = 1, r; l <= n; l = r + 1) {
                r = n / (n / l);
                w[++m] = n / l;

                // 初始化 g[i] = w[i] - 1 (假设所有数都是质数，去掉 1)
                g[m] = w[m] - 1;

                // 建立映射关系
                long val = w[m];
                if (val <= sqrt_n) {
                    id1[(int) val] = m;
                } else {
                    id2[(int) (n / val)] = m;
                }
            }

            // 2. DP 过程 (Min_25 筛的第一部分)
            // 逐步筛掉质数的倍数
            for (int j = 1; j <= prime_cnt; j++) {
                long p = primes[j];
                long p2 = p * p;
                if (p2 > n) break; // 优化：如果 p^2 > n，后面的质数都不用筛了

                // 只需要更新那些 w[i] >= p^2 的块
                for (int i = 1; i <= m && w[i] >= p2; i++) {
                    long k = w[i] / p;
                    // 查找 k 对应的索引
                    int k_idx = (k <= sqrt_n) ? id1[(int) k] : id2[(int) (n / k)];

                    // 转移方程: g[i] = g[i] - (g[k] - (j - 1))
                    // j-1 是前 j-1 个质数的数量
                    g[i] -= (g[k_idx] - (j - 1));
                }
            }

            return g[1]; // g[1] 对应 w[1] = n 的结果
        }
    }


}
