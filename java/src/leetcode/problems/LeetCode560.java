package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 17:25
 */
public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            cnt += map.getOrDefault(presum[i] - k, 0);
            map.put(presum[i], map.getOrDefault(presum[i], 0) + 1);
        }
        return cnt;
    }
}
