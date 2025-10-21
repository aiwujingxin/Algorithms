package leetcode.problems;

import knowledge.datastructure.adv.BITree_Max;
import knowledge.datastructure.adv.BITree_RangeMax;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 10/4/24 12:53
 * <a href="https://leetcode.cn/problems/maximum-balanced-subsequence-sum/solutions/2513121/shu-zhuang-shu-zu-you-hua-dp-by-endlessc-3zf4/"></a>
 */
public class LeetCode2926 {

    class Solution {
        public long maxBalancedSubsequenceSum(int[] nums) {
            int n = nums.length;
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = nums[i] - i;
            }
            Arrays.sort(b);
            BITree_Max t = new BITree_Max(b.length + 1);
            for (int i = 0; i < n; i++) {
                // j 为 nums[i]-i 离散化后的值（从 1 开始）
                int j = Arrays.binarySearch(b, nums[i] - i) + 1;
                long f = Math.max(t.max(j), 0) + nums[i];
                t.update(j, f);
            }
            return t.max(b.length);
        }
    }

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] key = new int[n];
        for (int i = 0; i < n; i++) key[i] = nums[i] - i;
        // 离散化（去重）
        int[] sorted = key.clone();
        Arrays.sort(sorted);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) sorted[m++] = sorted[i];
        }
        BITree_RangeMax fw = new BITree_RangeMax(m);
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = findL(sorted, m, key[i]) + 1; // 1-based
            long best = fw.rangeMax(1, j); // 前缀最大
            if (best < 0) best = 0;
            long f = best + nums[i];
            fw.updateMax(j, f);
            ans = Math.max(ans, f);
        }
        return ans;
    }

    private int findL(int[] a, int len, int x) {
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
