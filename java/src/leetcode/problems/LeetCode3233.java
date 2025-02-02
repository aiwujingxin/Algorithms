package leetcode.problems;

import knowledge.mathematics.impl.Prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 1/6/25 23:19
 */
public class LeetCode3233 {

    public int nonSpecialCount_TEL(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            int t = isSqrt(i);
            if (Prime.isPrime(t)) {
                res++;
            }
        }
        return r - l + 1 - res;
    }


    public int isSqrt(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (i * i == x) {
                return i;
            }
        }
        return -1;
    }

    public int nonSpecialCount0(int l, int r) {
        int cnt = 0;
        for (int i = 2; i * i <= r; i++) {
            if (i * i < l) {
                continue;
            }
            if (Prime.isPrime(i)) {
                cnt++;
            }
        }
        return r - l + 1 - cnt;
    }

    public int nonSpecialCount(int l, int r) {
        int n = (int) Math.floor(Math.sqrt(r)) + 1;
        boolean[] dp = new boolean[n];
        int cnt = 0;
        dp[1] = true;
        for (int i = 2; i * i <= r; i++) {
            if (!dp[i]) {
                if (i * i >= l) {
                    cnt++;
                }
                for (int j = 2; j * i < n; j++) {
                    dp[i * j] = true;
                }
            }
        }
        return r - l + 1 - cnt;
    }

    // 2
    private static final int MX = 31622;
    private static final int[] PI = new int[MX + 1];

    static {
        for (int i = 2; i <= MX; i++) {
            if (PI[i] == 0) { // i 是质数
                PI[i] = PI[i - 1] + 1;
                for (int j = i * i; j <= MX; j += i) { // 注：如果 MX 比较大，小心 i*i 溢出
                    PI[j] = -1; // 标记 i 的倍数为合数
                }
            } else {
                PI[i] = PI[i - 1];
            }
        }
    }

    public int nonSpecialCount2(int l, int r) {
        return r - l + 1 - (PI[(int) Math.sqrt(r)] - PI[(int) Math.sqrt(l - 1)]);
    }

    // 3
    static int[] pre;

    static {
        List<Integer> allSpecial = new ArrayList<>();
        int max = (int) Math.sqrt(1e9);
        boolean[] primes = fastCalcPrimes(max);
        for (int i = 2; i < max; i++) {
            if (primes[i]) {
                allSpecial.add(i * i);
            }
        }
        pre = allSpecial.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean[] fastCalcPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public int nonSpecialCount3(int l, int r) {
        int p1 = findL(r);
        int p0 = findR(l);
        return r - l + 1 - (p1 - p0 + 1);
    }

    private int findR(int x) {
        int l = 0;
        int r = pre.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (pre[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (pre[l] < x) {
            return l + 1;
        }
        return l;
    }

    private int findL(int x) {
        int l = 0;
        int r = pre.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (pre[mid] > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (pre[l] > x) {
            return l - 1;
        }
        return l;
    }
}
