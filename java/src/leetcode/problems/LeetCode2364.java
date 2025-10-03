package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:04
 */
public class LeetCode2364 {
    public long countBadPairs(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = i - nums[i];
            cnt += i - map.getOrDefault(k, 0); // 减掉下标i之前的相同的元素
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        return cnt;
    }
}
