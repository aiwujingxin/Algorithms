package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 14:56
 */
public class LeetCode762 {

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            if (isPrime(hammingWeight(i))) {
                ans++;
            }
        }
        return ans;
    }

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }

    public boolean isPrime(int x) {
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


