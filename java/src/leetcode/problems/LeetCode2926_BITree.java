package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 10/4/24 12:53
 * <a href="https://leetcode.cn/problems/maximum-balanced-subsequence-sum/solutions/2513121/shu-zhuang-shu-zu-you-hua-dp-by-endlessc-3zf4/"></a>
 * <a href="https://leetcode.cn/problems/maximum-balanced-subsequence-sum/"></a>
 */
public class LeetCode2926_BITree {

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = nums[i] - i;
        }
        Arrays.sort(b);
        BITree_max_1d t = new BITree_max_1d(b.length + 1);
        for (int i = 0; i < n; i++) {
            // j 为 nums[i]-i 离散化后的值（从 1 开始）
            int j = Arrays.binarySearch(b, nums[i] - i) + 1;
            long f = Math.max(t.max(j), 0) + nums[i];
            t.update(j, f);
        }
        return t.max(b.length);
    }

    static class BITree_max_1d {

        private final long[] tree;

        public BITree_max_1d(int n) {
            tree = new long[n];
            Arrays.fill(tree, Long.MIN_VALUE);
        }

        public void update(int i, long val) {
            while (i < tree.length) {
                tree[i] = Math.max(tree[i], val);
                i += i & -i;
            }
        }

        public long max(int i) {
            long res = Long.MIN_VALUE;
            while (i > 0) {
                res = Math.max(res, tree[i]);
                i &= i - 1;
            }
            return res;
        }
    }
}
