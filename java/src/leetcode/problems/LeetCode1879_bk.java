package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 15:55
 */
public class LeetCode1879_bk {

    private int minSum = Integer.MAX_VALUE;
    private int n;
    private int[] nums1;
    private int[] nums2;

    public int minimumXORSum(int[] nums1, int[] nums2) {
        this.n = nums1.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        boolean[] used = new boolean[n];

        dfs(0, 0, used);

        return minSum;
    }

    /**
     * 回溯函数
     *
     * @param index      当前正在为 nums1[index] 寻找匹配
     * @param currentSum 从 nums1[0] 到 nums1[index-1] 已产生的异或和
     * @param used       标记 nums2 中的元素是否被使用
     */
    private void dfs(int index, int currentSum, boolean[] used) {
        // 剪枝：如果当前和已经不小于已找到的最小和，后续不可能更优，直接返回
        if (currentSum >= minSum) {
            return;
        }
        // 递归终止条件：所有 nums1 的元素都已匹配
        if (index == n) {
            minSum = currentSum;
            return;
        }
        // 遍历 nums2 的所有元素作为 nums1[index] 的匹配对象
        for (int j = 0; j < n; j++) {
            // 如果 nums2[j] 未被使用
            if (!used[j]) {
                // 做出选择
                used[j] = true;

                // 递归深入
                dfs(index + 1, currentSum + (nums1[index] ^ nums2[j]), used);

                // 撤销选择（回溯）
                used[j] = false;
            }
        }
    }
}
