package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 9/14/25 14:03
 */
public class LeetCode2346 {

    public long countBadPairs(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = i - nums[i];
            cnt += i - map.getOrDefault(k, 0);
            map.merge(k, 1, Integer::sum);
        }
        return cnt;
    }
}
