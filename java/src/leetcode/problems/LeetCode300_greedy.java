package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 22:51
 * @description dp[i] 代表着表示h的前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值
 */
public class LeetCode300_greedy {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (dp[mid] < num) l = mid + 1;
                else r = mid;
            }
            dp[l] = num;
            if (l == len) {
                len++;
            }
        }
        return len;
    }
}
