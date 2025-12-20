package knowledge.mathematics.problems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 01:03
 * @description 巨大素数判断 数据范围 1<= n<= 2^54 判断 n 是不是素数
 */
public class POJ1811 {

    public class Main {
        static long minFactor; // 用于存储找到的最小质因子

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            while (T-- > 0) {
                while (!st.hasMoreTokens()) {
                    String line = br.readLine();
                    if (line == null) return;
                    st = new StringTokenizer(line);
                }
                long N = Long.parseLong(st.nextToken());

                if (millerRabin(N)) {
                    System.out.println("Prime");
                } else {
                    minFactor = N;
                    pollardRho(N);
                    System.out.println(minFactor);
                }
            }
        }

        // --- 基础工具函数 ---

        // 快速乘：计算 (a * b) % mod，防止 long 溢出
        // 类似于快速幂的原理，将乘法转化为加法
        static long mul(long a, long b, long mod) {
            // Java 8+ Math.multiplyExact 可以检测溢出，但 POJ 版本老
            // 使用二进制拆分法 (龟速乘)，虽然慢一点但安全
            // 或者使用 BigInteger，但太慢。
            // 针对 POJ 1811 的数据范围 < 2^54，直接相乘可能会溢出 (2^54 * 2^54 > 2^63)
            // 优化：利用 (a * b - (long)((double)a / mod * b) * mod + mod) % mod
            // 这种方法利用 double 的精度特性，在 ACM 中常用，速度极快

            long ret = a * b - (long) ((double) a / mod * b) * mod;
            return ret < 0 ? ret + mod : ret;

            // 如果上面的方法在某些极端环境不准，可以用下面的龟速乘（慢logN倍）：
        /*
        long res = 0;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res + a) % mod;
            a = (a + a) % mod;
            b >>= 1;
        }
        return res;
        */
        }

        // 快速幂：计算 (base^exp) % mod
        static long pow(long base, long exp, long mod) {
            long res = 1;
            base %= mod;
            while (exp > 0) {
                if ((exp & 1) == 1) res = mul(res, base, mod);
                base = mul(base, base, mod);
                exp >>= 1;
            }
            return res;
        }

        static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        // --- Miller-Rabin 素性测试 ---

        // 选取底数进行测试
        static boolean check(long a, long n, long x, long t) {
            long ret = pow(a, x, n);
            long last = ret;
            for (int i = 1; i <= t; i++) {
                ret = mul(ret, ret, n);
                if (ret == 1 && last != 1 && last != n - 1) return true; // 合数
                last = ret;
            }
            return ret != 1; // 费马小定理：a^(n-1) != 1 mod n，则是合数
        }

        static boolean millerRabin(long n) {
            if (n < 2) return false;
            if (n == 2) return true;
            if ((n & 1) == 0) return false; // 偶数直接排除

            long x = n - 1;
            long t = 0;
            while ((x & 1) == 0) {
                x >>= 1;
                t++;
            }

            // 选取几个底数进行测试，对于 2^64 范围，选这些足够强
            long[] base = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
            for (long a : base) {
                if (n == a) return true;
                if (check(a, n, x, t)) return false;
            }
            return true;
        }

        // --- Pollard's Rho 质因数分解 ---

        static void pollardRho(long n) {
            if (n == 1) return;

            // 如果已经是质数，更新最小因子
            if (millerRabin(n)) {
                minFactor = Math.min(minFactor, n);
                return;
            }

            // 剪枝：如果当前的 n 已经比找到的最小因子还大，没必要分了
            if (n <= minFactor) return; // 注意这里不能强剪，因为 n 可能是合数，因子可能更小

            long p = n;
            while (p >= n) { // 循环直到找到一个因子
                p = getFactor(n);
            }

            pollardRho(p);
            pollardRho(n / p);
        }

        // 寻找 n 的一个非平凡因子
        static long getFactor(long n) {
            long c = (long) (Math.random() * (n - 1)) + 1;
            long x = (long) (Math.random() * (n - 1)) + 1;
            long y = x;
            long val = 1;

            // Floyd 判圈算法
            for (long k = 2; ; k <<= 1) {
                long ys = y;
                for (long i = 1; i <= k; i++) {
                    // f(x) = (x^2 + c) % n
                    x = (mul(x, x, n) + c) % n;
                    long d = Math.abs(x - y);
                    val = mul(val, d, n); // 积累乘积，减少 gcd 调用次数

                    // 每 127 次或者循环结束时做一次 gcd
                    if (i % 127 == 0) {
                        long g = gcd(val, n);
                        if (g > 1) return g;
                    }
                }
                long g = gcd(val, n);
                if (g > 1) return g;

                y = x;
                if (x == ys) break; // 出现循环，失败，需要重试
            }
            return n; // 失败，返回 n 让外层重试
        }
    }
}
