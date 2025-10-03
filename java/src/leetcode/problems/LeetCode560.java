package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 17:25
 */
public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = 0;
        int cnt = 0;
        map.put(0, 1);
        for (int num : nums) {
            s += num;
            cnt += map.getOrDefault(s - k, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return cnt;
    }
}
