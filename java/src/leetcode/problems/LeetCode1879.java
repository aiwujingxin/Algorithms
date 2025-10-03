package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 15:54
 */
public class LeetCode1879 {

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int maxMask = 1 << n;
        // dp[mask]: nums2 中 mask 对应元素与 nums1 前 k 个元素匹配的最小异或和
        // k = Integer.bitCount(mask)
        int[] dp = new int[maxMask];
        // 初始化 dp 数组为一个极大值，dp[0] 为 0
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 遍历所有状态 mask
        for (int mask = 1; mask < maxMask; mask++) {
            // 计算当前 mask 中有多少个 1，这对应于 nums1 的下标
            // k 个 1 表示我们正在为 nums1[k-1] 寻找匹配
            int k = Integer.bitCount(mask);
            // 遍历 nums2 中的所有元素
            for (int j = 0; j < n; j++) {
                // 检查 nums2[j] 是否在当前 mask 集合中
                if ((mask & (1 << j)) != 0) {
                    // 如果在，说明 nums2[j] 是 nums1[k-1] 的一个可能匹配对象
                    // 找到上一个状态的 mask
                    int prevMask = mask ^ (1 << j);
                    // 如果上一个状态是可达的（不是初始的极大值）
                    if (dp[prevMask] != Integer.MAX_VALUE) {
                        // 计算成本
                        int cost = nums1[k - 1] ^ nums2[j];
                        // 状态转移：尝试用这个新的匹配来更新 dp[mask]
                        dp[mask] = Math.min(dp[mask], dp[prevMask] + cost);
                    }
                }
            }
        }
        // 最终答案是所有元素都匹配完的状态
        return dp[maxMask - 1];
    }
}
