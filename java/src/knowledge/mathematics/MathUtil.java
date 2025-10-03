package knowledge.mathematics;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 1/11/25 11:13
 */
public class MathUtil {

    static final long MOD = 1_000_000_007; // 可换成题目给定的模数
    static final int N = 100000;           // 组合数预处理上限，可按题目规模调整

    // ========== 向上取整除法 ==========
    public static int ceilDiv(int a, int b) {
        return (a + b - 1) / b;
    }

    // ========== 最大公约数 & 最小公倍数 ==========
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int gcd(int[] nums) {
        if (nums.length == 0)
            return 0;
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
            if (gcd == 1)
                break;
        }
        return gcd;
    }

    public static long lcm(long a, long b) {
        return a / gcd((int) a, (int) b) * b;
    }

    // ==========  快速幂（模幂运算） ==========
    public static long modPow(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }

    // ==========  取模（保证非负） ==========
    public static int mod(int x, int m) {
        return (x % m + m) % m;
    }

    // ==========  组合数 (预处理 + 快速幂逆元) ==========
    static long[] fact = new long[N + 1];
    static long[] invFact = new long[N + 1];

    static {
        initComb();
    }

    private static void initComb() {
        fact[0] = 1;
        for (int i = 1; i <= N; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[N] = modPow(fact[N], MOD - 2, MOD);
        for (int i = N; i > 0; i--) invFact[i - 1] = invFact[i] * i % MOD;
    }

    public static long C(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    // ==========  倍数取整 ==========
    public static int upToMultiple(int x, int k) {
        return ceilDiv(x, k) * k;
    }

    public static int downToMultiple(int x, int k) {
        return (x / k) * k;
    }

    // ========== 因子 ==========
    public int factors(int number) {
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors.size();
    }

    public int primeFactors(int num) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                set.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            set.add(num);
        }
        return set.size();
    }

    public static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
