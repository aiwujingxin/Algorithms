package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 15:10
 */
public class LeetCode2588 {

    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int s = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            s ^= num;
            ans += map.getOrDefault(s, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return ans;
    }
}
