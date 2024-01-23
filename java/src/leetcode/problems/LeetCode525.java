package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 16:15
 */
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(presum[i])) {
                max = Math.max(max, i - map.get(presum[i]));
            } else {
                map.put(presum[i], i);
            }
        }
        return max;
    }
}
