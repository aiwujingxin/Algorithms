package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/17/26 20:41
 */
public class LeetCode2601 {

    public boolean primeSubOperation(int[] nums) {
        int maxNum = 1000;
        boolean[] isPrime = new boolean[maxNum + 1];
        for (int i = 2; i <= maxNum; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= maxNum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int[] primes = new int[168];
        int idx = 0;
        for (int i = 2; i <= maxNum; i++) {
            if (isPrime[i]) {
                primes[idx++] = i;
            }
        }
        int prev = 0;
        for (int num : nums) {
            int target = num - prev - 1;
            int pIdx = findR(primes, target);
            int p = primes[pIdx];
            int newVal = num - p;
            if (newVal <= prev) {
                if (num > prev) {
                    prev = num;
                    continue;
                } else {
                    return false;
                }
            }
            prev = newVal;
        }
        return true;
    }

    private int findR(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] > x) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}
