package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 14:53
 */
public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : presum) {
            if (map.containsKey(num - k)) {
                cnt += map.get(num - k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }
}
