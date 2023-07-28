package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 16:07
 */
public class LeetCode325 {

    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        map.put(0, 0);
        int ans = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            int target = sum - k;
            Integer idx = map.get(target);
            if (idx != null) {
                ans = Math.max(ans, i - idx);
            }
            map.putIfAbsent(sum, i);
        }
        return ans;
    }
}
