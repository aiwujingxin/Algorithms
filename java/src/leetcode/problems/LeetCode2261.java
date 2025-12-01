package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 11/12/25 16:44
 */
public class LeetCode2261 {

    private static final int BASE1 = 31, BASE2 = 37;
    private static final int MOD1 = 1_000_000_007, MOD2 = 1_000_000_009;

    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] % p == 0 ? 1 : 0;
        }
        int[] sum = new int[n];
        if (n > 0) {
            sum[0] = arr[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + arr[i];
            }
        }
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int prevSum = (i > 0) ? sum[i - 1] : 0;
            int x = prevSum + k;
            int r = findR(sum, x); // 调整 findR，让它从 i 开始查找
            if (r < i) {
                continue;
            }
            long hash1 = 0;
            long hash2 = 0;
            for (int l = i; l <= r; l++) {
                hash1 = (hash1 * BASE1 + nums[l]) % MOD1;
                hash2 = (hash2 * BASE2 + nums[l]) % MOD2;
                set.add(hash1 * MOD2 + hash2);
            }
        }

        return set.size();
    }

    int findR(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] > x)
                r = mid - 1;
            else
                l = mid;
        }
        if (a[l] > x)
            return -1;
        return l;
    }
}
