package leetcode.problems;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 6/23/26 21:47
 */
public class LeetCode3282 {

    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        int i = 0;
        long ans = 0;

        while (i < n - 1) {
            // 找右边第一个比 nums[i] 大的数
            int j = i + 1;
            while (j < n - 1 && nums.get(j) <= nums.get(i)) {
                j++;
            }
            // 如果没找到更大的，直接跳到末尾
            if (j == n - 1 && nums.get(j) <= nums.get(i)) {
                j = n - 1;
            }
            ans += (long) (j - i) * nums.get(i);
            i = j;
        }
        return ans;
    }
}
