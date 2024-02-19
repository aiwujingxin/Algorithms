package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 14:53
 */
public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i < presum.length; i++) {
            if (map.containsKey(presum[i] - k)) {
                res += map.get(presum[i] - k);
            }
            map.put(presum[i], map.getOrDefault(presum[i], 0) + 1);
        }
        return res;
    }
}
