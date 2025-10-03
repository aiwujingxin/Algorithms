package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:37
 */
public class LeetCode3233_v3 {

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

    public int nonSpecialCount(int l, int r) {
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
