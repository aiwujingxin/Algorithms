package knowledge.mathematics.algebra.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description MobiusInversion
 */
public class MobiusInversion {
    private int[] mu;
    private int[] primes;
    private boolean[] isPrime;
    private int count;

    /**
     * 线性筛求莫比乌斯函数
     *
     * @param n 求 [1, n] 范围内的 mu
     */
    public MobiusInversion(int n) {
        mu = new int[n + 1];
        primes = new int[n + 1];
        isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        mu[1] = 1;
        count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[count++] = i;
                mu[i] = -1;
            }
            for (int j = 0; j < count && i * primes[j] <= n; j++) {
                isPrime[i * primes[j]] = false;
                if (i % primes[j] == 0) {
                    mu[i * primes[j]] = 0;
                    break;
                } else {
                    mu[i * primes[j]] = -mu[i];
                }
            }
        }
    }

    /**
     * 获取 x 的莫比乌斯函数值
     */
    public int getMu(int x) {
        if (x >= 0 && x < mu.length) {
            return mu[x];
        }
        return 0;
    }

    /**
     * 莫比乌斯反演结合整除分块的例子
     * 求解: sum_{i=1}^{min(n,m)} mu[i] * (n/i) * (m/i)
     */
    public long solve(int n, int m) {
        long ans = 0;
        int min = Math.min(n, m);
        int[] sumMu = new int[min + 1];
        for (int i = 1; i <= min; i++) {
            sumMu[i] = sumMu[i - 1] + mu[i];
        }
        for (int l = 1, r; l <= min; l = r + 1) {
            r = Math.min(n / (n / l), m / (m / l));
            ans += (long) (sumMu[r] - sumMu[l - 1]) * (n / l) * (m / l);
        }
        return ans;
    }
}